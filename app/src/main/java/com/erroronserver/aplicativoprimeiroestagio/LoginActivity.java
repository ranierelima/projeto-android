package com.erroronserver.aplicativoprimeiroestagio;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.erroronserver.aplicativoprimeiroestagio.model.GerenciadorUsuario;
import com.erroronserver.aplicativoprimeiroestagio.model.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cn.pedant.SweetAlert.SweetAlertDialog;

import static android.Manifest.permission.READ_CONTACTS;

public class LoginActivity extends AppCompatActivity{

    private EditText login;
    private EditText senha;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = (EditText) findViewById(R.id.tv_login);
        senha = (EditText) findViewById(R.id.tv_senha);
        progressBar = (ProgressBar) findViewById(R.id.pb_carregando);


        Button realizarLogin = (Button) findViewById(R.id.btn_login);
        realizarLogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                progressBar.setVisibility(View.VISIBLE);

                if(!login.getText().toString().isEmpty() && !senha.getText().toString().isEmpty()){

                    Usuario usuario = GerenciadorUsuario.getInstance()
                            .verificaUsuario(login.getText().toString(),
                                    senha.getText().toString());

                    if(usuario == null){
                        new SweetAlertDialog(LoginActivity.this, SweetAlertDialog.ERROR_TYPE)
                                .setTitleText("Erro")
                                .setContentText("Login e/ou senha inválidos").show();
                    }else{
                        Intent intent = new Intent(LoginActivity.this , MainActivity.class);
                        startActivity(intent);
                        finish();
                    }

                }else{
                    new SweetAlertDialog(LoginActivity.this)
                            .setTitleText("Campos vazios")
                            .setContentText("Para realizar o autenticação informe seu login e senha")
                            .show();
                }


                progressBar.setVisibility(View.GONE);

            }
        });
    }
}

