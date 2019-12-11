package com.wahyu.smartcity.presenter.penginapan;

import com.wahyu.smartcity.data.config.Network;
import com.wahyu.smartcity.data.remote.PenginapanService;
import com.wahyu.smartcity.model.response.ResponseArrayObject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Ujang Wahyu on 12/10/2019.
 * PT Indocyber Global Teknologi
 * ujang.wahyu@indocyber.co.id
 */
public class PenginapanObservable {
    Network network;

    public Observable<ResponseArrayObject> observablePenginapan(){
        return network.getService().create(PenginapanService.class)
                .listPenginapan()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
