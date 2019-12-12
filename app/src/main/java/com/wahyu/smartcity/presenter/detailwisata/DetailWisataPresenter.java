package com.wahyu.smartcity.presenter.detailwisata;

import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wahyu.smartcity.data.config.Network;
import com.wahyu.smartcity.data.remote.WisataService;
import com.wahyu.smartcity.model.Wisata;
import com.wahyu.smartcity.model.response.ResponseArrayObject;
import com.wahyu.smartcity.model.response.ResponseObject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Ujang Wahyu on 12/11/2019.
 * PT Indocyber Global Teknologi
 * ujang.wahyu@indocyber.co.id
 */
public class DetailWisataPresenter implements DetailWisataContract.Presenter {

    private DetailWisataObservable wisataObservable = new DetailWisataObservable();
    private DetailWisataContract.View view;
    private Network network;
    private Gson gson = new Gson();
    private int wisata_id;
    private String nama_wisata;
    private Bundle bundle;
    private WisataService wisataService;

    public DetailWisataPresenter(DetailWisataContract.View view, Bundle bundle) {
        this.bundle = bundle;
        this.view = view;
        this.view.setPresenter(this);
    }

    @Override
    public void loadDetailWisata(int id) {
        wisataService.detailWisata(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseObject>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseObject responseObject) {
                        Wisata wisata = gson.fromJson(responseObject.getData().toString(), new TypeToken<Wisata>(){}.getType());
                        view.detailWisata(wisata);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        // Updates UI with data

                    }
                });
    }



    @Override
    public void start() {
        wisataService = network.getService().create(WisataService.class);
        wisata_id = Integer.parseInt(bundle.get("id_wisata").toString());
        nama_wisata = bundle.get("nama_wisata").toString();
        loadDetailWisata(wisata_id);
    }
}
