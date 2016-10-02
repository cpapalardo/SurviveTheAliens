package com.ep4.carla.survivethealiens.task;

import android.content.Intent;
import android.os.AsyncTask;

import com.ep4.carla.survivethealiens.Models.Jogador;
import com.ep4.carla.survivethealiens.Models.JogadorList;
import com.ep4.carla.survivethealiens.Request.JogadorRequest;

import feign.Feign;
import feign.gson.GsonDecoder;

/**
 * Created by Carla on 01/10/2016.
 */

public class JogadorTask extends AsyncTask<Integer, Void, Jogador> {

    @Override
    public Jogador doInBackground(Integer... params){
        try{
            JogadorRequest request = Feign.builder()
                    .decoder(new GsonDecoder())
                    .target(JogadorRequest.class, "http://survivethealiens.azurewebsites.net/");

            Jogador jogador = request.getJogador(params[0]);
            return jogador;
        }catch (Exception e){
            System.err.println("Erro de comunicação, ");
            e.printStackTrace();
            return null;
        }
    }
}
