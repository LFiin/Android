package br.com.uniftec.trabalhofinal.model.produto;

/**
 * Created by lececatto on 14/12/2017.
 */

public class ProdutoGETSend {

    public ProdutoGETSend(Boolean destaques, Long categoriaId) {
        this.destaques = destaques;
        this.categoriaId = categoriaId;
    }

    public ProdutoGETSend(){}

    private Boolean destaques;
    private Long categoriaId;

    public Boolean getDestaques() {
        return destaques;
    }

    public void setDestaques(Boolean destaques) {
        this.destaques = destaques;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }
}
