package com.proyecto.qr.retrofitrxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("onCreate","onCreate");
        loadJSON();
    }

    private void loadJSON(){

        Log.d("loadJSON","loadJSON");

/*        RestClient restClient = new RestClient();


        restClient.getService().listaUsuarioObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MultipleResource>() {

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MultipleResource multipleResource) {
                        Log.d("onNext",multipleResource.totalPages.toString());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        Log.d("onComplete","onComplete");
                    }

                });*/



        // observeOn el observer en el thread principal
        // subscribeOn el observable se encuentra en un hilo
        StartedApp.getInstance().getService().listaUsuarioObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MultipleResource>() {

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MultipleResource multipleResource) {
                        Log.d("onNext",multipleResource.totalPages.toString());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        Log.d("onComplete","onComplete");
                    }

                });







/*        Call<MultipleResource> call2 = restClient.getService().listaUsuario();

        // execute - sincrona
        // enqueue - asincrona

        call2.enqueue(new Callback<MultipleResource>() {
            @Override
            public void onResponse(Call<MultipleResource> call, Response<MultipleResource> response) {


                if(response.isSuccessful()){

                    MultipleResource data = response.body();
                    Log.d("totalPages",data.totalPages.toString());

                    for (int i = 0; i < data.data.size(); i++){
                        Log.d("name " + i,data.data.get(i).name);
                    }

                }else{
                    Log.d("totalPages2","401");
                    Log.d("totalPages3","default");
                }


               switch (response.code()) {
                    case 200:
                        MultipleResource data = response.body();
                        Log.d("totalPages",data.totalPages.toString());

                        for (int i = 0; i < data.data.size(); i++){
                            Log.d("name " + i,data.data.get(i).name);
                        }


                        break;
                    case 401:
                        Log.d("totalPages2","401");
                        break;
                    default:
                        Log.d("totalPages3","default");
                        break;
                }



            }

            @Override
            public void onFailure(Call<MultipleResource> call, Throwable t) {
                Log.e("error", t.toString());
            }
        });*/







      /*  Observable<Integer> observable = Observable.just(1, 2, 3);
        observable.subscribe(new Observer<Integer>() {
            @Override public void onComplete() {
                Log.d("Test", "In onCompleted()");
            }

            @Override public void onError(Throwable e) {
                Log.d("Test", "In onError()");
            }

            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override public void onNext(Integer integer) {
                Log.d("Test", "In onNext():" + integer);
            }
        });*/

/*
        service.listaUsuarioObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MultipleResource>() {
                    @Override public void onComplete() {

                        Log.d(TAG, "In onCompleted()");
                    }

                    @Override public void onError(Throwable e) {
                        e.printStackTrace();
                        Log.d(TAG, "In onError()");
                    }

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override public void onNext(MultipleResource gitHubRepos) {
                        Log.d(TAG, "In onNext()");
                        Log.d("Test", "In onNext():" + gitHubRepos.totalPages);
                    }
                });
*/




    }




}
