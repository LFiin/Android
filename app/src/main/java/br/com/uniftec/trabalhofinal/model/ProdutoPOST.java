package br.com.uniftec.trabalhofinal.model;

import java.util.List;

/**
 * Created by lececatto on 15/11/2017.
 */

public class ProdutoPOST {

    public ProdutoPOST(CategoriaPOST categoria, String descricao, String id, ImagemPOST imagemPrincipal
                     , List<ImagemPOST> imagens, String nome, String preco, String precoDesconto) {
        this.categoria = categoria;
        this.descricao = descricao;
        this.id = id;
        this.imagemPrincipal = imagemPrincipal;
        this.imagens = imagens;
        this.nome = nome;
        this.preco = preco;
        this.precoDesconto = precoDesconto;
    }

    private CategoriaPOST categoria;

    private String descricao;

    private String id;

    private ImagemPOST imagemPrincipal;

    private List<ImagemPOST> imagens;

    private String nome;

    private String preco;

    private String precoDesconto;

    public CategoriaPOST getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaPOST categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ImagemPOST getImagemPrincipal() {
        return imagemPrincipal;
    }

    public void setImagemPrincipal(ImagemPOST imagemPrincipal) {
        this.imagemPrincipal = imagemPrincipal;
    }

    public List<ImagemPOST> getImagens() {
        return imagens;
    }

    public void setImagens(List<ImagemPOST> imagens) {
        this.imagens = imagens;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getPrecoDesconto() {
        return precoDesconto;
    }

    public void setPrecoDesconto(String precoDesconto) {
        this.precoDesconto = precoDesconto;
    }
}
