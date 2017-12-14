package br.com.uniftec.trabalhofinal.service;

import java.util.List;

import br.com.uniftec.trabalhofinal.model.Resposta;
import br.com.uniftec.trabalhofinal.model.produto.ProdutoGET;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by lececatto on 14/12/2017.
 */

public interface ProdutoService {

    @GET("/produto")
    public Call<Resposta<List<ProdutoGET>>> recebeProdutos(@Query("destaques") Boolean destaques, @Query("categoria-id") Long categoriaId);
}
