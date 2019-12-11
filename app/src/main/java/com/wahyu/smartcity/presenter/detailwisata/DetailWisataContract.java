package com.wahyu.smartcity.presenter.detailwisata;

import com.wahyu.smartcity.base.BasePresenter;
import com.wahyu.smartcity.base.BaseView;
import com.wahyu.smartcity.model.Lokasi;
import com.wahyu.smartcity.model.Wisata;
import com.wahyu.smartcity.presenter.home.HomeContract;

import java.util.List;

/**
 * Created by Ujang Wahyu on 12/11/2019.
 * PT Indocyber Global Teknologi
 * ujang.wahyu@indocyber.co.id
 */
public class DetailWisataContract {
    public interface View extends BaseView<DetailWisataContract.Presenter> {
        void detailWisata(Wisata wisataList);
        void onSuccess();
        void onFailure();
        void onFailed();
    }

    public interface Presenter extends BasePresenter {
        void loadDetailWisata(int id);
    }
}
