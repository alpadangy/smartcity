package com.wahyu.smartcity.presenter.wisata;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wahyu.smartcity.data.remote.Network;
import com.wahyu.smartcity.data.remote.WisataService;
import com.wahyu.smartcity.model.Kategori;
import com.wahyu.smartcity.model.Wisata;
import com.wahyu.smartcity.model.response.ResponseArrayObject;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Ujang Wahyu on 12/10/2019.
 * PT Indocyber Global Teknologi
 * ujang.wahyu@indocyber.co.id
 */
public class WisataPresenter implements WisataContract.Presenter {

    private WisataObservable wisataObservable = new WisataObservable();
    private WisataContract.View view;
    private Network network;
    private Gson gson = new Gson();

    public WisataPresenter(WisataContract.View view) {
        this.view = view;
        this.view.setPresenter(this);
    }

    @Override
    public void loadKategori() {
        wisataObservable.observableKategori().subscribe(getObserverKategori());
    }

    @Override
    public void loadWisata() {
        wisataObservable.observableWisata().subscribe(getObserverWisata());
    }

    public Observer<ResponseArrayObject> getObserverKategori(){
        return new Observer<ResponseArrayObject>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ResponseArrayObject responseArrayObject) {
                List<Kategori> kategoriList = gson.fromJson(responseArrayObject.getData().toString(), new TypeToken<List<Kategori>>(){}.getType());
                view.listKategori(kategoriList);
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

    public Observer<ResponseArrayObject> getObserverWisata(){
        return new Observer<ResponseArrayObject>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ResponseArrayObject responseArrayObject) {
                List<Wisata> wisataList = gson.fromJson(responseArrayObject.getData().toString(), new TypeToken<List<Wisata>>(){}.getType());
                view.listWisata(wisataList);
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
        loadWisata();
        loadKategori();
    }
}
