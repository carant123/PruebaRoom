package com.proyecto.qr.retrofitrxjava;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.reactivestreams.Subscription;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Carlos on 16/02/2018.
 */

public class ListaActivity extends AppCompatActivity {

    MultipleResource data = new MultipleResource();
    RecyclerView recycle;
    private Context mContext;
    private AdapterRetrofit adapterretrofit;
    private Observable<MultipleResource> multiple;
    private Disposable disposable;
    private Button bt_dispose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycleview_layout);
        recycle = (RecyclerView) findViewById(R.id.recycleViewList);
        multiple = StartedApp.getInstance().getService().listaUsuarioObservable();
        bt_dispose = (Button) findViewById(R.id.bt_dispose);

        bt_dispose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadJSON();
            }
        });

        Log.d("onCreate","onCreate");
        loadJSON();
        Log.d("loadJSON2","loadJSON2");


    }

    public void CargarRecycleView(MultipleResource data){

        this.mContext = getApplicationContext();

        this.adapterretrofit = new AdapterRetrofit(data,this.mContext);
        LinearLayoutManager linearLayout = new LinearLayoutManager(this.mContext);
        recycle.setLayoutManager(linearLayout);
        recycle.setAdapter(this.adapterretrofit);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recycle.getContext(),
                linearLayout.getOrientation());
        recycle.addItemDecoration(dividerItemDecoration);

    }


    private void loadJSON(){




        Log.d("loadJSON","loadJSON");

        // observeOn el observer en el thread principal
        // subscribeOn el observable se encuentra en un hilo

/*
        multiple.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MultipleResource>() {

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MultipleResource multipleResource) {
                        Log.d("onNext",multipleResource.totalPages.toString());
                        CargarRecycleView(multipleResource);

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        Log.d("onComplete","onComplete");
                    }

                });
*/


        disposable =  multiple.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MultipleResource>() {
                    @Override
                    public void accept(MultipleResource multipleResource) throws Exception {
                        Log.d("onNext",multipleResource.totalPages.toString());
                        CargarRecycleView(multipleResource);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.d("onComplete","onComplete");
                    }
                });

        //disposable.dispose();


        if(disposable.isDisposed()){
            Log.d("isDisposed","isDisposed");
        } else {
            Log.d("noDisposed","noDisposed");
        }

        if(disposable.isDisposed()){
            Log.d("isDisposed","isDisposed");
        } else {
            Log.d("noDisposed","noDisposed");
        }

        if (disposable != null && !disposable.isDisposed()) {
            Log.d("notnull","notnull");
        }


        Log.d("loadJSONFinish","loadJSONFinish");

    }


    @Override
    protected void onResume() {
        super.onResume();

        //disposable.dispose();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (disposable!=null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("onDestroy0","onDestroy0");
        if(disposable.isDisposed()){
            Log.d("isDisposed","isDisposed");
        } else {
            Log.d("noDisposed","noDisposed");
        }

        if (disposable != null && !disposable.isDisposed()) {
            Log.d("onDestroy1","onDestroy1");
            disposable.dispose();
        }
        Log.d("onDestroy2","onDestroy2");
    }


}
