package br.com.uniftec.trabalhofinal.model;

import java.util.List;

/**
 * Created by lececatto on 15/11/2017.
 */

public class ProdutoGET {

    public ProdutoGET( CategoriaGET categoria, String descricao, String id, ImagemGET imagemPrincipal
                     , List<ImagemGET> imagens, String nome, String preco, String precoDesconto) {
        this.categoria = categoria;
        this.descricao = descricao;
        this.id = id;
        this.imagemPrincipal = imagemPrincipal;
        this.imagens = imagens;
        this.nome = nome;
        this.preco = preco;
        this.precoDesconto = precoDesconto;
    }

    private CategoriaGET categoria;

    private String descricao;

    private String id;

    private ImagemGET imagemPrincipal;

    private List<ImagemGET> imagens;

    private String nome;

    private String preco;

    private String precoDesconto;

    public CategoriaGET getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaGET categoria) {
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

    public ImagemGET getImagemPrincipal() {
        return imagemPrincipal;
    }

    public void setImagemPrincipal(ImagemGET imagemPrincipal) {
        this.imagemPrincipal = imagemPrincipal;
    }

    public List<ImagemGET> getImagens() {
        return imagens;
    }

    public void setImagens(List<ImagemGET> imagens) {
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
