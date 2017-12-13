package br.com.uniftec.trabalhofinal.model.item;

import br.com.uniftec.trabalhofinal.model.produto.ProdutoGET;

/**
 * Created by lececatto on 15/11/2017.
 */

public class ItemGET {

    public ItemGET(String id, ProdutoGET produto, String valor) {
        this.id = id;
        this.produto = produto;
        this.valor = valor;
    }

    private String id;

    private ProdutoGET produto;

    private String valor;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ProdutoGET getProduto() {
        return produto;
    }

    public void setProduto(ProdutoGET produto) {
        this.produto = produto;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
