package br.com.uniftec.trabalhofinal.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by Fin on 09/11/2017.
 */

public class Pedido {

    private int idPedido;

    private Double valor;

    private String status;

    private Endereco endereco;

    private String data;

    private List<Produto> produtos;

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Pedido criaPedido(Pedido p){

        Endereco e = new Endereco();
        Produto prod = new Produto();

        prod.criaProdutos(prod);

        List listProdutos = new ArrayList();

        listProdutos.add(prod);

        String[] datas = {"11/09/2017", "03/12/1993", "08/12/2010", "13/07/2017", "10/06/2008"};
        Double[] precos = {140.50, 200.45, 775.90, 125.00, 69.99, 1589.99, 700.00};
        String[] statuses = {"Enviado", "Em Processamento", "Em Separação", "Cancelado", "Aguardando Pagamento"};

        p.setData(datas[getRandomValue(0, 4)]);

        p.setEndereco(e.criaEndereco(e));
        p.setValor(precos[getRandomValue(0, 6)]);
        p.setStatus(statuses[getRandomValue(0, 4)]);
        p.setProdutos(listProdutos);

        return p;

    }


    private static int getRandomValue(int low, int high) {
        return new Random().nextInt(high - low) + low;
    }

}
