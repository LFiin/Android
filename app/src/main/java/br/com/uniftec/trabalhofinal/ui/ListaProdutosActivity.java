package br.com.uniftec.trabalhofinal.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

import br.com.uniftec.trabalhofinal.R;
import br.com.uniftec.trabalhofinal.adapter.CardAdapter;
import br.com.uniftec.trabalhofinal.model.Produto;

/**
 * Created by Fin on 06/11/2017.
 */

public class ListaProdutosActivity extends AbstractActivity {

    private CardAdapter cardAdapter;
    private LinearLayoutManager layoutManager;
    private RecyclerView meuRecyclerView;
    public static ArrayList<Produto> dados;
    private Context context;
    private Toolbar toolbar;

    @Override
    protected void setupView() {
        context = this;

        meuRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_layout_recycler);

        toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        getSupportActionBar().setTitle("Lista Produtos");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        layoutManager = new LinearLayoutManager(this);
        meuRecyclerView.setLayoutManager(layoutManager);

        dados = new ArrayList<>(5);

        Produto p = new Produto();
        p.criaProdutos(p);

        dados.add(p);

        cardAdapter = new CardAdapter(this, dados);
        meuRecyclerView.setAdapter(cardAdapter);

    }

    @Override
    protected int getLayoutRes() {
        return R.layout.acticity_recycler_view_layout;
    }

}

