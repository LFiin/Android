package br.com.uniftec.trabalhofinal.service;

import br.com.uniftec.trabalhofinal.model.Resposta;
import br.com.uniftec.trabalhofinal.model.UsuarioPOST;
import br.com.uniftec.trabalhofinal.model.UsuarioPUT;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;

/**
 * Created by lececatto on 16/11/2017.
 */

public class UsuarioServicePUT {

    @PUT("/usuario")
    public Call<Resposta<String>> salvarUsuario(@Body UsuarioPUT usuarioPUT) {
        return null;
    }

    //Para passar 2 params usar object;
    @POST
    public Call<Resposta<UsuarioPOST>> atualizaUsuario(@Body UsuarioPOST usuarioPOST, @Header("X-Token") String token) {
        return null;
    }
}
