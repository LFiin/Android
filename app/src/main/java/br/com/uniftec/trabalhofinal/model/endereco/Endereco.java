package br.com.uniftec.trabalhofinal.model.endereco;

import java.util.Random;

/**
 * Created by lececatto on 28/10/2017.
 */

public class Endereco {

    private int id;

    private String rua;

    private int numero;

    private String complemento;

    private String bairro;

    private String cidade;

    private String estado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Endereco criaEndereco(Endereco end){

        String[] ruas = {"Rua José Bisol", "Rua Angelina Michelon", "Rua Sinumbu", "Avenida Rio Branco", "BR-116", "Avenida Júlio de Castilhos"};
        Integer[] numeros = {1450, 2045, 790, 250, 69, 1589, 7};
        String[] complementos = {"AP 42", "", "AP 704", "Casa dos Fundos"};
        String[] bairros = {"Lourdes", "Centro", "Panazzolo", "Cinquentenário", "Pio X", "Ana Rech"};
        String[] cidades = {"Caxias do Sul", "Farroupilha", "Bento Gonçalves", "Flores da Cunha"};
        String[] estados ={"RS", "SC", "PR", "SP", "GO", "MG"};

        end.setRua(ruas[getRandomValue(0, 5)]);
        end.setNumero(numeros[getRandomValue(0, 6)]);
        end.setComplemento(complementos[getRandomValue(0, 3)]);
        end.setBairro(bairros[getRandomValue(0,5)]);
        end.setCidade(cidades[getRandomValue(0,3)]);
        end.setEstado(estados[getRandomValue(0,5)]);

        return end;

    }

    private static int getRandomValue(int low, int high) {
        return new Random().nextInt(high - low) + low;
    }

    public String toString(Endereco endereco){
        String result = endereco.getRua() + ", "
                + endereco.getNumero() + ", "
                + endereco.getComplemento() + " - "
                + endereco.getBairro() + " - "
                + endereco.getCidade() + "/"
                + endereco.getEstado();

        return result;
    }



}
