package br.com.uniftec.trabalhofinal.model;

import java.util.List;

/**
 * Created by lececatto on 15/11/2017.
 */

public class UsuarioPOST {

    public UsuarioPOST(String cpf, String email, List<EnderecoPOST> enderecos, Long id, String nome, String telefone) {
        this.cpf = cpf;
        this.email = email;
        this.enderecos = enderecos;
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
    }

    private String cpf;

    private String email;

    private List<EnderecoPOST> enderecos;

    private Long id;

    private String nome;

    private String telefone;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<EnderecoPOST> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<EnderecoPOST> enderecos) {
        this.enderecos = enderecos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
