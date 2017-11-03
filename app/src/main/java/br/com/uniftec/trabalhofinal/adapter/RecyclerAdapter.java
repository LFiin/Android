package br.com.uniftec.trabalhofinal.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.uniftec.trabalhofinal.R;
import br.com.uniftec.trabalhofinal.model.Produto;

/**
 * Created by Fin on 03/11/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    Context meuContext;
    private List<Produto> listaProdutos;

    Produto produto = new Produto();


    public RecyclerAdapter (Context context, List<Produto> produtos){
        this.meuContext = context;
        this.listaProdutos = produtos;
    }


    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_item_lista, viewGroup, false);
        return new RecyclerViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder viewHolder, int position) {

        listaProdutos.get(position);

        viewHolder.viewTitulo.setText(produto.getTitulo());
        viewHolder.viewDescricao.setText(produto.getDescricao());

    }

    @Override
    public int getItemCount() {
        return listaProdutos.size();
    }

    protected class RecyclerViewHolder extends RecyclerView.ViewHolder{

        protected TextView viewTitulo;
        protected TextView viewDescricao;

        public RecyclerViewHolder(final View itemView){
            super(itemView);


            viewTitulo = (TextView) itemView.findViewById(R.id.tv_titulo_produto);
            viewDescricao = (TextView) itemView.findViewById(R.id.tv_descricao_produto);

        }
    }
}
