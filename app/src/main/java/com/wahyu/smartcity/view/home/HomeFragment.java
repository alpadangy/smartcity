package com.wahyu.smartcity.view.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wahyu.smartcity.R;
import com.wahyu.smartcity.base.BaseFragment;
import com.wahyu.smartcity.model.Kuliner;
import com.wahyu.smartcity.model.Lokasi;
import com.wahyu.smartcity.model.Tempatkuliner;
import com.wahyu.smartcity.model.Wisata;
import com.wahyu.smartcity.presenter.home.HomeContract;
import com.wahyu.smartcity.presenter.home.HomePresenter;
import com.wahyu.smartcity.presenter.wisata.WisataContract;
import com.wahyu.smartcity.presenter.wisata.WisataPresenter;

import java.util.List;

import io.supercharge.shimmerlayout.ShimmerLayout;

public class HomeFragment extends BaseFragment implements HomeContract.View{

    private RecyclerView rvLokasi,rvRekomendasi, rvWisata, rvTempatKuliner;
    private LokasiAdapter lokasiAdapter;
    private WisataAdapter wisataAdapter;
    private TempatKulinerAdapter tempatKulinerAdapter;
    private RekomendasiWisataAdapter rekomendasiWisataAdapter;
    private HomeContract.Presenter presenter;
    private ShimmerLayout shimmerLayout;

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
        rvTempatKuliner = view.findViewById(R.id.rv_tempat_kuliner);
        shimmerLayout = view.findViewById(R.id.shimmer_layout);
    }

    @Override
    public void initViews(View view) {
        new HomePresenter(this);
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
    public void listTempatKuliner(List<Tempatkuliner> tempatkulinerList) {
        tempatKulinerAdapter = new TempatKulinerAdapter(getContext(), tempatkulinerList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        rvTempatKuliner.setLayoutManager(layoutManager);
        rvTempatKuliner.setAdapter(tempatKulinerAdapter);
    }


    @Override
    public void onSuccess() {
    //    Toast.makeText(getContext(), "Berhasil Mengambil Data", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onProgress() {

    }

    @Override
    public void stopProgress() {
        shimmerLayout.stopShimmerAnimation();
        shimmerLayout.setVisibility(View.GONE);
    }

    @Override
    public void onFailure() {
        Toast.makeText(getContext(), "No Internet Access", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailed() {
        //Toast
    }

    @Override
    public void onResume() {
        shimmerLayout.startShimmerAnimation();
        presenter.start();
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
