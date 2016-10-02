package com.ep4.carla.survivethealiens.Activity;

import android.app.ProgressDialog;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.ep4.carla.survivethealiens.Models.Jogador;
import com.ep4.carla.survivethealiens.Models.JogadorList;
import com.ep4.carla.survivethealiens.R;
import com.ep4.carla.survivethealiens.Retrofit.adapters.JogadorAdapter;
import com.ep4.carla.survivethealiens.Retrofit.adapters.rest.ApiClient;
import com.ep4.carla.survivethealiens.task.JogadorTask;
import com.ep4.carla.survivethealiens.Retrofit.adapters.JogadorAdapter;
import com.ep4.carla.survivethealiens.Retrofit.adapters.rest.ApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TesteActivity extends AppCompatActivity {

    private List<Jogador> jogadores;
    private ListView listView;
    public TextView textViewNome;

    JogadorTask jogadorTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste);
        textViewNome = (TextView) findViewById(R.id.textViewNome);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        jogadorTask = new JogadorTask();
        getJogadores();
    }

   /* //@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.activity_teste, container, false);

        listView = (ListView) view.findViewById(R.id.listView);

        getJogadores();

        return view;
    }*/

    private void getJogadores(){
        final ProgressDialog loading = ProgressDialog.show(this, "Carregando jogadores", "Por favor espere", false, false);
        Jogador jogador= jogadorTask.doInBackground(1);

        if(jogador == null){
            loading.dismiss();
            Toast.makeText(getBaseContext(), "Jogador não encontrado.", Toast.LENGTH_LONG);
            return;
        }

        textViewNome.setText(jogador.getNome());
        loading.dismiss();
    }

   /* private void getJogadores(){
    final ProgressDialog loading = ProgressDialog.show(this,"Carregando","Espere",false,false);

        Call<JogadorList> call = ApiClient.get().getJogadores();

        call.enqueue(new Callback<JogadorList>() {
            @Override
            public void onFailure(Call<JogadorList> call, Throwable t) {
                Log.d("APIPlug", "Error Occured: " + t.getMessage());
                Toast.makeText(getBaseContext(), t.getMessage().toString(), Toast.LENGTH_LONG).show();
                loading.dismiss();
            }

            @Override
            public void onResponse(Call<JogadorList> call, Response<JogadorList> response) {
                Log.d("APIPlug", "Successfully response fetched" );

                loading.dismiss();

                jogadores=response.body().results;

                if(jogadores.size()>0) {
                    textViewNome.setText(jogadores.get(0).getNome());
                }else{
                    Log.d("APIPlug", "No item found");
                    Toast.makeText(getBaseContext(), "No item found", Toast.LENGTH_LONG).show();

                }
            }
        });
    }

    private void showList(){
        Log.d("APIPlug", "Show List");

        JogadorAdapter adapter = new JogadorAdapter(this, jogadores);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id){
                Jogador clickedObj = (Jogador) parent.getItemAtPosition(position);
            }
        });
    }*/
}
