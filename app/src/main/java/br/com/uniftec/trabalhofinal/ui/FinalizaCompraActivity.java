package br.com.uniftec.trabalhofinal.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import br.com.uniftec.trabalhofinal.R;
import br.com.uniftec.trabalhofinal.model.endereco.Endereco;
import br.com.uniftec.trabalhofinal.model.produto.Produto;

/**
 * Created by Fin on 09/11/2017.
 */

public class FinalizaCompraActivity extends AbstractActivity {


    private TextView txtEndereço;
    private Spinner spinnerEndereco;
    private TextView txtCartaoCredito;
    private EditText editCartaoCredito;
    private TextView txtDataExpiracao;
    private EditText editDataExpiracao;
    private TextView txtCVV;
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

        for (int i = 0; i <= 5; i++){

            endereco = new Endereco();
            endereco.criaEndereco(endereco);

            listEnderecos.add(endereco.toString(endereco));

        }

        txtEndereço = (TextView) findViewById(R.id.textview_finaliza_endereço);

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


        txtCartaoCredito = (TextView) findViewById(R.id.textview_finaliza_numero_cartao);
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

        txtDataExpiracao = (TextView) findViewById(R.id.textview_finaliza_data_expiracao);
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

        txtCVV = (TextView) findViewById(R.id.textview_finaliza_cvv);
        editCVV = (EditText) findViewById(R.id.edittext_finaliza_cvv);

        btnConfirmar = (Button) findViewById(R.id.button_finaliza_confirma);
        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!"".equals(spinnerEndereco.getSelectedItem().toString()) &&
                        !"".equals(editCartaoCredito.getText().toString()) &&
                        !"".equals(editDataExpiracao.getText().toString()) &&
                        !"".equals(editCVV.getText().toString())) {

                    Intent intent = new Intent(meuContext, MenuActivity.class);

                    meuContext.startActivity(intent);

                    alert("Pedido realizado com sucesso!");

                } else {
                    alert("Preenha todos os campos!");
                }
            }
        });

        btnCancelar = (Button) findViewById(R.id.button_finaliza_cancelar);
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        actionBar.setTitle("Finaliza Compra");


    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_finaliza_compra;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == android.R.id.home){
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void alert(String s){
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }
}
