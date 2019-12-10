package com.wahyu.smartcity.view.kuliner;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wahyu.smartcity.R;
import com.wahyu.smartcity.base.BaseFragment;
import com.wahyu.smartcity.model.Kuliner;
import com.wahyu.smartcity.presenter.kuliner.KulinerContract;
import com.wahyu.smartcity.presenter.kuliner.KulinerPresenter;

import java.util.List;

public class KulinerFragment extends BaseFragment implements KulinerContract.View {

    private KulinerContract.Presenter presenter;
    private KulinerAdapter adapter;
    private RecyclerView rvKuliner;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_kuliner, container, false);
        findViews(view);
        initViews(view);
        initListeners(view);
        return view;
    }

    @Override
    public void findViews(View view) {
        rvKuliner = view.findViewById(R.id.rv_kuliner);
    }

    @Override
    public void initViews(View view) {
        new KulinerPresenter(this);
        presenter.start();
    }

    @Override
    public void initListeners(View view) {

    }

    @Override
    public void setPresenter(@NonNull KulinerContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void listKuliner(List<Kuliner> kulinerList) {
        KulinerAdapter kulinerAdapter = new KulinerAdapter(getContext(), kulinerList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        rvKuliner.setLayoutManager(layoutManager);
        rvKuliner.setAdapter(kulinerAdapter);
    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void onFailure() {

    }

    @Override
    public void onFailed() {

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
