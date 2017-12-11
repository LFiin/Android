package br.com.uniftec.trabalhofinal.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import br.com.uniftec.trabalhofinal.R;
import br.com.uniftec.trabalhofinal.adapter.holder.CardHolder;
import br.com.uniftec.trabalhofinal.model.Produto;
import br.com.uniftec.trabalhofinal.ui.ProdutoActivity;

import static android.support.v4.content.ContextCompat.startActivity;
import static android.widget.Toast.*;

/**
 * Created by Fin on 06/11/2017.
 */

public class CardAdapter extends RecyclerView.Adapter<CardHolder> implements View.OnClickListener{

    private Context meuContext;
    private final List<Produto> listProdutos;


    public CardAdapter(Context context, ArrayList<Produto> produtos){
        meuContext = context;
        listProdutos = produtos;
    }


    @Override
    public CardHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CardHolder(meuContext, LayoutInflater.from(parent.getContext())
        .inflate(R.layout.main_card_view, parent, false));
    }

    @Override
    public void onBindViewHolder(CardHolder holder, final int position) {

        holder.titulo.setText(listProdutos.get(position).getTitulo());
        holder.descricao.setText(listProdutos.get(position).getDescricao());
        holder.preco.setText("R$ " + String.format(Locale.getDefault(), "%.2f", listProdutos.get(position).getPreco()));
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

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Produto produto = getItem(position);

                Intent intent = new Intent(meuContext, ProdutoActivity.class);

                intent.putExtra(ProdutoActivity.PRODUTO_PARAMETER, produto);

                meuContext.startActivity(intent);
            }
        });

    }

    public Produto getItem(int position){
        return listProdutos.get(position);
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

        if (listProdutos.size() <= 1 ){
            Toast.makeText(meuContext,"Não é possível remover este item", LENGTH_LONG).show();
        } else {
            listProdutos.remove(position);
        }

        notifyItemRemoved(position);
        notifyItemRangeChanged(position, listProdutos.size());
    }

    @Override
    public void onClick(View view) {

    }


}
