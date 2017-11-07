package br.com.uniftec.trabalhofinal.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import br.com.uniftec.trabalhofinal.R;
import br.com.uniftec.trabalhofinal.adapter.holder.CardHolder;
import br.com.uniftec.trabalhofinal.model.Produto;

/**
 * Created by Fin on 06/11/2017.
 */

public class CardAdapter extends RecyclerView.Adapter<CardHolder> {

    private final List<Produto> listProdutos;

    public CardAdapter(ArrayList<Produto> produtos){

        listProdutos = produtos;
    }


    @Override
    public CardHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CardHolder(LayoutInflater.from(parent.getContext())
        .inflate(R.layout.main_card_view, parent, false));
    }

    @Override
    public void onBindViewHolder(CardHolder holder, final int position) {

        holder.titulo.setText(listProdutos.get(position).getTitulo());
        holder.descricao.setText(listProdutos.get(position).getDescricao());
        holder.preco.setText(String.format(Locale.getDefault(), "%.2f", listProdutos.get(position).getPreco()));
        holder.btnAdd.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {
                Produto p = new Produto();
                p.criaProdutos(p);
                insertItem(p);
                updateItem(position);
            }
        });

        holder.btnDelete.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                removerItem(position);
            }
        });


    }

    @Override
    public int getItemCount() {

        return listProdutos.size();

    }

    private void insertItem(Produto produto) {

        listProdutos.add(produto);
        notifyItemInserted(getItemCount());
    }

    private void updateItem(int position) {

        notifyItemChanged(position);
    }

    private void removerItem(int position) {
        listProdutos.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, listProdutos.size());
    }



}
