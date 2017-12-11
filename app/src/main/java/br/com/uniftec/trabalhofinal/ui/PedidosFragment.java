package br.com.uniftec.trabalhofinal.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import br.com.uniftec.trabalhofinal.R;
import br.com.uniftec.trabalhofinal.model.Endereco;
import br.com.uniftec.trabalhofinal.model.Pedido;
import br.com.uniftec.trabalhofinal.model.Produto;

/**
 * Created by Fin on 11/12/2017.
 */

public class PedidosFragment extends Fragment {

    private TextView txtDataPedido;
    private TextView txtEndereco;
    private TextView txtTotal;
    private TextView txtTitulo;
    private TextView txtPreco;
    private Button btnStatus;
    private Context context;
    private Endereco endereco;
    private Produto produto;
    private Pedido pedido;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = getContext();

        View view = inflater.inflate(R.layout.activity_pedidos, container, false);

        ArrayList<Pedido> listPedidos = new ArrayList<>();

        final Produto p = new Produto();
        p.criaProdutos(p);

        for (int i = 0; i <= 5; i++){

            pedido = new Pedido();
            pedido.criaPedido(pedido);

            listPedidos.add(pedido);

        }

        txtDataPedido = view.findViewById(R.id.text_pedido_data);
        txtDataPedido.setText(pedido.getData());

        txtEndereco = view.findViewById(R.id.text_pedido_entrega);
        txtEndereco.setText("Rua José Bisol, 1985, Ap 42 - Lourdes - Caxias do Sul/RS");

        txtTotal = view.findViewById(R.id.text_pedido_total);

        txtTotal.setText("R$ " + String.format(Locale.getDefault(), "%.2f", somaProdutos(pedido.getProdutos())));

        btnStatus = view.findViewById(R.id.button_pedido_status);
        btnStatus.setText(pedido.getStatus());

        txtTitulo = view.findViewById(R.id.pedidos_titulo);
        txtTitulo.setText(p.getTitulo());

        txtPreco = view.findViewById(R.id.pedidos_preco);
        txtPreco.setText("R$ " + p.getPreco().toString());

        return view;
    }

    private Double somaProdutos(List<Produto> produtos){

        double total = 0;

        for (int i = 0; i < produtos.size(); i++){

            total = total + produtos.get(i).getPreco();
        }

        return total;

    }

}
