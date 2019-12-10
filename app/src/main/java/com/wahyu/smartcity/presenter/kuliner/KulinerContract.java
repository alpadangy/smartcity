package com.wahyu.smartcity.presenter.kuliner;

import com.wahyu.smartcity.base.BasePresenter;
import com.wahyu.smartcity.base.BaseView;
import com.wahyu.smartcity.model.Kuliner;

import java.util.List;

/**
 * Created by Ujang Wahyu on 12/10/2019.
 * PT Indocyber Global Teknologi
 * ujang.wahyu@indocyber.co.id
 */
public class KulinerContract {
    public interface View extends BaseView<Presenter> {
        void listKuliner(List<Kuliner> kulinerList);
        void onSuccess();
        void onFailure();
        void onFailed();
    }

    public interface Presenter extends BasePresenter {
        void loadDataKuliner();
    }
}
