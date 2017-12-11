package br.com.uniftec.trabalhofinal.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.uniftec.trabalhofinal.R;
import br.com.uniftec.trabalhofinal.model.Token;
import br.com.uniftec.trabalhofinal.model.UsuarioPUT;
import br.com.uniftec.trabalhofinal.task.IncluirUsuarioTask;

/**
 * Created by Fin on 11/12/2017.
 */

public class CadastroFragment extends Fragment implements View.OnClickListener, IncluirUsuarioTask.IncluirUsuarioDelegate{

    private Button btAddNovoEndereco;
    private Button btCadastrar;
    private Button btCancelar;
    private EditText tEmail;
    private EditText tSenha;
    private EditText tNome;
    private EditText tCpf;
    private EditText tTelefone;
    private Context context;

    public CadastroFragment(){
        // EMPTY CONSTRUCTOR
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = getContext();

        View view = inflater.inflate(R.layout.activity_cadastro, container, false);

        btAddNovoEndereco = view.findViewById(R.id.btAddNovoEndereco);
        btAddNovoEndereco.setOnClickListener(this);
        btCadastrar = view.findViewById(R.id.btCadastrar);
        btCadastrar.setOnClickListener(this);
        btCancelar = view.findViewById(R.id.btCancelar);
        btCancelar.setOnClickListener(this);
        tEmail = view.findViewById(R.id.tEmail);
        tSenha = view.findViewById(R.id.tSenha);
        tNome = view.findViewById(R.id.tNome);
        tCpf = view.findViewById(R.id.tCpf);
        tTelefone = view.findViewById(R.id.tTelefone);

        if (!"".equals(Token.usuarioToken)){
            btAddNovoEndereco.setVisibility(View.VISIBLE);
            btCadastrar.setText("Atualizar");
            alert(Token.usuarioToken);
        }

        return view;
    }



    @Override
    public void onClick(View view) {
        if (view == btCadastrar) {
            if (!"".equals(tEmail.getText().toString()) && !"".equals(tSenha.getText().toString())
                    && !"".equals(tNome.getText().toString()) && !"".equals(tCpf.getText().toString())
                    && !"".equals(tTelefone.getText().toString())) {

                if (!"".equals(Token.usuarioToken)){
                    //Atualizar usuario
                } else {
                    UsuarioPUT usuarioPUT = new UsuarioPUT( tCpf.getText().toString()
                            , tEmail.getText().toString()
                            , tNome.getText().toString()
                            , tSenha.getText().toString()
                            , tTelefone.getText().toString());

                    IncluirUsuarioTask incluirUsuarioTask = new IncluirUsuarioTask(this);
                    incluirUsuarioTask.execute(usuarioPUT);
                }

                startActivity(new Intent(context, MenuActivity.class));
            } else {
                alert("Todos os campos devem estar preenchidos");
            }
        } else if (view == btAddNovoEndereco){
            startActivity(new Intent(context, EnderecoActivity.class));
        } else {
            startActivity(new Intent(context, MenuActivity.class));
        }

    }

    private void alert(String s){
        Toast.makeText(context, s, Toast.LENGTH_LONG).show();
    }

    @Override
    public void incluirUsuarioSucesso(String token) {
        alert("Usuário incluído com sucesso: " + token);
    }

    @Override
    public void incluirUsuarioFalha(String erro) {

    }
}
