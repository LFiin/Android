package br.com.uniftec.trabalhofinal.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

import br.com.uniftec.trabalhofinal.R;
import br.com.uniftec.trabalhofinal.adapter.CardAdapter;
import br.com.uniftec.trabalhofinal.model.produto.Produto;

/**
 * Created by Fin on 11/12/2017.
 */

public class CarrinhoFragment extends Fragment implements AdapterView.OnItemClickListener{

    public static final String PRODUTO_PARAMETER = "PRODUTO_PARAMETER";

    private Produto produto;
    private ImageView imagem;
    private TextView txtTitulo;
    private TextView txtPreco;
    private TextView txtTotal;
    private Context meuContext;
    private ImageButton btnDel;
    private FloatingActionButton fab_finaliza_compra;
    private Context context;
    private CardAdapter cardAdapter;

    public CarrinhoFragment(){
        // EMPTY CONSTRUCTOR
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = getContext();

        View view = inflater.inflate(R.layout.activity_carrinho, container, false);

        //produto = (Produto) getActivity().getIntent().getSerializableExtra(PRODUTO_PARAMETER);

        final Produto p = new Produto();
        p.criaProdutos(p);

        imagem = view.findViewById(R.id.carrinho_imagem);

        txtTitulo = view.findViewById(R.id.carrinho_titulo);
        txtTitulo.setText(p.getTitulo());

        txtPreco = view.findViewById(R.id.carrinho_preco);
        txtPreco.setText("Preço: R$ " + String.format(Locale.getDefault(), "%.2f", p.getPreco()));

       /* txtTotal = (TextView) findViewById(R.id.carrinho_total);
        txtTotal.setText("Preço: R$ " + String.format(Locale.getDefault(), "%.2f", produto.getPreco()));*/

        fab_finaliza_compra =  view.findViewById(R.id.fab_finaliza_compra);
        fab_finaliza_compra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, FinalizaCompraActivity.class);

                intent.putExtra(ProdutoActivity.PRODUTO_PARAMETER, p);

                context.startActivity(intent);
            }
        });

        btnDel = view.findViewById(R.id.carrinho_delete);
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        Produto produto = cardAdapter.getItem(position);

        Intent intent = new Intent(getActivity(), ProdutoActivity.class);
        intent.putExtra(ProdutoActivity.PRODUTO_PARAMETER, produto);

        startActivity(intent);
    }
}
