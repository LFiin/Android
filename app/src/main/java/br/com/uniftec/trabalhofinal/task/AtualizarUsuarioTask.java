package br.com.uniftec.trabalhofinal.task;

import android.os.AsyncTask;

import java.io.IOException;

import br.com.uniftec.trabalhofinal.model.ResponseStatus;
import br.com.uniftec.trabalhofinal.model.Resposta;
import br.com.uniftec.trabalhofinal.model.usuario.UsuarioPOSTResponse;
import br.com.uniftec.trabalhofinal.model.usuario.UsuarioPOSTToken;
import br.com.uniftec.trabalhofinal.service.UsuarioService;
import br.com.uniftec.trabalhofinal.util.ServerCommunicationUtil;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by lececatto on 12/12/2017.
 */

public class AtualizarUsuarioTask extends AsyncTask<UsuarioPOSTToken, Void, Resposta<UsuarioPOSTResponse>>{

    private AtualizarUsuarioDelegate delegate;
    private UsuarioService usuarioService;

    public AtualizarUsuarioTask(AtualizarUsuarioDelegate delegate){
        this.usuarioService = ServerCommunicationUtil.getInstance().getRetrofit().create(UsuarioService.class);
        this.delegate = delegate;
    }

    @Override
    protected Resposta<UsuarioPOSTResponse> doInBackground(UsuarioPOSTToken... usuarioPOSTTokens) {
        Call<Resposta<UsuarioPOSTResponse>> call = usuarioService.atualizaUsuario(usuarioPOSTTokens[0].getUsuarioPOST(),usuarioPOSTTokens[0].getToken());

        try {
            Response<Resposta<UsuarioPOSTResponse>> response = call.execute();
            return response.body();
        } catch (IOException e){
            e.printStackTrace();
        }

        return null;
    }

    public interface AtualizarUsuarioDelegate {
        public void atualizarUsuarioSucesso(UsuarioPOSTResponse usuarioPOSTResponse);
        public void atualizarUsuarioFalha(String erro);
    }

    @Override
    protected void onPostExecute(Resposta<UsuarioPOSTResponse> usuarioPOSTResponseResposta) {

        if (usuarioPOSTResponseResposta.getStatus() == ResponseStatus.SUCCESS){
            delegate.atualizarUsuarioSucesso(usuarioPOSTResponseResposta.getData());
        } else {
            delegate.atualizarUsuarioFalha(usuarioPOSTResponseResposta.getMessage());
        }
    }
}
