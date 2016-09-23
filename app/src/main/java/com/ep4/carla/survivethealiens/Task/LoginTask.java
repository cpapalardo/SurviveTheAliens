package com.ep4.carla.survivethealiens.Task;

import android.os.AsyncTask;

import com.ep4.carla.survivethealiens.Models.Jogador;

/**
 * Created by aluno on 22/09/2016.
 */
//https://developer.android.com/reference/android/os/AsyncTask.html
public class LoginTask extends AsyncTask<Jogador,Integer,Boolean>{
    //chamada para o feign
    public Jogador jogador;

    @Override
    protected Boolean doInBackground(Jogador... params) {
        //chamada para o feign aqui
        return false;
    }


   /* @Override
    protected Object doInBackground(Object[] params) {
        return null;
    }*/
    //1
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        jogador = new Jogador();
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
    }

    //acesso a thread de user interface
    /*
    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
    }*/


}
