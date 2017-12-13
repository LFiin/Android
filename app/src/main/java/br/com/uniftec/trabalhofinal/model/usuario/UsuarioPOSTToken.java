package br.com.uniftec.trabalhofinal.model.usuario;

/**
 * Created by lececatto on 12/12/2017.
 */

public class UsuarioPOSTToken {

    public UsuarioPOSTToken(UsuarioPOST usuarioPOST, String token) {
        this.usuarioPOST = usuarioPOST;
        this.token = token;
    }

    UsuarioPOSTToken(){}

    private UsuarioPOST usuarioPOST;
    private String token;

    public UsuarioPOST getUsuarioPOST() {
        return usuarioPOST;
    }

    public void setUsuarioPOST(UsuarioPOST usuarioPOST) {
        this.usuarioPOST = usuarioPOST;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
