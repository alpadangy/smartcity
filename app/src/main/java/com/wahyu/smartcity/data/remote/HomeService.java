package com.wahyu.smartcity.data.remote;

import com.wahyu.smartcity.model.response.ResponseArrayObject;
import com.wahyu.smartcity.model.response.ResponseObject;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Ujang Wahyu on 12/11/2019.
 * PT Indocyber Global Teknologi
 * ujang.wahyu@indocyber.co.id
 */
public interface HomeService {
    @GET("kategori")
    Observable<ResponseArrayObject> listKategori();

    @GET("wisata")
    Observable<ResponseArrayObject> listRekomendasi();

    @GET("wisata")
    Observable<ResponseArrayObject> listWisata();

    @GET("wisata/{id}")
    Observable<ResponseObject> detailWisata(@Path("id") int id);

    @GET("lokasi")
    Observable<ResponseArrayObject> listLokasi();

    @GET("tempatkuliner")
    Observable<ResponseArrayObject> listTempatKuliner();
}
