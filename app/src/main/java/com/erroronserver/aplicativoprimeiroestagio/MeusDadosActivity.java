package com.erroronserver.aplicativoprimeiroestagio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.erroronserver.aplicativoprimeiroestagio.model.GerenciadorUsuario;
import com.erroronserver.aplicativoprimeiroestagio.model.Usuario;
import com.squareup.picasso.Picasso;

public class MeusDadosActivity extends AppCompatActivity {

    private ImageView foto;
    private TextView nome;
    private TextView email;
    private TextView telefone;
    private Button btnSalvar;
    private Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meus_dados);
        foto = (ImageView) findViewById(R.id.iv_md_foto);
        nome = (TextView) findViewById(R.id.tv_md_nome);
        email = (TextView) findViewById(R.id.tv_md_email);
        telefone = (TextView) findViewById(R.id.tv_md_telefone);
        btnSalvar = (Button) findViewById(R.id.btn_md_salvar);

        usuario = GerenciadorUsuario.getInstance().getUsuario();

        nome.setText(usuario.getNome());
        email.setText(usuario.getEmail());
        telefone.setText(usuario.getTelefone());

        Picasso.with(MeusDadosActivity.this).load("http://api.adorable.io/avatars/1").into(foto);
    }


    public void salvar(View view) {
        GerenciadorUsuario.getInstance().editar(new Usuario(usuario.getLogin(), usuario.getSenha(),
                Integer.valueOf(telefone.getText().toString()), nome.getText().toString(),
                email.getText().toString() ));
        startActivity(new Intent(MeusDadosActivity.this, MainActivity.class));
        finish();
    }
}
