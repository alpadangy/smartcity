package com.wahyu.smartcity.data.remote;

import com.wahyu.smartcity.model.response.ResponseArrayObject;
import com.wahyu.smartcity.model.response.ResponseObject;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;

/**
 * Created by Ujang Wahyu on 12/10/2019.
 * PT Indocyber Global Teknologi
 * ujang.wahyu@indocyber.co.id
 */
public interface WisataService {

    @GET("lokasi")
    Observable<ResponseArrayObject> listKategori();

    @GET("wisata")
    Observable<ResponseArrayObject> listWisata();

    @GET("wisata")
    Single<ResponseArrayObject> getSingleWisata();

    @GET("wisata/{id}")
    Observable<ResponseObject> detailWisata(@Path("id") int id);

    @GET("lokasi/{id}/wisata")
    Observable<ResponseArrayObject> wisataByLokasi(@Path("id") int id);

    @GET("lokasi")
    Observable<ResponseArrayObject> listLokasi();

}
