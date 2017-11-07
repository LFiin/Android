package br.com.uniftec.trabalhofinal.model;

import java.util.List;
import java.util.Random;

/**
 * Created by lececatto on 28/10/2017.
 */

public class Produto {

    private int id;

    private String titulo;

    private String descricao;

    private String imagemPrincipal;

    private List<String> listaImagens;

    private Double preco;

    private Double precoDesconto;

    private Categoria categoria;

    public Produto(String titulo, Double preco, String descricao) {
        this.titulo = titulo;
        this.preco = preco;
        this.descricao = descricao;
    }

    public Produto(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagemPrincipal() {
        return imagemPrincipal;
    }

    public void setImagemPrincipal(String imagemPrincipal) {
        this.imagemPrincipal = imagemPrincipal;
    }

    public List<String> getListaImagens() {
        return listaImagens;
    }

    public void setListaImagens(List<String> listaImagens) {
        this.listaImagens = listaImagens;
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Produto criaProdutos(Produto p){
         String[] titulos = {"Fone de Ouvido", "Memória RAM", "Processador", "Mouse", "Teclado", "Monitor"};
         Double[] precos = {14.50, 200.45, 75.90, 25.00, 69.99, 1589.99, 700.00};
         String[] descricoes = {"\"Lorem ipsum dolor sit amet, consectetur adipiscing elit.\n " +
                "Etiam eget ligula eu lectus lobortis condimentum.\n Aliquam nonummy auctor massa.\"",
                "\"Quis custodiet ipsos custodes?\""};

        p.setTitulo(titulos[getRandomValue(0, 5)]);
        p.setPreco(precos[getRandomValue(0, 5)]);
        p.setDescricao(descricoes[getRandomValue(0, 2)]);

        return p;


       /* return new Produto(titulos[getRandomValue(0, 5)],
                precos[getRandomValue(0, 5)],
                descricoes[getRandomValue(0, 2)]);*/
    }

    private static int getRandomValue(int low, int high) {
        return new Random().nextInt(high - low) + low;
    }
    
}
