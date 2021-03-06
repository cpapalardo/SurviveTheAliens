package com.ep4.carla.survivethealiens.Activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.ep4.carla.survivethealiens.R;

public class CapituloActivity extends AppCompatActivity {

    Toolbar toolbar;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capitulo);
        initInstancesDrawer();
    }

    private void initInstancesDrawer() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Capítulo 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Capítulo 2"));
        tabLayout.addTab(tabLayout.newTab().setText("Capítulo 3"));
    }
}
