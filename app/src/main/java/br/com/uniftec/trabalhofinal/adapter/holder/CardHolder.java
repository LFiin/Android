package br.com.uniftec.trabalhofinal.adapter.holder;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import br.com.uniftec.trabalhofinal.R;


/**
 * Created by Fin on 06/11/2017.
 */

public class CardHolder extends RecyclerView.ViewHolder{

    public TextView titulo;

    public TextView descricao;

    public TextView preco;

    public CardView cardView;

    public ImageButton btnAdd;

    public ImageButton btnDelete;

    public CardHolder(View itemView) {
        super(itemView);

        titulo = (TextView) itemView.findViewById(R.id.main_card_titulo);
        descricao = (TextView) itemView.findViewById(R.id.main_card_descricao);
        preco = (TextView) itemView.findViewById(R.id.main_card_preco);
        btnAdd = (ImageButton) itemView.findViewById(R.id.main_card_more);
        btnDelete = (ImageButton) itemView.findViewById(R.id.main_card_delete);
        cardView = (CardView) itemView.findViewById(R.id.main_card_view);


    }


}
