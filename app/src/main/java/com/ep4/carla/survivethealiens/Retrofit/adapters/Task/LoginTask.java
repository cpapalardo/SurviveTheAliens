package com.ep4.carla.survivethealiens.Retrofit.adapters.Task;

import android.os.AsyncTask;

import com.ep4.carla.survivethealiens.Models.Jogador;
import com.ep4.carla.survivethealiens.Request.JogadorRequest;

import feign.Feign;
import feign.gson.GsonDecoder;
/**
 * Created by aluno on 22/09/2016.
 */
//https://developer.android.com/reference/android/os/AsyncTask.html
public class LoginTask extends AsyncTask<Void,Integer,Jogador>{

    AsyncResponse delegate = null;

    private Exception exception;
    private Jogador jogador;

    public void setJogador(Jogador _jogador){
        jogador = _jogador;
    }

    public Jogador getJogador(){
        return jogador;
    }

    public LoginTask(AsyncResponse _delegate, Jogador _jogador){
        jogador = _jogador;
        delegate = _delegate;
    }

    @Override
    public Jogador doInBackground(Void... params) {
        JogadorRequest request = Feign.builder()
                .decoder(new GsonDecoder())
                .target(JogadorRequest.class, "http://10.0.2.2:8080/");
        try {

            //jogador = request.getJogador(jogador.getId());
            jogador = request.getJogador(jogador.getEmail(), jogador.getSenha());
            //jogador = new Jogador("teste", "123");
            return jogador;
        }
        catch(Exception e){
            System.err.println("Erro de comunicação");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void onPostExecute(Jogador jogador) {
        delegate.processFinish(jogador);
    }

    //public AsyncResponse delegate = null;

    //chamada para o feign

/*    public LoginTask(AsyncResponse _delegate){
        delegate = _delegate;
    }*/

/*    public Jogador jogador;
    private Feign feign;

    @Override
    protected Jogador doInBackground(Jogador... params) {
        //chamada para o feign aqui


        return jogador;
    }*/


   /* @Override
    protected Object doInBackground(Object[] params) {
        return null;
    }*/
    //1
/*    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        jogador = new Jogador();
    }*/

/*    @Override
    protected void onPostExecute(Jogador jogador) {
        delegate.processFinish(jogador);
    }*/

    /*
    @Override
    protected void onPostExecute(Boolean aBoolean) {

        //super.onPostExecute(aBoolean);
        delegate.processFinish(aBoolean);
    }*/


    //acesso a thread de user interface
    /*
    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
    }*/


}
