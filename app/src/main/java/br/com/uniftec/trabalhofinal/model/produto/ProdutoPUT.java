package br.com.uniftec.trabalhofinal.model.produto;

import java.util.List;

import br.com.uniftec.trabalhofinal.model.categoria.CategoriaPUT;
import br.com.uniftec.trabalhofinal.model.imagem.ImagemPUT;

/**
 * Created by lececatto on 15/11/2017.
 */

public class ProdutoPUT {

    public ProdutoPUT(CategoriaPUT categoria, String descricao, String id, ImagemPUT imagemPrincipal
                     , List<ImagemPUT> imagens, String nome, String preco, String precoDesconto) {
        this.categoria = categoria;
        this.descricao = descricao;
        this.id = id;
        this.imagemPrincipal = imagemPrincipal;
        this.imagens = imagens;
        this.nome = nome;
        this.preco = preco;
        this.precoDesconto = precoDesconto;
    }

    private CategoriaPUT categoria;

    private String descricao;

    private String id;

    private ImagemPUT imagemPrincipal;

    private List<ImagemPUT> imagens;

    private String nome;

    private String preco;

    private String precoDesconto;

    public CategoriaPUT getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaPUT categoria) {
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

    public ImagemPUT getImagemPrincipal() {
        return imagemPrincipal;
    }

    public void setImagemPrincipal(ImagemPUT imagemPrincipal) {
        this.imagemPrincipal = imagemPrincipal;
    }

    public List<ImagemPUT> getImagens() {
        return imagens;
    }

    public void setImagens(List<ImagemPUT> imagens) {
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
