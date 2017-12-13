package br.com.uniftec.trabalhofinal.service;

import br.com.uniftec.trabalhofinal.model.Resposta;
import br.com.uniftec.trabalhofinal.model.endereco.EnderecoPUT;
import br.com.uniftec.trabalhofinal.model.usuario.UsuarioPOSTResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.PUT;

/**
 * Created by lececatto on 12/12/2017.
 */

public interface EnderecoService {

    @PUT("/usuario/endereco")
    public Call<Resposta<UsuarioPOSTResponse>> insereEndereco(@Body EnderecoPUT enderecoPUT, @Header("X-Token") String token);
}
