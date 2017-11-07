package br.com.uniftec.trabalhofinal.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import br.com.uniftec.trabalhofinal.R;
import br.com.uniftec.trabalhofinal.adapter.CardAdapter;
import br.com.uniftec.trabalhofinal.model.Produto;
import br.com.uniftec.trabalhofinal.repositorio.ProdutoFactory;

/**
 * Created by Fin on 06/11/2017.
 */

public class ListaProdutosActivity extends AppCompatActivity implements View.OnClickListener{

    private CardAdapter cardAdapter;
    private StaggeredGridLayoutManager layoutManager;
    private RecyclerView meuRecyclerView;
    private Button btnAdd;
    public static ArrayList<Produto> dados;



    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acticity_recycler_view_layout);

        meuRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_layout_recycler);
        btnAdd = (Button) findViewById(R.id.btn_Add);
        btnAdd.setOnClickListener(this);

        layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        meuRecyclerView.setLayoutManager(layoutManager);

        ProdutoFactory produtoFactory = new ProdutoFactory();

        dados = new ArrayList<Produto>(5);
        for (int i = 0; i < dados.size(); i++){
            dados.add(produtoFactory.makeProduct());
        }

        cardAdapter = new CardAdapter(dados);
        meuRecyclerView.setAdapter(cardAdapter);

    }


    @Override
    public void onClick(View view) {
        cardAdapter.updateList(ProdutoFactory.makeProduct());
    }
}
