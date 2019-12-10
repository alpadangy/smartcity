package com.wahyu.smartcity.base;

import androidx.annotation.NonNull;

/**
 * Created by Ujang Wahyu on 12/10/2019.
 * PT Indocyber Global Teknologi
 * ujang.wahyu@indocyber.co.id
 */

public interface BaseView<T> {
    void setPresenter(@NonNull T presenter);
}
