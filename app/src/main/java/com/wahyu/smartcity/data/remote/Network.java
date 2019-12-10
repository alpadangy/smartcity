package com.wahyu.smartcity.data.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wahyu.smartcity.data.utils.JSONArrayAdapter;
import com.wahyu.smartcity.data.utils.JSONObjectAdapter;

import org.json.JSONArray;
import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ujang Wahyu on 12/10/2019.
 * PT Indocyber Global Teknologi
 * ujang.wahyu@indocyber.co.id
 */
public class Network {
    public static final String BASE_URL = "https://smartcity.kampuskoding.net/";
    private static final String BASE_API = BASE_URL+"api/";
    private static final String API_VERSION = "v1/";
    public static final String API_URL = BASE_API + API_VERSION;
    private static Retrofit retrofit;
    private static Gson gson;

    public static synchronized Retrofit getService() {
        if (retrofit == null) {
            if (gson == null) {
                gson = new GsonBuilder()
                        .registerTypeAdapter(JSONObject.class, JSONObjectAdapter.sInstance)
                        .registerTypeAdapter(JSONArray.class, JSONArrayAdapter.sInstance)
                        .setLenient()
                        .create();
            }

            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient httpClient = new OkHttpClient.Builder().addInterceptor(interceptor).build();

            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(API_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(httpClient)
                    .build();
        }
        return retrofit;
    }

}
