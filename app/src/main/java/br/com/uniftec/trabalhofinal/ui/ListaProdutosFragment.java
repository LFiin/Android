package br.com.uniftec.trabalhofinal.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;

import br.com.uniftec.trabalhofinal.R;
import br.com.uniftec.trabalhofinal.adapter.CardAdapter;
import br.com.uniftec.trabalhofinal.model.produto.Produto;

/**
 * Created by Fin on 11/12/2017.
 */

public class ListaProdutosFragment extends Fragment implements AdapterView.OnItemClickListener {

    private RecyclerView recyclerView;
    private CardAdapter cardAdapter;
    private LinearLayoutManager layoutManager;
    private Context context;
    public static ArrayList<Produto> dados;


    public ListaProdutosFragment(){
        // empty constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = getContext();

        View view = inflater.inflate(R.layout.acticity_recycler_view_layout, container, false);

        recyclerView = view.findViewById(R.id.recycler_view_layout_recycler);
        layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);

        // aqui vai carregar os produtos

        dados = new ArrayList<>(5);

        Produto p = new Produto();
        p.criaProdutos(p);

        dados.add(p);

        cardAdapter = new CardAdapter(context, dados);
        recyclerView.setAdapter(cardAdapter);

        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

        Produto produto = cardAdapter.getItem(position);

        Intent intent = new Intent(getActivity(), ProdutoActivity.class);
        intent.putExtra(ProdutoActivity.PRODUTO_PARAMETER, produto);

        startActivity(intent);

    }

    private void alert(String s){
        Toast.makeText(context, s, Toast.LENGTH_LONG).show();
    }
}
