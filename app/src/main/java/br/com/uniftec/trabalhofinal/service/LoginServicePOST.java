package br.com.uniftec.trabalhofinal.service;

import br.com.uniftec.trabalhofinal.model.LoginPOST;
import br.com.uniftec.trabalhofinal.model.Resposta;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by lececatto on 07/12/2017.
 */

public interface LoginServicePOST {

    @POST("/usuario/login")
    public Call<Resposta<String>> validaLogin(@Body LoginPOST loginPOST);
}
