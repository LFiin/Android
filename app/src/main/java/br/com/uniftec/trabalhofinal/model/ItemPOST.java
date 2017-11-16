package br.com.uniftec.trabalhofinal.model;

/**
 * Created by lececatto on 15/11/2017.
 */

public class ItemPOST {

    public ItemPOST(String id, ProdutoPOST produto, String valor) {
        this.id = id;
        this.produto = produto;
        this.valor = valor;
    }

    private String id;

    private ProdutoPOST produto;

    private String valor;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ProdutoPOST getProduto() {
        return produto;
    }

    public void setProduto(ProdutoPOST produto) {
        this.produto = produto;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
