package br.com.uniftec.trabalhofinal.model;

/**
 * Created by lececatto on 15/11/2017.
 */

public class CategoriaGET {

    public CategoriaGET(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    private String id;

    private String nome;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
