package br.com.uniftec.trabalhofinal.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.com.uniftec.trabalhofinal.R;
import br.com.uniftec.trabalhofinal.model.Produto;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btLogin;
    private EditText tLogin;
    private EditText tSenha;
    private TextView tNovoUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btLogin = (Button) findViewById(R.id.btLogin);
        btLogin.setOnClickListener(this);
        tLogin = (EditText) findViewById(R.id.tLogin);
        tSenha = (EditText) findViewById(R.id.tSenha);
        tNovoUsuario = (TextView) findViewById(R.id.tNovoUsuario);
        tNovoUsuario.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == btLogin){
            if(tLogin.getText().toString().equals("leandro")&&tSenha.getText().toString().equals("123")){
                alert("Login efetuado com sucesso");

                for (int i = 0; i < 10; i ++){
                    Produto produto = new Produto("Produto " + i, 14.95 + i, "DESCRICAO DESCRICAODESCRICAODESCRICAODESCRICAO DESCRICAO");
                }

                startActivity(new Intent(this, ListaProdutosActivity.class));
            }else{
                alert("Login ou senha incorretos");
            }
        }else{
            startActivity(new Intent(this, CadastroActivity.class));
        }
    }

    private void alert(String s){
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }
}
