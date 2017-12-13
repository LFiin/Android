package br.com.uniftec.trabalhofinal.task;

import android.os.AsyncTask;

import java.io.IOException;
import java.util.List;

import br.com.uniftec.trabalhofinal.model.ResponseStatus;
import br.com.uniftec.trabalhofinal.model.Resposta;
import br.com.uniftec.trabalhofinal.model.categoria.CategoriaGET;
import br.com.uniftec.trabalhofinal.service.CategoriaService;
import br.com.uniftec.trabalhofinal.util.ServerCommunicationUtil;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by lececatto on 12/12/2017.
 */

public class ReceberCategoriasTask extends AsyncTask<Void, Void, Resposta<List<CategoriaGET>>> {

    private ReceberCategoriasDelegate delegate;
    private CategoriaService categoriaService;

    public ReceberCategoriasTask(ReceberCategoriasDelegate delegate){
        this.categoriaService = ServerCommunicationUtil.getInstance().getRetrofit().create(CategoriaService.class);
        this.delegate = delegate;
    }

    @Override
    protected Resposta<List<CategoriaGET>> doInBackground(Void... voids) {

        Call<Resposta<List<CategoriaGET>>> call = categoriaService.recebeCategorias();

        try {
            Response<Resposta<List<CategoriaGET>>> response = call.execute();
            return response.body();
        } catch (IOException e){
            e.printStackTrace();
        }

        return null;
    }

    public interface ReceberCategoriasDelegate {
        public void receberCategoriasSucesso(List<CategoriaGET> categoriaGETs);
        public void receberCategoriasFalha(String erro);
    }

    @Override
    protected void onPostExecute(Resposta<List<CategoriaGET>> listResposta) {

        if (listResposta.getStatus() == ResponseStatus.SUCCESS){
            delegate.receberCategoriasSucesso(listResposta.getData());
        } else {
            delegate.receberCategoriasFalha(listResposta.getMessage());
        }
    }
}
