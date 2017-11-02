package br.com.uniftec.trabalhofinal.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.uniftec.trabalhofinal.R;

/**
 * Created by lececatto on 28/10/2017.
 */

public class CadastroActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btCadastrar;
    private Button btCancelar;
    private EditText tEmail;
    private EditText tSenha;
    private EditText tNome;
    private EditText tCpf;
    private EditText tTelefone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        btCadastrar = (Button) findViewById(R.id.btCadastrar);
        btCadastrar.setOnClickListener(this);
        btCancelar = (Button) findViewById(R.id.btCancelar);
        btCancelar.setOnClickListener(this);
        tEmail = (EditText) findViewById(R.id.tEmail);
        tSenha = (EditText) findViewById(R.id.tSenha);
        tNome = (EditText) findViewById(R.id.tNome);
        tCpf = (EditText) findViewById(R.id.tCpf);
        tTelefone = (EditText) findViewById(R.id.tTelefone);
    }

    @Override
    public void onClick(View view) {
        if (view == btCadastrar){
            if(!"".equals(tEmail.getText().toString())&&!"".equals(tSenha.getText().toString())
                    &&!"".equals(tNome.getText().toString())&&!"".equals(tCpf.getText().toString())
                    &&!"".equals(tTelefone.getText().toString())){
                alert("Cadastro realizado com sucesso");
            } else{
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
