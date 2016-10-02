package com.ep4.carla.survivethealiens.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.ep4.carla.survivethealiens.Models.Jogador;
import com.ep4.carla.survivethealiens.Models.JogadorList;
import com.ep4.carla.survivethealiens.R;
import com.ep4.carla.survivethealiens.Retrofit.adapters.Task.AsyncResponse;
import com.ep4.carla.survivethealiens.Retrofit.adapters.Task.LoginTask;
import com.ep4.carla.survivethealiens.Retrofit.adapters.JogadorAdapter;
import com.ep4.carla.survivethealiens.Retrofit.adapters.rest.ApiClient;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.app.PendingIntent.getActivity;

//http://stackoverflow.com/questions/12575068/how-to-get-the-result-of-onpostexecute-to-main-activity-because-asynctask-is-a
public class LoginActivity extends AppCompatActivity implements AsyncResponse{

    EditText editTextEmail;
    EditText editTextSenha;
    LoginTask loginTask;
    Jogador jogador;

    ListView listView;
    List<Jogador> jogadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextEmail = (EditText) findViewById(R.id.input_email);
        editTextSenha = (EditText) findViewById(R.id.input_password);

        //para garantir que a internet será acessada
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        //task = new LoginTask();
       /* task.delegate = this;
        task.execute();

        //setar atributos aqui. Quando for para a task já estará populado
        task.jogador.setApelido("teste");
        //quando quiser chamar o feign
        task.execute();
*/

    }

    public void esqueceuSuaSenha(View v) {
        Intent intent = new Intent(this, RecuperarSenhaActivity.class);
        startActivity(intent);
    }

    public void autenticar(View v){
        String email = editTextEmail.getText().toString();
        String senha = editTextSenha.getText().toString();

        Jogador _jogador = new Jogador(email, senha);
       /* new LoginTask(this, _jogador).execute();
        //jogador = loginTask.doInBackground();
/*        if(_jogador == null)
            return;*/

    }

    public void iniciarTelaLogin(View v) {
        Intent intent = new Intent(this, PrincipalActivity.class);
        startActivity(intent);
    }

    public void iniciarTelaCadastro(View v){
        //Intent intent = new Intent(this, CadastroActivity.class);
        //startActivity(intent);
        Toast.makeText(this, "Ainda não tem nada aqui", Toast.LENGTH_SHORT).show();
    }

    public void iniciarTelaPrincipal(){
        Intent intent = new Intent(this, PrincipalActivity.class);
        EventBus.getDefault().postSticky(jogador);
        startActivityForResult(intent, 0);
    }

    @Override
    public void processFinish(Jogador output) {
        jogador = output;

        Toast.makeText(this, jogador.getEmail() + " " + jogador.getSenha(), Toast.LENGTH_LONG).show();
    }

    private void getJogadoresList(){
        final ProgressDialog loading = ProgressDialog.show(this,
                getBaseContext().getString(R.string.app_name),
                "Carregando, por favor espere", false, false);

        Call<JogadorList> call = ApiClient.get().getJogadores();

        call.enqueue(new Callback<JogadorList>() {
            @Override
            public void onResponse(Call<JogadorList> call, Response<JogadorList> response) {
                Log.d("APIPlug", "Successfully response fetched");
                loading.dismiss();
                jogadores = response.body().results;

                if(jogadores.size() > 0)
                    showList();
                else{
                    Log.d("APIPlug", "No player found");
                }
            }

            @Override
            public void onFailure(Call<JogadorList> call, Throwable t) {
                Log.d("APIPlug", "Error Ocurred: " + t.getMessage());
                loading.dismiss();
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
    }

/*    @Override
    public void processFinish(Jogador output) {
        if(output != null){
            Intent intent = new Intent(this, PrincipalActivity.class);
            EventBus.getDefault().postSticky(output);

            startActivityForResult(intent, 0);
        }
    }*/

}
