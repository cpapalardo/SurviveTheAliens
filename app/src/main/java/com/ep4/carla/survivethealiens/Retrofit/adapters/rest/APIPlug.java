package com.ep4.carla.survivethealiens.Retrofit.adapters.rest;

import com.ep4.carla.survivethealiens.Models.CapituloList;
import com.ep4.carla.survivethealiens.Models.HistoriaList;
import com.ep4.carla.survivethealiens.Models.JogadorList;
import com.ep4.carla.survivethealiens.Models.MissaoList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Carla on 30/09/2016.
 */

public interface APIPlug {
    @GET("Jogadors")
    Call<JogadorList> getJogadores();

    @GET("historia")
    Call<HistoriaList> getHistorias();

    @GET("missao")
    Call<MissaoList> getMissoes();

    @GET("capitulo")
    Call<CapituloList> getCapitulos();
}
