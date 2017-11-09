package br.com.uniftec.trabalhofinal.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import br.com.uniftec.trabalhofinal.R;
import br.com.uniftec.trabalhofinal.adapter.CardAdapter;
import br.com.uniftec.trabalhofinal.model.Produto;

/**
 * Created by Fin on 06/11/2017.
 */

public class ListaProdutosActivity extends AppCompatActivity {

    private CardAdapter cardAdapter;
    private LinearLayoutManager layoutManager;
    private RecyclerView meuRecyclerView;
    public static ArrayList<Produto> dados;
    private Context context;


    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acticity_recycler_view_layout);
        meuRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_layout_recycler);

        layoutManager = new LinearLayoutManager(this);
        meuRecyclerView.setLayoutManager(layoutManager);

        dados = new ArrayList<>(5);

        Produto p = new Produto();
        p.criaProdutos(p);

        dados.add(p);

        cardAdapter = new CardAdapter(this, dados);
        meuRecyclerView.setAdapter(cardAdapter);

    }

}

