package com.ep4.carla.survivethealiens.Request;

import com.ep4.carla.survivethealiens.Models.Jogador;
import com.ep4.carla.survivethealiens.Models.JogadorList;

import feign.Param;
import feign.RequestLine;

/**
 * Created by Carla on 23/09/2016.
 */

public interface JogadorRequest {
    @RequestLine("GET api/Jogadors/{id}/")
    Jogador getJogador(@Param("id") Integer id);

    @RequestLine("GET /Jogadors")
    JogadorList getJogadores();

    @RequestLine(("GET /Jogadors/{email}/{senha}"))
    Jogador getJogador(@Param("email") String email, @Param("senha") String senha);
}
