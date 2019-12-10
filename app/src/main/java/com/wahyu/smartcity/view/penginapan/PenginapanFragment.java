package com.wahyu.smartcity.view.penginapan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.wahyu.smartcity.R;
import com.wahyu.smartcity.base.BaseFragment;
import com.wahyu.smartcity.data.remote.Network;
import com.wahyu.smartcity.model.Penginapan;
import com.wahyu.smartcity.presenter.penginapan.PenginapanContract;
import com.wahyu.smartcity.presenter.penginapan.PenginapanObservable;
import com.wahyu.smartcity.presenter.penginapan.PenginapanPresenter;

import java.util.List;

public class PenginapanFragment extends BaseFragment implements PenginapanContract.View {

    private RecyclerView rvPenginapan;
    private PenginapanAdapter penginapanAdapter;
    private PenginapanContract.Presenter presenter;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_penginapan, container, false);
        findViews(view);
        initViews(view);
        initListeners(view);
        return view;
    }

    @Override
    public void findViews(View view) {
        rvPenginapan = view.findViewById(R.id.rv_penginapan);
    }

    @Override
    public void initViews(View view) {
        new PenginapanPresenter(this);
        setPresenter(presenter);
    }

    @Override
    public void initListeners(View view) {

    }

    @Override
    public void listPenginapan(List<Penginapan> penginapanList) {
        penginapanAdapter = new PenginapanAdapter(getContext(), penginapanList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        rvPenginapan.setLayoutManager(layoutManager);
        rvPenginapan.setAdapter(penginapanAdapter);
    }

    @Override
    public void setPresenter(@NonNull PenginapanContract.Presenter presenter) {
        this.presenter = presenter;
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
