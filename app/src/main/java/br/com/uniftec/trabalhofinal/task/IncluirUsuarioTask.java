package br.com.uniftec.trabalhofinal.task;

import android.os.AsyncTask;

import java.io.IOException;

import br.com.uniftec.trabalhofinal.model.ResponseStatus;
import br.com.uniftec.trabalhofinal.model.Resposta;
import br.com.uniftec.trabalhofinal.model.UsuarioPUT;
import br.com.uniftec.trabalhofinal.service.UsuarioServicePUT;
import br.com.uniftec.trabalhofinal.util.ServerCommunicationUtil;
import retrofit2.Response;
import retrofit2.Call;

/**
 * Created by lececatto on 16/11/2017.
 */

public class IncluirUsuarioTask extends AsyncTask<UsuarioPUT, Void, Resposta<String>>{

    private IncluirUsuarioDelegate delegate;
    private UsuarioServicePUT usuarioServicePUT;

    public IncluirUsuarioTask(IncluirUsuarioDelegate delegate){
        this.usuarioServicePUT = ServerCommunicationUtil.getInstance().getRetrofit().create(UsuarioServicePUT.class);
        this.delegate = delegate;
    }

    @Override
    protected Resposta<String> doInBackground(UsuarioPUT... usuarioPUTs) {

        Call<Resposta<String>> call = usuarioServicePUT.salvarUsuario(usuarioPUTs[0]);

        try {
            Response<Resposta<String>> response = call.execute();
            return response.body();
        } catch (IOException e){
            e.printStackTrace();
        }

        return null;
    }

    public interface IncluirUsuarioDelegate {
        public void incluirUsuarioSucesso(String token);
        public void incluirUsuarioFalha(String erro);
    }

    @Override
    protected void onPostExecute(Resposta<String> resposta) {

        if(resposta.getStatus() == ResponseStatus.SUCCESS){
            delegate.incluirUsuarioSucesso(resposta.getData());
        } else {
            delegate.incluirUsuarioFalha(resposta.getMessage());
        }

    }
}
