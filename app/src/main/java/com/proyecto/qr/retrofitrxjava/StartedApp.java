package com.proyecto.qr.retrofitrxjava;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.util.Log;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.proyecto.qr.retrofitrxjava.Room.AppDatabase;
import com.proyecto.qr.retrofitrxjava.RoomPrueba.AppDatabasePrueba;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Carlos on 15/02/2018.
 */

public class StartedApp extends Application {

    private static final String BASE_URL = "https://reqres.in";
    private Service service;
    private Retrofit retrofit;
    private static StartedApp sInstance;
     //AppDatabase db;
     private AppDatabasePrueba db;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;

        // iniciliza la creacion de la base de datos
/*         db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name")
                .build();*/

        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabasePrueba.class, "databasePrueba")
                .build();


    }

    public AppDatabasePrueba Database(){
        return db;
    }

    public Service getService(){

        if ( retrofit == null){
            Log.d("retrofitNull","retrofitNull");
            // la convención de nomenclatura de campo JSON para usar para serialización y deserialización.
            // El uso de esta política de nombres con Gson modificará el nombre del campo Java de
            // su formulario en camello a un nombre de campo en minúscula, donde cada palabra
            // está separada por un guión bajo (_).
            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .create();

            // GsonConverterFactory crea una instancia usando gson para la conversion
            // addCallAdapterFactory - Agregue una fábrica de adaptador de llamada para admitir tipos de
            // devolución de método de servicio que no sean Llamar.

            // RxJava2CallAdapterFactory - Fábrica de adaptadores para admitir tipos de devolución de métodos
            // de servicio, agregar instancia de RxJava2CallAdapterFactory para compatibilidad con Rxjava 2.
            retrofit = new Retrofit.Builder()
                    //.baseUrl("http://pokeapi.co/api/v2/")
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }

        service = retrofit.create(Service.class);
        Log.d("retrofitservice","retrofitservice");
        return service;
    }

    public static synchronized StartedApp getInstance() {
        return sInstance;
    }

/*    synchronized public Service getService() {
        return service;
    }*/

}
