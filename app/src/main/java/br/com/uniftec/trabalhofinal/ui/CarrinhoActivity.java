package br.com.uniftec.trabalhofinal.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import br.com.uniftec.trabalhofinal.R;
import br.com.uniftec.trabalhofinal.model.Produto;

import static android.widget.Toast.LENGTH_LONG;

/**
 * Created by Fin on 09/11/2017.
 */

public class CarrinhoActivity extends AbstractActivity {

    public static final String PRODUTO_PARAMETER = "PRODUTO_PARAMETER";

    private Produto produto;
    private ImageView imagem;
    private TextView txtTitulo;
    private TextView txtPreco;
    private TextView txtTotal;
    private Context meuContext;
    private ImageButton btnDel;
    private FloatingActionButton fab_finaliza_compra;

    @Override
    protected void setupView() {
        meuContext = this;

        produto = (Produto) getIntent().getSerializableExtra(PRODUTO_PARAMETER);

        imagem = (ImageView) findViewById(R.id.carrinho_imagem);

        txtTitulo = (TextView) findViewById(R.id.carrinho_titulo);
        txtTitulo.setText(produto.getTitulo());

        txtPreco = (TextView) findViewById(R.id.carrinho_preco);
        txtPreco.setText("Preço: R$ " + String.format(Locale.getDefault(), "%.2f", produto.getPreco()));

       /* txtTotal = (TextView) findViewById(R.id.carrinho_total);
        txtTotal.setText("Preço: R$ " + String.format(Locale.getDefault(), "%.2f", produto.getPreco()));*/

        fab_finaliza_compra =  (FloatingActionButton) findViewById(R.id.fab_finaliza_compra);
        fab_finaliza_compra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(meuContext, FinalizaCompraActivity.class);

                intent.putExtra(ProdutoActivity.PRODUTO_PARAMETER, produto);

                meuContext.startActivity(intent);
            }
        });

        btnDel = (ImageButton) findViewById(R.id.carrinho_delete);
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        actionBar.setTitle("Carrinho de Compras");

    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_carrinho;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == android.R.id.home){
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
