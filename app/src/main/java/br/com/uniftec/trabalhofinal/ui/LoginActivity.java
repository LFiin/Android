package br.com.uniftec.trabalhofinal.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.com.uniftec.trabalhofinal.R;
import br.com.uniftec.trabalhofinal.model.LoginPOST;
import br.com.uniftec.trabalhofinal.model.Token;
import br.com.uniftec.trabalhofinal.task.ValidarLoginTask;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, ValidarLoginTask.ValidarLoginDelegate{

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

        //Preguiça de digitar sempre...
        tLogin.setText("lececatto");
        tSenha.setText("123");
    }

    @Override
    public void onClick(View view) {
        if (view == btLogin){
            if(!"".equals(tLogin.getText().toString()) &&  !"".equals(tSenha.getText().toString())){

                LoginPOST loginPOST = new LoginPOST( tLogin.getText().toString()
                                                   , tSenha.getText().toString());

                ValidarLoginTask validarLoginTask = new ValidarLoginTask(this);
                validarLoginTask.execute(loginPOST);

            }else{
                alert("Favor preencher os campos Usuario e Senha!");
            }
        }else{
            startActivity(new Intent(this, CadastroActivity.class));
        }
    }

    private void alert(String s){
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }

    @Override
    public void validarUsuarioSucesso(String token) {
        alert("Login efetuado com sucesso!");

        //Setar Token//
        Token.usuarioToken = token;

        startActivity(new Intent(this, MenuActivity.class));
    }

    @Override
    public void validarUsuarioFalha(String erro) {
        alert(erro);
    }
}
