package com.wahyu.smartcity.presenter.penginapan;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wahyu.smartcity.data.remote.Network;
import com.wahyu.smartcity.model.Kategori;
import com.wahyu.smartcity.model.Penginapan;
import com.wahyu.smartcity.model.response.ResponseArrayObject;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Ujang Wahyu on 12/10/2019.
 * PT Indocyber Global Teknologi
 * ujang.wahyu@indocyber.co.id
 */
public class PenginapanPresenter implements PenginapanContract.Presenter  {

    private PenginapanContract.View view;
    private Gson gson = new Gson();
    private Network network;
    private PenginapanObservable penginapanObservable = new PenginapanObservable();

    public PenginapanPresenter(PenginapanContract.View view) {
        this.view = view;
        this.view.setPresenter(this);
    }

    @Override
    public void loadDataPenginapan() {
        penginapanObservable.observablePenginapan().subscribe(observerPenginapan());
    }

    @Override
    public Observer<ResponseArrayObject> observerPenginapan() {
        return new Observer<ResponseArrayObject>() {
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
                view.onFailed();
            }

            @Override
            public void onComplete() {

            }
        };
    }

    @Override
    public void start() {
        loadDataPenginapan();
    }
}
