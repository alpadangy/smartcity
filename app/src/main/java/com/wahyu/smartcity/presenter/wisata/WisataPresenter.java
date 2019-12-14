package com.wahyu.smartcity.presenter.wisata;

import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wahyu.smartcity.data.config.Network;
import com.wahyu.smartcity.data.remote.WisataService;
import com.wahyu.smartcity.model.Lokasi;
import com.wahyu.smartcity.model.Wisata;
import com.wahyu.smartcity.model.response.ResponseArrayObject;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Response;

/**
 * Created by Ujang Wahyu on 12/10/2019.
 * PT Indocyber Global Teknologi
 * ujang.wahyu@indocyber.co.id
 */
public class WisataPresenter implements WisataContract.Presenter {
    private CompositeDisposable disposable = new CompositeDisposable();
    private WisataContract.View view;
    private WisataService wisataService;
    private Network network;
    private List<Wisata> wisataList;
    private List<Lokasi> lokasiList;
    private Bundle bundle;

    private Gson gson = new Gson();

    public WisataPresenter(WisataContract.View view, Bundle bundle) {
        this.bundle = bundle;
        this.view = view;
        this.view.setPresenter(this);
    }

    @Override
    public void loadWisata() {
        try {
            wisataService.listWisata()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<ResponseArrayObject>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(ResponseArrayObject responseArrayObject) {
                            wisataList = gson.fromJson(responseArrayObject.getData().toString(), new TypeToken<List<Wisata>>(){}.getType());
                            view.listWisata(wisataList);
                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onComplete() {
                            view.stopProgress();
                        }
                    });
        }catch (Exception e){

        }
    }

    @Override
    public void start() {
        wisataService = network.getService().create(WisataService.class);
        loadWisata();
    }
}
