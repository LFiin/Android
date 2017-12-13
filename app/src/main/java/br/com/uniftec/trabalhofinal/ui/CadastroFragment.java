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
import br.com.uniftec.trabalhofinal.model.usuario.UsuarioGET;
import br.com.uniftec.trabalhofinal.model.usuario.UsuarioPOST;
import br.com.uniftec.trabalhofinal.model.usuario.UsuarioPOSTResponse;
import br.com.uniftec.trabalhofinal.model.usuario.UsuarioPOSTToken;
import br.com.uniftec.trabalhofinal.task.AtualizarUsuarioTask;
import br.com.uniftec.trabalhofinal.task.ReceberUsuarioTask;

/**
 * Created by Fin on 11/12/2017.
 */

public class CadastroFragment extends Fragment implements View.OnClickListener
                                                        , ReceberUsuarioTask.ReceberUsuarioDelegate
                                                        , AtualizarUsuarioTask.AtualizarUsuarioDelegate{

    private Button btAddNovoEndereco;
    private Button btAtualizar;
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
        btAtualizar = view.findViewById(R.id.btCadastrar);
        btAtualizar.setOnClickListener(this);
        btCancelar = view.findViewById(R.id.btCancelar);
        btCancelar.setOnClickListener(this);
        tEmail = view.findViewById(R.id.tEmail);
        tSenha = view.findViewById(R.id.tSenha);
        tNome = view.findViewById(R.id.tNome);
        tCpf = view.findViewById(R.id.tCpf);
        tTelefone = view.findViewById(R.id.tTelefone);

        btAddNovoEndereco.setVisibility(View.VISIBLE);
        btAtualizar.setText("Atualizar");

        ReceberUsuarioTask receberUsuarioTask = new ReceberUsuarioTask(this);
        receberUsuarioTask.execute(Token.usuarioToken);

        return view;
    }



    @Override
    public void onClick(View view) {
        if (view == btAtualizar) {
            if (!"".equals(tEmail.getText().toString()) && !"".equals(tSenha.getText().toString())
                    && !"".equals(tNome.getText().toString()) && !"".equals(tCpf.getText().toString())
                    && !"".equals(tTelefone.getText().toString())) {

                UsuarioPOST usuarioPOST = new UsuarioPOST( tCpf.getText().toString()
                                                         , tEmail.getText().toString()
                                                         , tNome.getText().toString()
                                                         , tSenha.getText().toString()
                                                         , tTelefone.getText().toString());

                UsuarioPOSTToken usuarioPOSTToken = new UsuarioPOSTToken(usuarioPOST, Token.usuarioToken);

                AtualizarUsuarioTask atualizarUsuarioTask = new AtualizarUsuarioTask(this);
                atualizarUsuarioTask.execute(usuarioPOSTToken);

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
    public void receberUsuarioSucesso(UsuarioGET usuarioGET) {
        tEmail.setText(usuarioGET.getEmail());
        tNome.setText(usuarioGET.getNome());
        tCpf.setText(usuarioGET.getCpf());
        tTelefone.setText(usuarioGET.getTelefone());

        //PEGAR ENDEREÇO
    }

    @Override
    public void receberUsuarioFalha(String erro) {
        alert(erro);
    }

    @Override
    public void atualizarUsuarioSucesso(UsuarioPOSTResponse usuarioPOSTResponse) {
        tEmail.setText(usuarioPOSTResponse.getEmail());
        tNome.setText(usuarioPOSTResponse.getNome());
        tCpf.setText(usuarioPOSTResponse.getCpf());
        tTelefone.setText(usuarioPOSTResponse.getTelefone());

        //PEGAR ENDEREÇO

        alert("Usuário atualizado com sucesso!");
    }

    @Override
    public void atualizarUsuarioFalha(String erro) {
        alert(erro);
    }
}
