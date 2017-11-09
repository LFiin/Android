package br.com.uniftec.trabalhofinal.ui;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

import br.com.uniftec.trabalhofinal.R;
import br.com.uniftec.trabalhofinal.model.Produto;

/**
 * Created by Fin on 08/11/2017.
 */

public class ProdutoActivity extends AbstractActivity {

    public static final String PRODUTO_PARAMETER = "PRODUTO_PARAMETER";

    private Produto produto;
    private ImageView imagem;
    private TextView txtTitulo;
    private TextView txtPreco;
    private TextView txtDescricao;
    public Context meuContext;


    @Override
    protected void setupView() {

        System.out.println("Entrou no setupView");

        produto = (Produto) getIntent().getSerializableExtra(PRODUTO_PARAMETER);

        imagem = (ImageView) findViewById(R.id.activity_produto_imagem);
        /*int idImagem = this.getResources().getIdentifier(produto.getImagemPrincipal(),"drawable", getPackageName());

        try {
            imagem.setImageDrawable(getDrawable(idImagem));
        } catch (OutOfMemoryError e) {
            imagem.setImageDrawable(null);
        }*/

        txtTitulo = (TextView) findViewById(R.id.activity_produto_titulo);
        txtTitulo.setText(produto.getTitulo());

        txtPreco = (TextView) findViewById(R.id.activity_produto_preco);
        txtPreco.setText("R$ " + String.format(Locale.getDefault(), "%.2f", produto.getPreco()));

        txtDescricao = (TextView) findViewById(R.id.activity_produto_descricao);
        txtDescricao.setText(produto.getDescricao());
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_produto;
    }

}
