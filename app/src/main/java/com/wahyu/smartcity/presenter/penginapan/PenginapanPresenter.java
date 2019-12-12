package com.wahyu.smartcity.presenter.penginapan;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wahyu.smartcity.data.config.Network;
import com.wahyu.smartcity.data.remote.PenginapanService;
import com.wahyu.smartcity.data.remote.WisataService;
import com.wahyu.smartcity.model.Lokasi;
import com.wahyu.smartcity.model.Penginapan;
import com.wahyu.smartcity.model.response.ResponseArrayObject;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Ujang Wahyu on 12/10/2019.
 * PT Indocyber Global Teknologi
 * ujang.wahyu@indocyber.co.id
 */
public class PenginapanPresenter implements PenginapanContract.Presenter  {

    private PenginapanContract.View view;
    private Gson gson = new Gson();
    private Network network;
    PenginapanService penginapanService ;

    public PenginapanPresenter(PenginapanContract.View view) {
        this.view = view;
        this.view.setPresenter(this);
    }

    @Override
    public void loadDataPenginapan() {
        penginapanService.listPenginapan()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseArrayObject>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseArrayObject responseArrayObject) {
                        List<Penginapan> penginapanList = gson.fromJson(responseArrayObject.getData().toString(), new TypeToken<List<Penginapan>>(){}.getType());
                        view.listPenginapan(penginapanList);
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
        penginapanService = network.getService().create(PenginapanService .class);
        loadDataPenginapan();
    }
}
