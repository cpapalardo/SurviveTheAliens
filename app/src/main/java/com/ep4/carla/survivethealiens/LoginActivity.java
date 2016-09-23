package com.ep4.carla.survivethealiens;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ep4.carla.survivethealiens.Task.LoginTask;

public class LoginActivity extends AppCompatActivity {

    LoginTask task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        task = new LoginTask();

        //setar atributos aqui. Quando for para a task já estará populado
        task.jogador.setApelido("teste");
        //quando quiser chamar o feign
        task.execute();


    }

    public void esqueceuSuaSenha(View v) {
        Intent intent = new Intent(this, RecuperarSenhaActivity.class);
        startActivity(intent);
    }

    public void login(View v) {
        Intent intent = new Intent(this, PrincipalActivity.class);
        startActivity(intent);
    }
}
