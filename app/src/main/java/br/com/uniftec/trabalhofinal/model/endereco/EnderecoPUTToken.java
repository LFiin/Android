package br.com.uniftec.trabalhofinal.model.endereco;

/**
 * Created by lececatto on 12/12/2017.
 */

public class EnderecoPUTToken {

    public EnderecoPUTToken(EnderecoPUT enderecoPUT, String token) {
        this.enderecoPUT = enderecoPUT;
        this.token = token;
    }

    public EnderecoPUTToken(){}

    private EnderecoPUT enderecoPUT;
    private String token;

    public EnderecoPUT getEnderecoPUT() {
        return enderecoPUT;
    }

    public void setEnderecoPUT(EnderecoPUT enderecoPUT) {
        this.enderecoPUT = enderecoPUT;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
