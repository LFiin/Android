package br.com.uniftec.trabalhofinal.task;

import android.os.AsyncTask;

import java.io.IOException;

import br.com.uniftec.trabalhofinal.model.ResponseStatus;
import br.com.uniftec.trabalhofinal.model.Resposta;
import br.com.uniftec.trabalhofinal.model.UsuarioGET;
import br.com.uniftec.trabalhofinal.service.UsuarioService;
import br.com.uniftec.trabalhofinal.util.ServerCommunicationUtil;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by lececatto on 12/12/2017.
 */

public class ReceberUsuarioTask extends AsyncTask<String, Void, Resposta<UsuarioGET>> {

    private ReceberUsuarioDelegate delegate;
    private UsuarioService usuarioService;

    public ReceberUsuarioTask(ReceberUsuarioDelegate delegate){
        this.usuarioService = ServerCommunicationUtil.getInstance().getRetrofit().create(UsuarioService.class);
        this.delegate = delegate;
    }

    @Override
    protected Resposta<UsuarioGET> doInBackground(String... strings) {

        Call<Resposta<UsuarioGET>> call = usuarioService.recebeUsuario(strings[0]);

        try {
            Response<Resposta<UsuarioGET>> response = call.execute();
            return response.body();
        } catch (IOException e){
            e.printStackTrace();
        }

        return null;
    }

    public interface ReceberUsuarioDelegate {
        public void receberUsuarioSucesso(UsuarioGET usuarioGET);
        public void receberUsuarioFalha(String erro);
    }

    @Override
    protected void onPostExecute(Resposta<UsuarioGET> usuarioGETResposta) {

        if (usuarioGETResposta.getStatus() == ResponseStatus.SUCCESS){
            delegate.receberUsuarioSucesso(usuarioGETResposta.getData());
        } else {
            delegate.receberUsuarioFalha(usuarioGETResposta.getMessage());
        }

    }
}
