package com.wahyu.smartcity.presenter.kuliner;

import com.wahyu.smartcity.data.remote.KulinerService;
import com.wahyu.smartcity.data.config.Network;
import com.wahyu.smartcity.model.response.ResponseArrayObject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Ujang Wahyu on 12/10/2019.
 * PT Indocyber Global Teknologi
 * ujang.wahyu@indocyber.co.id
 */
public class KulinerObservable {
    private Network network;
    public Observable<ResponseArrayObject> observableKuliner(){
        return network.getService().create(KulinerService.class)
                .listKuliner()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
