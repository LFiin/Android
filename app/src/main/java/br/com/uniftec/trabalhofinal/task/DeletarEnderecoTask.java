package br.com.uniftec.trabalhofinal.task;

import android.os.AsyncTask;

import java.io.IOException;

import br.com.uniftec.trabalhofinal.model.ResponseStatus;
import br.com.uniftec.trabalhofinal.model.Resposta;
import br.com.uniftec.trabalhofinal.model.endereco.EnderecoDELETE;
import br.com.uniftec.trabalhofinal.model.usuario.UsuarioPOSTResponse;
import br.com.uniftec.trabalhofinal.service.EnderecoService;
import br.com.uniftec.trabalhofinal.util.ServerCommunicationUtil;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by lececatto on 12/12/2017.
 */

public class DeletarEnderecoTask extends AsyncTask<EnderecoDELETE, Void, Resposta<UsuarioPOSTResponse>>{

    private DeletarEnderecoDelegate delegate;
    private EnderecoService enderecoService;

    public DeletarEnderecoTask(DeletarEnderecoDelegate delegate){
        this.enderecoService = ServerCommunicationUtil.getInstance().getRetrofit().create(EnderecoService.class);
        this.delegate = delegate;
    }

    @Override
    protected Resposta<UsuarioPOSTResponse> doInBackground(EnderecoDELETE... enderecoDELETEs) {
        Call<Resposta<UsuarioPOSTResponse>> call = enderecoService.deletaEndereco(enderecoDELETEs[0].getToken(), enderecoDELETEs[0].getId());

        try {
            Response<Resposta<UsuarioPOSTResponse>> response = call.execute();
            return response.body();
        } catch (IOException e){
            e.printStackTrace();
        }

        return null;
    }

    public interface DeletarEnderecoDelegate {
        public void deletarEnderecoSucesso(UsuarioPOSTResponse usuarioPOSTResponse);
        public void deletarEnderecoFalha(String erro);
    }

    @Override
    protected void onPostExecute(Resposta<UsuarioPOSTResponse> usuarioPOSTResponseResposta) {

        if (usuarioPOSTResponseResposta.getStatus() == ResponseStatus.SUCCESS){
            delegate.deletarEnderecoSucesso(usuarioPOSTResponseResposta.getData());
        } else {
            delegate.deletarEnderecoFalha(usuarioPOSTResponseResposta.getMessage());
        }
    }
}
