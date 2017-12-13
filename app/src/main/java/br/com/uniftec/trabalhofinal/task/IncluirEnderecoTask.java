package br.com.uniftec.trabalhofinal.task;

import android.os.AsyncTask;

import java.io.IOException;

import br.com.uniftec.trabalhofinal.model.ResponseStatus;
import br.com.uniftec.trabalhofinal.model.Resposta;
import br.com.uniftec.trabalhofinal.model.endereco.EnderecoPUTToken;
import br.com.uniftec.trabalhofinal.model.usuario.UsuarioPOSTResponse;
import br.com.uniftec.trabalhofinal.service.EnderecoService;
import br.com.uniftec.trabalhofinal.util.ServerCommunicationUtil;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by lececatto on 12/12/2017.
 */

public class IncluirEnderecoTask extends AsyncTask<EnderecoPUTToken, Void, Resposta<UsuarioPOSTResponse>>{

    private IncluirEnderecoDelegate delegate;
    private EnderecoService enderecoService;

    public IncluirEnderecoTask(IncluirEnderecoDelegate delegate){
        this.enderecoService = ServerCommunicationUtil.getInstance().getRetrofit().create(EnderecoService.class);
        this.delegate = delegate;
    }

    @Override
    protected Resposta<UsuarioPOSTResponse> doInBackground(EnderecoPUTToken... enderecoPUTTokens) {

        Call<Resposta<UsuarioPOSTResponse>> call = enderecoService.insereEndereco(enderecoPUTTokens[0].getEnderecoPUT(), enderecoPUTTokens[0].getToken());

        try {
            Response<Resposta<UsuarioPOSTResponse>> response = call.execute();
            return response.body();
        } catch (IOException e){
            e.printStackTrace();
        }

        return null;
    }

    public interface IncluirEnderecoDelegate {
        public void incluirEnderecoSucesso(UsuarioPOSTResponse usuarioPOSTResponse);
        public void incluirEnderecoFalha(String erro);
    }

    @Override
    protected void onPostExecute(Resposta<UsuarioPOSTResponse> usuarioPOSTResponseResposta) {

        if (usuarioPOSTResponseResposta.getStatus() == ResponseStatus.SUCCESS){
            delegate.incluirEnderecoSucesso(usuarioPOSTResponseResposta.getData());
        } else {
            delegate.incluirEnderecoFalha(usuarioPOSTResponseResposta.getMessage());
        }
    }
}
