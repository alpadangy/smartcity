package com.wahyu.smartcity.presenter.penginapan;

import com.wahyu.smartcity.base.BasePresenter;
import com.wahyu.smartcity.base.BaseView;
import com.wahyu.smartcity.model.Kuliner;
import com.wahyu.smartcity.model.Penginapan;
import com.wahyu.smartcity.model.response.ResponseArrayObject;
import com.wahyu.smartcity.presenter.kuliner.KulinerContract;

import java.util.List;

import io.reactivex.Observer;

/**
 * Created by Ujang Wahyu on 12/10/2019.
 * PT Indocyber Global Teknologi
 * ujang.wahyu@indocyber.co.id
 */
public class PenginapanContract {
    public interface View extends BaseView<Presenter> {
        void listPenginapan(List<Penginapan> penginapanList);
        void onSuccess();
        void onFailure();
        void onFailed();
    }

    public interface Presenter extends BasePresenter {
        void loadDataPenginapan();
        Observer<ResponseArrayObject> observerPenginapan();
    }
}
