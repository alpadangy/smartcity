package com.wahyu.smartcity.presenter.kuliner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wahyu.smartcity.data.remote.Network;
import com.wahyu.smartcity.model.Kuliner;
import com.wahyu.smartcity.model.response.ResponseArrayObject;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Ujang Wahyu on 12/10/2019.
 * PT Indocyber Global Teknologi
 * ujang.wahyu@indocyber.co.id
 */
public class KulinerPresenter implements KulinerContract.Presenter {
     private Network network;
     private Gson gson = new Gson();
     private KulinerContract.View view;
     private KulinerObservable kulinerObservable = new KulinerObservable();

    public KulinerPresenter(KulinerContract.View view) {
        this.view = view;
        this.view.setPresenter(this);
    }

    @Override
    public void loadDataKuliner() {
        kulinerObservable.observableKategori().subscribe(getObserverKuliner());
    }

    public Observer<ResponseArrayObject> getObserverKuliner(){
        return new Observer<ResponseArrayObject>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ResponseArrayObject responseArrayObject) {
                List<Kuliner> kulinerList = gson.fromJson(responseArrayObject.getData().toString(), new TypeToken<List<Kuliner>>(){}.getType());
                view.listKuliner(kulinerList);
            }

            @Override
            public void onError(Throwable e) {
                view.onFailed();
            }

            @Override
            public void onComplete() {

            }
        };
    }

    @Override
    public void start() {
        loadDataKuliner();
    }
}
