package com.ep4.carla.survivethealiens.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ep4.carla.survivethealiens.R;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
    }

    public void abrirHistoria(View v) {
        Intent intent = new Intent(this, CapituloActivity.class);
        startActivity(intent);
    }
}
