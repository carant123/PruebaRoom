package com.proyecto.qr.retrofitrxjava.RoomPrueba;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.proyecto.qr.retrofitrxjava.R;
import com.proyecto.qr.retrofitrxjava.StartedApp;

import java.util.List;

/**
 * Created by Carlos on 17/02/2018.
 */

public class PruebaActivity extends AppCompatActivity {

    Button bt_insertar;
    Button bt_mostrar;

    List<Usuario> usuarios;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prueba_layout);

        bt_insertar = findViewById(R.id.bt_insertar);
        bt_mostrar = findViewById(R.id.bt_mostrar);

        bt_insertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new AsyncTask<Void, Void, String>() {
                    @Override
                    protected String doInBackground(Void... params) {

                        Usuario usuario = new Usuario();
                        usuario.setNombre("NombreTest");
                        usuario.setApellido("ApellidoTest");
                        StartedApp.getInstance().Database().databaseDao().InsertUsuario(usuario);

                        return "Insertado";
                    }

                    @Override
                    protected void onPostExecute(String user) {
                        Log.d("Insertado", user);
                    }
                }.execute();

            }
        });

        bt_mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new AsyncTask<Void, Void, List<Usuario>>() {
                    @Override
                    protected List<Usuario> doInBackground(Void... params) {

                        usuarios = StartedApp.getInstance().Database().databaseDao().GetUsuarios();
                        return usuarios;
                    }

                    @Override
                    protected void onPostExecute(List<Usuario> usuarios) {
                        if(usuarios.size() == 0){
                            Log.d("No hay usuarios", "No hay usuarios");
                        } else {
                            for (Usuario usuario : usuarios) {
                                Log.d("Usuario: ", usuario.getId_usuario() + " - "+ usuario.getNombre() + " - " + usuario.getApellido());
                            }
                        }
                    }
                }.execute();



            }
        });



    }
}
