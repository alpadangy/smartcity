package com.wahyu.smartcity.data.remote;

import com.wahyu.smartcity.model.response.ResponseArrayObject;
import com.wahyu.smartcity.model.response.ResponseObject;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Ujang Wahyu on 12/10/2019.
 * PT Indocyber Global Teknologi
 * ujang.wahyu@indocyber.co.id
 */
public interface KulinerService {
    @GET("kuliner")
    Observable<ResponseArrayObject> listKuliner();

    @GET("jeniskuliner")
    Observable<ResponseArrayObject> listJenisKuliner();

    @GET("jenis/{id}/kuliner")
    Observable<ResponseArrayObject> kulinerByJenis(@Path("id") int id);

    @GET("tempat/{id}/kuliner")
    Observable<ResponseArrayObject> kulinerByTempat(@Path("id") int id);
}
