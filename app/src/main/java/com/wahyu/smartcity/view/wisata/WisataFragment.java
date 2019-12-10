package com.wahyu.smartcity.view.wisata;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wahyu.smartcity.R;
import com.wahyu.smartcity.base.BaseFragment;
import com.wahyu.smartcity.model.Kategori;
import com.wahyu.smartcity.model.Wisata;
import com.wahyu.smartcity.presenter.wisata.WisataContract;
import com.wahyu.smartcity.presenter.wisata.WisataPresenter;

import java.util.List;

public class WisataFragment extends BaseFragment implements WisataContract.View{

    private RecyclerView rvWisata, rvKategori;
    private WisataAdapter wisataAdapter;
    private KategoriAdapter kategoriAdapter;
    private WisataContract.Presenter presenter;

    public WisataFragment(){}

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wisata, container, false);
        findViews(view);
        initViews(view);
        initListeners(view);
        return view;
    }

    @Override
    public void findViews(View view) {
        rvWisata = view.findViewById(R.id.rv_wisata);
        rvKategori = view.findViewById(R.id.rv_kategori);
    }

    @Override
    public void initViews(View view) {
        new WisataPresenter(this);
        presenter.start();
    }

    @Override
    public void initListeners(View view) {

    }

    @Override
    public void setPresenter(@NonNull WisataContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void listKategori(List<Kategori> kategoriList) {
        kategoriAdapter = new KategoriAdapter(getContext(), kategoriList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        rvKategori.setLayoutManager(layoutManager);
        rvKategori.setAdapter(kategoriAdapter);
    }

    @Override
    public void listWisata(List<Wisata> wisataList) {
        wisataAdapter = new WisataAdapter(getContext(), wisataList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
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
