package com.wahyu.smartcity.presenter.home;

import com.wahyu.smartcity.base.BasePresenter;
import com.wahyu.smartcity.base.BaseView;
import com.wahyu.smartcity.model.Lokasi;
import com.wahyu.smartcity.model.Wisata;

import java.util.List;

/**
 * Created by Ujang Wahyu on 12/11/2019.
 * PT Indocyber Global Teknologi
 * ujang.wahyu@indocyber.co.id
 */
public class HomeContract {
    public interface View extends BaseView<Presenter> {
        void listLokasi(List<Lokasi> lokasiList);
        void listRekomendasi(List<Wisata> wisataList);
        void listWisata(List<Wisata> wisataList);
        void onSuccess();
        void onFailure();
        void onFailed();
    }

    public interface Presenter extends BasePresenter {
        void loadLokasi();
        void loadRekomendasi();
        void loadWisata();
    }
}