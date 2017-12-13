package br.com.uniftec.trabalhofinal.model.categoria;

/**
 * Created by lececatto on 15/11/2017.
 */

public class CategoriaPOST {

    public CategoriaPOST(String id, String nome) {
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
