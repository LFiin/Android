package br.com.uniftec.trabalhofinal.service;

import br.com.uniftec.trabalhofinal.model.Resposta;
import br.com.uniftec.trabalhofinal.model.usuario.UsuarioGET;
import br.com.uniftec.trabalhofinal.model.usuario.UsuarioPOST;
import br.com.uniftec.trabalhofinal.model.usuario.UsuarioPOSTResponse;
import br.com.uniftec.trabalhofinal.model.usuario.UsuarioPUT;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;

/**
 * Created by lececatto on 16/11/2017.
 */

public interface UsuarioService {

    @PUT("/usuario")
    public Call<Resposta<String>> salvaUsuario(@Body UsuarioPUT usuarioPUT);

    @GET("/usuario")
    public Call<Resposta<UsuarioGET>> recebeUsuario(@Header("X-Token") String token);

    //Para passar 2 params usar object;
    @POST("/usuario")
    public Call<Resposta<UsuarioPOSTResponse>> atualizaUsuario(@Body UsuarioPOST usuarioPOST, @Header("X-Token") String token);
}
