package br.com.uniftec.trabalhofinal.task;

import android.os.AsyncTask;

import java.io.IOException;

import br.com.uniftec.trabalhofinal.model.LoginPOST;
import br.com.uniftec.trabalhofinal.model.ResponseStatus;
import br.com.uniftec.trabalhofinal.model.Resposta;
import br.com.uniftec.trabalhofinal.service.LoginServicePOST;
import br.com.uniftec.trabalhofinal.util.ServerCommunicationUtil;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by lececatto on 07/12/2017.
 */

public class ValidarLoginTask extends AsyncTask<LoginPOST, Void, Resposta<String>>{

    private ValidarLoginDelegate delegate;
    private LoginServicePOST loginServicePOST;

    public ValidarLoginTask(ValidarLoginDelegate delegate){
        this.loginServicePOST = ServerCommunicationUtil.getInstance().getRetrofit().create(LoginServicePOST.class);
        this.delegate = delegate;
    }

    @Override
    protected Resposta<String> doInBackground(LoginPOST... loginPOSTs) {

        Call<Resposta<String>> call = loginServicePOST.validaLogin(loginPOSTs[0]);

        try {
            Response<Resposta<String>> response = call.execute();
            return response.body();
        } catch (IOException e ){
            e.printStackTrace();
        }

        return null;
    }

    public interface ValidarLoginDelegate {
        public void validarUsuarioSucesso(String token);
        public void validarUsuarioFalha(String erro);
    }

    @Override
    protected void onPostExecute(Resposta<String> resposta) {
        if (resposta.getStatus() == ResponseStatus.SUCCESS){
            // ENQUANTO ERRO NO SERVIDOR
            //delegate.incluirUsuarioSucesso(resposta.getData());
            delegate.validarUsuarioSucesso(resposta.getMessage());
        } else {
            delegate.validarUsuarioFalha(resposta.getMessage());
        }
    }
}
