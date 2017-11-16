package br.com.uniftec.trabalhofinal.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Locale;

import br.com.uniftec.trabalhofinal.R;
import br.com.uniftec.trabalhofinal.model.Produto;

import static android.widget.Toast.*;

/**
 * Created by Fin on 08/11/2017.
 */

public class ProdutoActivity extends AbstractActivity {

    public static final String PRODUTO_PARAMETER = "PRODUTO_PARAMETER";

    private Produto produto;
    private ImageView imagem;
    private TextView txtTitulo;
    private TextView txtPreco;
    private TextView txtPrecoDesconto;
    private TextView txtDescricao;
    private Toolbar toolbar;
    private Button btnAddCesta;
    private Button btnVoltar;
    public Context meuContext;


    @Override
    protected void setupView() {

        meuContext = this;

        produto = (Produto) getIntent().getSerializableExtra(PRODUTO_PARAMETER);

        imagem = (ImageView) findViewById(R.id.activity_produto_imagem);

        txtTitulo = (TextView) findViewById(R.id.activity_produto_titulo);
        txtTitulo.setText(produto.getTitulo());

        txtPreco = (TextView) findViewById(R.id.activity_produto_preco);
        txtPreco.setText("Preço: R$ " + String.format(Locale.getDefault(), "%.2f", produto.getPreco()));

        txtPrecoDesconto = (TextView) findViewById(R.id.activity_produto_precoDesconto);
        txtPrecoDesconto.setText("Preço Desconto: R$ " + String.format(Locale.getDefault(), "%.2f", produto.getPrecoDesconto()));

        txtDescricao = (TextView) findViewById(R.id.activity_produto_descricao);
        txtDescricao.setText(produto.getDescricao());

        btnAddCesta = (Button) findViewById(R.id.activity_produto_add_cesta);
        btnAddCesta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(meuContext, CarrinhoActivity.class);

                intent.putExtra(ProdutoActivity.PRODUTO_PARAMETER, produto);

                meuContext.startActivity(intent);

            }
        });

        btnVoltar = (Button) findViewById(R.id.activity_produto_voltar);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_produto;
    }

    private void alert(String s){
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }

}
