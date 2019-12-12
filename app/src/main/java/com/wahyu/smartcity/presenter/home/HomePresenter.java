package com.wahyu.smartcity.presenter.home;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wahyu.smartcity.data.config.Network;
import com.wahyu.smartcity.data.remote.HomeService;
import com.wahyu.smartcity.model.Lokasi;
import com.wahyu.smartcity.model.Wisata;
import com.wahyu.smartcity.model.response.ResponseArrayObject;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Ujang Wahyu on 12/11/2019.
 * PT Indocyber Global Teknologi
 * ujang.wahyu@indocyber.co.id
 */
public class HomePresenter implements HomeContract.Presenter {
    private HomeContract.View view;
    private Network network;
    private HomeService homeService;
    private Gson gson = new Gson();

    public HomePresenter(HomeContract.View view) {
        this.view = view;
        this.view.setPresenter(this);
    }

    @Override
    public void loadLokasi() {
        homeService.listLokasi()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseArrayObject>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseArrayObject responseArrayObject) {
                        List<Lokasi> lokasiList = gson.fromJson(responseArrayObject.getData().toString(), new TypeToken<List<Lokasi>>(){}.getType());
                        view.listLokasi(lokasiList);
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
    public void loadRekomendasi() {
        homeService.listRekomendasi()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseArrayObject>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseArrayObject responseArrayObject) {
                        List<Wisata> wisataList = gson.fromJson(responseArrayObject.getData().toString(), new TypeToken<List<Wisata>>(){}.getType());
                        view.listRekomendasi(wisataList);
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
    public void loadWisata() {
        homeService.listWisata()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseArrayObject>() {
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

                    }

                    @Override
                    public void onComplete() {
                        // Updates UI with data

                    }
                });
    }


    @Override
    public void start() {
        homeService = network.getService().create(HomeService.class);
        loadLokasi();
        loadRekomendasi();
        loadWisata();
    }
}
