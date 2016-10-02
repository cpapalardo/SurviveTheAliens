package com.ep4.carla.survivethealiens.Retrofit.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.ep4.carla.survivethealiens.Models.Jogador;
import com.ep4.carla.survivethealiens.R;

import java.util.List;

/**
 * Created by Carla on 30/09/2016.
 */

public class JogadorAdapter extends ArrayAdapter<Jogador>{

    public static class ViewHolder{
        TextView nome;
        TextView apelido;
    }

    public JogadorAdapter(Context context, List<Jogador> jogadores){
        super(context, 0, jogadores);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Jogador jogador = getItem(position);

        ViewHolder viewHolder;
        if(convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.activity_teste, parent, false);
            viewHolder.nome = (TextView) convertView.findViewById(R.id.textViewNome);

            convertView.setTag(viewHolder);
        } else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.nome.setText(jogador.getNome());
        return convertView;
    }
}
