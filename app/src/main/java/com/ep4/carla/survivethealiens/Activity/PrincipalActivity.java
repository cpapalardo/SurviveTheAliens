package com.ep4.carla.survivethealiens.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ep4.carla.survivethealiens.Models.Jogador;
import com.ep4.carla.survivethealiens.R;

import org.greenrobot.eventbus.EventBus;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        Jogador jogador = EventBus.getDefault().removeStickyEvent(Jogador.class);
    }

    public void abrirHistoria(View v) {
        Intent intent = new Intent(this, HistoriaActivity.class);
        startActivity(intent);
    }

    public void retomarMissao(View v){
        Intent intent = new Intent(this, MissaoActivity.class);
        startActivity(intent);
    }
}
