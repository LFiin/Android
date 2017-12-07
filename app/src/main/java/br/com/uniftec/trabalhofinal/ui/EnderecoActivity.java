package br.com.uniftec.trabalhofinal.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.uniftec.trabalhofinal.R;
import br.com.uniftec.trabalhofinal.model.EnderecoPUT;

/**
 * Created by lececatto on 02/11/2017.
 */

public class EnderecoActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText tRua;
    private EditText tNumero;
    private EditText tComplemento;
    private EditText tBairro;
    private EditText tCidade;
    private EditText tEstado;
    private Button btAddEndereco;
    private Button btCancelar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_endereco);

        tRua = (EditText) findViewById(R.id.tRua);
        tNumero = (EditText) findViewById(R.id.tNumero);
        tComplemento = (EditText) findViewById(R.id.tComplemento);
        tBairro = (EditText) findViewById(R.id.tBairro);
        tCidade = (EditText) findViewById(R.id.tCidade);
        tEstado = (EditText) findViewById(R.id.tEstado);
        btAddEndereco = (Button) findViewById(R.id.btAddEndereco);
        btAddEndereco.setOnClickListener(this);
        btCancelar = (Button) findViewById(R.id.btCancelar);
        btCancelar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == btAddEndereco) {
            if (!"".equals(tRua.getText().toString())&&!"".equals(tNumero.getText().toString())
                    &&!"".equals(tComplemento.getText().toString())&&!"".equals(tBairro.getText().toString())
                    &&!"".equals(tCidade.getText().toString())&&!"".equals(tEstado.getText().toString())) {

                alert("Cadastro de endereço realizado com sucesso");
                finish();
            } else {
                alert("Todos os campos devem estar preenchidos");
            }
        } else {
            finish();
        }
    }

    private void alert(String s){
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }
}
