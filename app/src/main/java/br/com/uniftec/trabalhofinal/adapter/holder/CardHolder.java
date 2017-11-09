package br.com.uniftec.trabalhofinal.adapter.holder;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import br.com.uniftec.trabalhofinal.R;
import br.com.uniftec.trabalhofinal.adapter.CardAdapter;
import br.com.uniftec.trabalhofinal.model.Produto;
import br.com.uniftec.trabalhofinal.ui.ListaProdutosActivity;
import br.com.uniftec.trabalhofinal.ui.ProdutoActivity;


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
