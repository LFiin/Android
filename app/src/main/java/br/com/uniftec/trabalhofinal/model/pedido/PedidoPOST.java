package br.com.uniftec.trabalhofinal.model.pedido;

import java.util.List;

import br.com.uniftec.trabalhofinal.model.endereco.EnderecoPOST;
import br.com.uniftec.trabalhofinal.model.item.ItemPOST;

/**
 * Created by lececatto on 15/11/2017.
 */

public class PedidoPOST {

    public PedidoPOST(String data, EnderecoPOST enderecoEntrega, String id, List<ItemPOST> itens, String status, String total) {
        this.data = data;
        this.enderecoEntrega = enderecoEntrega;
        this.id = id;
        this.itens = itens;
        this.status = status;
        this.total = total;
    }

    private String data;

    private EnderecoPOST enderecoEntrega;

    private String id;

    private List<ItemPOST> itens;

    private String status;

    private String total;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public EnderecoPOST getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(EnderecoPOST enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ItemPOST> getItens() {
        return itens;
    }

    public void setItens(List<ItemPOST> itens) {
        this.itens = itens;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
