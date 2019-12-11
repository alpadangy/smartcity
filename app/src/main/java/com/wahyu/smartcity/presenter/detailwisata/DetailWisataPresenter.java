package com.wahyu.smartcity.presenter.detailwisata;

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
    private int id;

    public DetailWisataPresenter(DetailWisataContract.View view) {
        this.view = view;
        this.view.setPresenter(this);
    }

    @Override
    public void loadDetailWisata(int id) {
        observableDetailWisata().subscribe(getObserverDetailWisata());
    }

    public Observable<ResponseObject> observableDetailWisata(){
        return network.getService().create(WisataService.class)
                .detailWisata(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observer<ResponseObject> getObserverDetailWisata(){
        return new Observer<ResponseObject>() {
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
                view.onFailed();
            }

            @Override
            public void onComplete() {

            }
        };
    }

    @Override
    public void start() {
        loadDetailWisata(id);
    }
}
