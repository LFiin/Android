package br.com.uniftec.trabalhofinal.model.categoria;

/**
 * Created by lececatto on 15/11/2017.
 */

public class CategoriaGET {

    public CategoriaGET(Double id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public CategoriaGET(){}

    private Double id;

    private String nome;

    public Double getId() {
        return id;
    }

    public void setId(Double id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
