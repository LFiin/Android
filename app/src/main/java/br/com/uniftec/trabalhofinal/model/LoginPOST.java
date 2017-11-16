package br.com.uniftec.trabalhofinal.model;

/**
 * Created by lececatto on 15/11/2017.
 */

public class LoginPOST {

    public LoginPOST(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    private String email;

    private String senha;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
