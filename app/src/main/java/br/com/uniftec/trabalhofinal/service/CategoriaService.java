package br.com.uniftec.trabalhofinal.service;

import java.util.List;

import br.com.uniftec.trabalhofinal.model.Resposta;
import br.com.uniftec.trabalhofinal.model.categoria.CategoriaGET;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by lececatto on 12/12/2017.
 */

public interface CategoriaService {

    @GET("/produto/categorias")
    public Call<Resposta<List<CategoriaGET>>> recebeCategorias();
}
