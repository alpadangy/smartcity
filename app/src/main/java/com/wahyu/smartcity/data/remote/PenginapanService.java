package com.wahyu.smartcity.data.remote;

import com.wahyu.smartcity.model.response.ResponseArrayObject;
import com.wahyu.smartcity.model.response.ResponseObject;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Ujang Wahyu on 12/10/2019.
 * PT Indocyber Global Teknologi
 * ujang.wahyu@indocyber.co.id
 */
public interface PenginapanService {
    @GET("penginapan")
    Observable<ResponseArrayObject> listPenginapan();

    @GET("penginapan/{id}")
    Observable<ResponseObject> detailPenginapan(@Path("id") int id);
}
