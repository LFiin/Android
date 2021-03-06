package br.com.uniftec.trabalhofinal.ui;

import android.content.Context;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

import br.com.uniftec.trabalhofinal.R;
import br.com.uniftec.trabalhofinal.model.produto.Produto;

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

                alert("Produto adicionado ao carrinho de compras");

            }
        });

        btnVoltar = (Button) findViewById(R.id.activity_produto_voltar);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        actionBar.setTitle("Detalhes do Produto");

    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_produto;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == android.R.id.home){
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void alert(String s){
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }


}
