package br.com.uniftec.trabalhofinal.model;

import java.util.List;

/**
 * Created by lececatto on 15/11/2017.
 */

public class PedidoPUT {

    public PedidoPUT( String cartaoCredito, String codigoSeguranca, String idEnderecoUsuario
                    , List<ProdutoPUT> produtos, String validadeCartaoCredito) {
        this.cartaoCredito = cartaoCredito;
        this.codigoSeguranca = codigoSeguranca;
        this.idEnderecoUsuario = idEnderecoUsuario;
        this.produtos = produtos;
        this.validadeCartaoCredito = validadeCartaoCredito;
    }

    private String cartaoCredito;

    private String codigoSeguranca;

    private String idEnderecoUsuario;

    private List<ProdutoPUT> produtos;

    private String validadeCartaoCredito;

    public String getCartaoCredito() {
        return cartaoCredito;
    }

    public void setCartaoCredito(String cartaoCredito) {
        this.cartaoCredito = cartaoCredito;
    }

    public String getCodigoSeguranca() {
        return codigoSeguranca;
    }

    public void setCodigoSeguranca(String codigoSeguranca) {
        this.codigoSeguranca = codigoSeguranca;
    }

    public String getIdEnderecoUsuario() {
        return idEnderecoUsuario;
    }

    public void setIdEnderecoUsuario(String idEnderecoUsuario) {
        this.idEnderecoUsuario = idEnderecoUsuario;
    }

    public List<ProdutoPUT> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoPUT> produtos) {
        this.produtos = produtos;
    }

    public String getValidadeCartaoCredito() {
        return validadeCartaoCredito;
    }

    public void setValidadeCartaoCredito(String validadeCartaoCredito) {
        this.validadeCartaoCredito = validadeCartaoCredito;
    }
}
