package br.com.uniftec.trabalhofinal.model;

import android.widget.Toast;

import java.io.Serializable;
import java.util.List;
import java.util.Random;


/**
 * Created by lececatto on 28/10/2017.
 */

public class Produto implements Serializable{

    private int id;

    private String titulo;

    private String descricao;

    private String imagemPrincipal;

    private List<String> listaImagens;

    private Double preco;

    private Double precoDesconto;

    private Categoria categoria;

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

        String[] titulos = {"Headset Razer Kraken 7.1", "Memória Kingston HyperX FURY 4GB DDR4", "Processador Intel Core i9-7900x", "Mouse Logitech G402 Hyperion Fury", "Teclado HyperX Alloy Elite", "Monitor LED ASUS 24"};
        Double[] precos = {14.50, 200.45, 75.90, 25.00, 69.99, 1589.99, 700.00};
        String[] descricoes = {"\"Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
               "Etiam eget ligula eu lectus lobortis condimentum.", "Aliquam nonummy auctor massa.",
               "Quis custodiet ipsos custodes?"};

        String[] imagensPrincipais = {"C:\\Users\\Fin\\Desktop\\FTEC\\2017-2\\Android\\workspace\\TrabalhoFinal\\app\\src\\main\\res\\drawable\\fone1.jpg",
                "C:\\Users\\Fin\\Desktop\\FTEC\\2017-2\\Android\\workspace\\TrabalhoFinal\\app\\src\\main\\res\\drawable\\teclado1.jpg",
                "C:\\Users\\Fin\\Desktop\\FTEC\\2017-2\\Android\\workspace\\TrabalhoFinal\\app\\src\\main\\res\\drawable\\mouse11.jpg",
                "C:\\Users\\Fin\\Desktop\\FTEC\\2017-2\\Android\\workspace\\TrabalhoFinal\\app\\src\\main\\res\\drawable\\processador1.jpg",
                "C:\\Users\\Fin\\Desktop\\FTEC\\2017-2\\Android\\workspace\\TrabalhoFinal\\app\\src\\main\\res\\drawable\\monitor1.jpg",
                "C:\\Users\\Fin\\Desktop\\FTEC\\2017-2\\Android\\workspace\\TrabalhoFinal\\app\\src\\main\\res\\drawable\\memoria1.jpg"};

        p.setTitulo(titulos[getRandomValue(0, 5)]);
        p.setPreco(precos[getRandomValue(0, 5)]);
        p.setDescricao(descricoes[getRandomValue(0, 3)]);
        p.setImagemPrincipal("C:\\Users\\Fin\\Desktop\\FTEC\\2017-2\\Android\\workspace\\TrabalhoFinal\\app\\src\\main\\res\\drawable\\fone1.jpg");

      /*  System.out.println("Antes do p.setImagemPrincipal");
        p.setImagemPrincipal(imagensPrincipais[getRandomValue(0, 5)]);
        System.out.println("Depois do p.setImagemPrincipal" + p.getImagemPrincipal());*/

        return p;

    }

    private static int getRandomValue(int low, int high) {
        return new Random().nextInt(high - low) + low;
    }


}

