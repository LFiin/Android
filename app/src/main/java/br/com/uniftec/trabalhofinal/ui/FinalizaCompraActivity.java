package br.com.uniftec.trabalhofinal.ui;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.uniftec.trabalhofinal.R;
import br.com.uniftec.trabalhofinal.model.Endereco;
import br.com.uniftec.trabalhofinal.model.Produto;

import static br.com.uniftec.trabalhofinal.ui.CarrinhoActivity.PRODUTO_PARAMETER;

/**
 * Created by Fin on 09/11/2017.
 */

public class FinalizaCompraActivity extends AbstractActivity {



    private Spinner spinnerEndereco;
    private TextInputLayout tilNumeroCartao;
    private TextInputLayout tilDataExpiracao;
    private TextInputLayout tilCVV;
    private EditText editCartaoCredito;
    private EditText editDataExpiracao;
    private EditText editCVV;
    private Button btnCancelar;
    private Button btnConfirmar;
    private Context meuContext;
    private Endereco endereco;
    private Toolbar toolbar;
    private Produto produto;

    @Override
    protected void setupView() {
        meuContext = this;

        ArrayList<String> listEnderecos = new ArrayList<>();

        produto = (Produto) getIntent().getSerializableExtra(PRODUTO_PARAMETER);

        for (int i = 0; i <= 5; i++){

            endereco = new Endereco();
            endereco.criaEndereco(endereco);

            listEnderecos.add(endereco.toString(endereco));

        }

        spinnerEndereco = (Spinner) findViewById(R.id.spinner_finaliza_endereco);
        spinnerEndereco.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, final int position, long l) {

                spinnerEndereco.setSelection(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listEnderecos);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerEndereco.setAdapter(adapter);

        tilNumeroCartao = (TextInputLayout) findViewById(R.id.text_input_numero_cartao);
        tilDataExpiracao = (TextInputLayout) findViewById(R.id.text_input_data_expiracao);
        tilCVV = (TextInputLayout) findViewById(R.id.text_input_cvv);

        editCartaoCredito = (EditText) findViewById(R.id.edittext_finaliza_numero_cartao);
        editCartaoCredito.addTextChangedListener(new TextWatcher() {
            private boolean lock;
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void afterTextChanged(Editable editable) {

                if (lock || editable.length() > 16) {
                    return;
                }
                lock = true;
                for (int i = 4; i < editable.length(); i += 5) {
                    if (editable.toString().charAt(i) != ' ') {
                        editable.insert(i, " ");
                    }
                }
                lock = false;

            }
        });

        editDataExpiracao = (EditText) findViewById(R.id.edittext_finaliza_data_expiracao);
        editDataExpiracao.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void afterTextChanged(Editable editable) {

                if (editable.length() > 0 && (editable.length() % 3) == 0) {
                    final char c = editable.charAt(editable.length() - 1);
                    if ('/' == c) {
                        editable.delete(editable.length() - 1, editable.length());
                    }
                }
                if (editable.length() > 0 && (editable.length() % 3) == 0) {
                    char c = editable.charAt(editable.length() - 1);
                    if (Character.isDigit(c) && TextUtils.split(editable.toString(), String.valueOf("/")).length <= 2) {
                        editable.insert(editable.length() - 1, String.valueOf("/"));
                    }
                }

            }
        });

        editCVV = (EditText) findViewById(R.id.edittext_finaliza_cvv);

        btnConfirmar = (Button) findViewById(R.id.button_finaliza_confirma);
        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!"".equals(spinnerEndereco.getSelectedItem().toString()) &&
                        !"".equals(editCartaoCredito.getText().toString()) &&
                        !"".equals(editDataExpiracao.getText().toString()) &&
                        !"".equals(editCVV.getText().toString())) {

                    alert("Pedido realizado com sucesso!");

                    Intent intent = new Intent(meuContext, PedidosActivity.class);

                    intent.putExtra(ProdutoActivity.PRODUTO_PARAMETER, produto);

                    meuContext.startActivity(intent);

                } else {
                    alert("Preenha todos os campos!");
                }
            }
        });

        btnCancelar = (Button) findViewById(R.id.button_finaliza_cancelar);
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(meuContext, CarrinhoActivity.class);

                intent.putExtra(ProdutoActivity.PRODUTO_PARAMETER, produto);

                meuContext.startActivity(intent);
            }
        });

        toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        getSupportActionBar().setTitle("Finaliza Compra");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_finaliza_compra;
    }

    private void alert(String s){
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }
}
