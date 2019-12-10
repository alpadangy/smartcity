package com.wahyu.smartcity.presenter.wisata;

import com.google.gson.reflect.TypeToken;
import com.wahyu.smartcity.data.remote.Network;
import com.wahyu.smartcity.data.remote.WisataService;
import com.wahyu.smartcity.model.Wisata;
import com.wahyu.smartcity.model.response.ResponseArrayObject;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Ujang Wahyu on 12/10/2019.
 * PT Indocyber Global Teknologi
 * ujang.wahyu@indocyber.co.id
 */
public class WisataObservable {
    Network network;

    public Observable<ResponseArrayObject> observableKategori(){
        return network.getService().create(WisataService.class)
                .listKategori()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<ResponseArrayObject> observableWisata(){
        return network.getService().create(WisataService.class)
                .listWisata()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
