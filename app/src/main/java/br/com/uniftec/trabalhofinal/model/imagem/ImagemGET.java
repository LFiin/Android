package br.com.uniftec.trabalhofinal.model.imagem;

/**
 * Created by lececatto on 15/11/2017.
 */

public class ImagemGET {

    public ImagemGET(String id, String url) {
        this.id = id;
        this.url = url;
    }

    private String id;

    private String url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
