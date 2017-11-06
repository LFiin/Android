package br.com.uniftec.trabalhofinal.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import br.com.uniftec.trabalhofinal.R;
import br.com.uniftec.trabalhofinal.adapter.holder.CardHolder;
import br.com.uniftec.trabalhofinal.model.Produto;
import br.com.uniftec.trabalhofinal.repositorio.ProdutoFactory;
import br.com.uniftec.trabalhofinal.ui.ListaProdutosActivity;

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
    public void onBindViewHolder(CardHolder holder, int position) {

        holder.titulo.setText(listProdutos.get(position).getTitulo());
        holder.descricao.setText(listProdutos.get(position).getDescricao());
        holder.preco.setText(String.format(Locale.getDefault(), "%f", listProdutos.get(position).getPreco()));

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

    public void updateList(Produto produto) {
        insertItem(produto);
    }



}
