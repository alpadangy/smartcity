package com.wahyu.smartcity.view.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wahyu.smartcity.R;
import com.wahyu.smartcity.base.BaseFragment;
import com.wahyu.smartcity.model.Lokasi;
import com.wahyu.smartcity.model.Wisata;
import com.wahyu.smartcity.presenter.home.HomeContract;
import com.wahyu.smartcity.presenter.home.HomePresenter;
import com.wahyu.smartcity.presenter.wisata.WisataContract;
import com.wahyu.smartcity.presenter.wisata.WisataPresenter;

import java.util.List;

public class HomeFragment extends BaseFragment implements HomeContract.View{

    private RecyclerView rvLokasi,rvRekomendasi, rvWisata;
    private LokasiAdapter lokasiAdapter;
    private WisataAdapter wisataAdapter;
    private RekomendasiWisataAdapter rekomendasiWisataAdapter;
    private HomeContract.Presenter presenter;

    public HomeFragment(){}

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        findViews(view);
        initViews(view);
        initListeners(view);
        return view;
    }

    @Override
    public void findViews(View view) {
        rvLokasi = view.findViewById(R.id.rv_lokasi);
        rvRekomendasi = view.findViewById(R.id.rv_rekomendasi);
        rvWisata = view.findViewById(R.id.rv_wisata);
    }

    @Override
    public void initViews(View view) {
        new HomePresenter(this);
        presenter.start();
    }

    @Override
    public void initListeners(View view) {

    }

    @Override
    public void setPresenter(@NonNull HomeContract.Presenter presenter) {
        this.presenter = presenter;
    }


    @Override
    public void listLokasi(List<Lokasi> lokasiList) {
        lokasiAdapter = new LokasiAdapter(getContext(), lokasiList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        rvLokasi.setLayoutManager(layoutManager);
        rvLokasi.setAdapter(lokasiAdapter);
    }

    @Override
    public void listRekomendasi(List<Wisata> wisataList) {
        rekomendasiWisataAdapter = new RekomendasiWisataAdapter(getContext(), wisataList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        rvRekomendasi.setLayoutManager(layoutManager);
        rvRekomendasi.setAdapter(rekomendasiWisataAdapter);
    }

    @Override
    public void listWisata(List<Wisata> wisataList) {
        wisataAdapter = new WisataAdapter(getContext(), wisataList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        rvWisata.setLayoutManager(layoutManager);
        rvWisata.setAdapter(wisataAdapter);
    }

    @Override
    public void onSuccess() {
        //Toast
    }

    @Override
    public void onFailure() {
        //Toast
    }

    @Override
    public void onFailed() {
        //Toast
    }

    @Override
    public void onResume() {
        presenter.start();
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
