package br.com.uniftec.trabalhofinal.model.endereco;

/**
 * Created by lececatto on 12/12/2017.
 */

public class EnderecoDELETE {

    public EnderecoDELETE(String token, Long id) {
        this.token = token;
        this.id = id;
    }

    public EnderecoDELETE(){}

    private String token;
    private Long id;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
