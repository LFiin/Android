package br.com.uniftec.trabalhofinal.model.usuario;

import java.util.List;

import br.com.uniftec.trabalhofinal.model.endereco.EnderecoGET;

/**
 * Created by lececatto on 15/11/2017.
 */

public class UsuarioGET {

    public UsuarioGET(String cpf, String email, List<EnderecoGET> enderecos, Double id, String nome, String telefone) {
        this.cpf = cpf;
        this.email = email;
        this.enderecos = enderecos;
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
    }

    public UsuarioGET(){}

    private String cpf;

    private String email;

    private List<EnderecoGET> enderecos;

    private Double id;

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

    public List<EnderecoGET> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<EnderecoGET> enderecos) {
        this.enderecos = enderecos;
    }

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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
