package br.com.uniftec.trabalhofinal.task;

import android.os.AsyncTask;

import java.io.IOException;
import java.util.List;

import br.com.uniftec.trabalhofinal.model.ResponseStatus;
import br.com.uniftec.trabalhofinal.model.Resposta;
import br.com.uniftec.trabalhofinal.model.produto.ProdutoGET;
import br.com.uniftec.trabalhofinal.model.produto.ProdutoGETSend;
import br.com.uniftec.trabalhofinal.service.ProdutoService;
import br.com.uniftec.trabalhofinal.util.ServerCommunicationUtil;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by lececatto on 14/12/2017.
 */

public class ReceberProdutosTask extends AsyncTask<ProdutoGETSend, Void, Resposta<List<ProdutoGET>>>{

    private ReceberProdutosDelegate delegate;
    private ProdutoService produtoService;

    public ReceberProdutosTask(ReceberProdutosDelegate delegate){
        this.produtoService = ServerCommunicationUtil.getInstance().getRetrofit().create(ProdutoService.class);
        this.delegate = delegate;
    }

    @Override
    protected Resposta<List<ProdutoGET>> doInBackground(ProdutoGETSend... produtoGETSends) {

        Call<Resposta<List<ProdutoGET>>> call = produtoService.recebeProdutos(produtoGETSends[0].getDestaques(), produtoGETSends[0].getCategoriaId());

        try {
            Response<Resposta<List<ProdutoGET>>> response = call.execute();
            return response.body();
        } catch (IOException e){
            e.printStackTrace();
        }

        return null;
    }

    public interface ReceberProdutosDelegate {
        public void receberProdutosSucesso(List<ProdutoGET> produtoGETs);
        public void receberProdutosFalha(String erro);
    }

    @Override
    protected void onPostExecute(Resposta<List<ProdutoGET>> listResposta) {

        if (listResposta.getStatus() == ResponseStatus.SUCCESS){
            delegate.receberProdutosSucesso(listResposta.getData());
        } else {
            delegate.receberProdutosFalha(listResposta.getMessage());
        }
    }
}
