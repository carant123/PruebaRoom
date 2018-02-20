package com.proyecto.qr.retrofitrxjava;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Carlos on 15/02/2018.
 */

public interface Service {

    @GET("/api/users2")
    Observable<MultipleResource> listaUsuarioObservable();

}
