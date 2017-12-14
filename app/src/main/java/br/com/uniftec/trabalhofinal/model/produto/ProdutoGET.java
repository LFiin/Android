package br.com.uniftec.trabalhofinal.model.produto;

import java.util.List;

import br.com.uniftec.trabalhofinal.model.categoria.CategoriaGET;
import br.com.uniftec.trabalhofinal.model.imagem.ImagemGET;

/**
 * Created by lececatto on 15/11/2017.
 */

public class ProdutoGET {

    public ProdutoGET(CategoriaGET categoria, String descricao, Double id, ImagemGET imagemPrincipal
                     , List<ImagemGET> imagens, String nome, Double preco, Double precoDesconto) {
        this.categoria = categoria;
        this.descricao = descricao;
        this.id = id;
        this.imagemPrincipal = imagemPrincipal;
        this.imagens = imagens;
        this.nome = nome;
        this.preco = preco;
        this.precoDesconto = precoDesconto;
    }

    public ProdutoGET(){}

    private CategoriaGET categoria;

    private String descricao;

    private Double id;

    private ImagemGET imagemPrincipal;

    private List<ImagemGET> imagens;

    private String nome;

    private Double preco;

    private Double precoDesconto;

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

    public Double getId() {
        return id;
    }

    public void setId(Double id) {
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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Double getPrecoDesconto() {
        return precoDesconto;
    }

    public void setPrecoDesconto(Double precoDesconto) {
        this.precoDesconto = precoDesconto;
    }
}
