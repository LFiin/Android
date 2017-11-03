package br.com.uniftec.trabalhofinal.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import br.com.uniftec.trabalhofinal.R;
import br.com.uniftec.trabalhofinal.adapter.RecyclerAdapter;
import br.com.uniftec.trabalhofinal.model.Produto;

/**
 * Created by Fin on 03/11/2017.
 */

public class ListaProdutosActivity extends AppCompatActivity {

    private RecyclerView meuRecyclerView;
    private RecyclerView.LayoutManager meuLayoutManager;
    RecyclerAdapter adapter;
    private List<Produto> produtoListas = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        for (int i = 0; i < 10; i++) {
            Produto produto = new Produto();
            produto.setTitulo("Produto " + i);
            produto.setDescricao("Descricao produto " + i);

            produtoListas.add(produto);
        }

        setaRecyclerView();

    }

    public void setaRecyclerView(){

        //Aqui é instanciado o Recyclerview
        meuRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        meuLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

        meuRecyclerView.setLayoutManager(meuLayoutManager);

        adapter = new RecyclerAdapter(this, produtoListas);

        meuRecyclerView.setAdapter(adapter);
    }


}
