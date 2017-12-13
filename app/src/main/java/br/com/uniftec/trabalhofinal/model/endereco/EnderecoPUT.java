package br.com.uniftec.trabalhofinal.model.endereco;

/**
 * Created by lececatto on 15/11/2017.
 */

public class EnderecoPUT {

    public EnderecoPUT(String bairro, String cidade, String complemento, String estado, String logradouro, String numero) {
        this.bairro = bairro;
        this.cidade = cidade;
        this.complemento = complemento;
        this.estado = estado;
        this.logradouro = logradouro;
        this.numero = numero;
    }

    public EnderecoPUT(){}

    private String bairro;

    private String cidade;

    private String complemento;

    private String estado;

    private String logradouro;

    private String numero;

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
