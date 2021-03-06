package br.com.uniftec.trabalhofinal.adapter.holder;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.uniftec.trabalhofinal.R;
import br.com.uniftec.trabalhofinal.adapter.CardAdapter;


/**
 * Created by Fin on 06/11/2017.
 */

public class CardHolder extends RecyclerView.ViewHolder implements AdapterView.OnItemClickListener{

    private Context meuContext;

    public TextView titulo;

    public TextView descricao;

    public TextView preco;

    public CardView cardView;

    private CardAdapter adapter;

    public ImageView imagemPrincipal;

    public ImageButton btnAdd;

    public ImageButton btnDelete;

    private Toolbar toolbar;

    public CardHolder(Context context, View itemView) {
        super(itemView);
        meuContext = context;

        imagemPrincipal = (ImageView) itemView.findViewById(R.id.main_card_imagem);
        titulo = (TextView) itemView.findViewById(R.id.main_card_titulo);
        descricao = (TextView) itemView.findViewById(R.id.main_card_descricao);
        preco = (TextView) itemView.findViewById(R.id.main_card_preco);
        btnAdd = (ImageButton) itemView.findViewById(R.id.main_card_more);
        btnDelete = (ImageButton) itemView.findViewById(R.id.main_card_delete);
        cardView = (CardView) itemView.findViewById(R.id.main_card_view);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

    }

}
