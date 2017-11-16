package br.com.uniftec.trabalhofinal.ui;

import android.content.Context;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import br.com.uniftec.trabalhofinal.R;
import br.com.uniftec.trabalhofinal.model.Endereco;
import br.com.uniftec.trabalhofinal.model.Pedido;
import br.com.uniftec.trabalhofinal.model.Produto;

import static br.com.uniftec.trabalhofinal.ui.CarrinhoActivity.PRODUTO_PARAMETER;

/**
 * Created by Fin on 09/11/2017.
 */

public class PedidosActivity extends AbstractActivity {


    private TextView txtDataPedido;
    private TextView txtEndereco;
    private TextView txtTotal;
    private TextView txtTitulo;
    private TextView txtPreco;
    private Button btnStatus;
    private Context meuContext;
    private Endereco endereco;
    private Toolbar toolbar;
    private Produto produto;
    private Pedido pedido;


    @Override
    protected void setupView() {

        meuContext = this;

        ArrayList<Pedido> listPedidos = new ArrayList<>();

        produto = (Produto) getIntent().getSerializableExtra(PRODUTO_PARAMETER);

        for (int i = 0; i <= 5; i++){

            pedido = new Pedido();
            pedido.criaPedido(pedido);

            listPedidos.add(pedido);

        }

        txtDataPedido = (TextView) findViewById(R.id.text_pedido_data);
        txtDataPedido.setText(pedido.getData());

        txtEndereco = (TextView) findViewById(R.id.text_pedido_entrega);
        txtEndereco.setText("Rua José Bisol, 1985, Ap 42 - Lourdes - Caxias do Sul/RS");

        txtTotal = (TextView) findViewById(R.id.text_pedido_total);

        txtTotal.setText("R$ " + String.format(Locale.getDefault(), "%.2f", somaProdutos(pedido.getProdutos())));

        btnStatus = (Button) findViewById(R.id.button_pedido_status);
        btnStatus.setText(pedido.getStatus());

        txtTitulo = (TextView) findViewById(R.id.pedidos_titulo);
        txtTitulo.setText(produto.getTitulo());

        txtPreco = (TextView) findViewById(R.id.pedidos_preco);
        txtPreco.setText("R$ " + produto.getPreco().toString());

        toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        getSupportActionBar().setTitle("Meus Pedidos");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_pedidos;
    }

    private void alert(String s){
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }

    private Double somaProdutos(List<Produto> produtos){

        double total = 0;

        for (int i = 0; i < produtos.size(); i++){

            total = total + produtos.get(i).getPreco();
        }

        return total;

    }
}
