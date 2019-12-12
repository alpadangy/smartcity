package com.wahyu.smartcity.view.detailwisata;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wahyu.smartcity.R;
import com.wahyu.smartcity.base.BaseActivity;
import com.wahyu.smartcity.model.Wisata;
import com.wahyu.smartcity.presenter.detailwisata.DetailWisataContract;
import com.wahyu.smartcity.presenter.detailwisata.DetailWisataPresenter;

public class DetailWisataActivity extends BaseActivity implements DetailWisataContract.View {

    private CollapsingToolbarLayout toolBarLayout;
    private Toolbar toolbar;
    private DetailWisataContract.Presenter presenter;
    private Bundle inBundle;
    private Wisata wisata;

    private String namaWisata, lokasi, alamatLengkap, waktuBuka, waktuTutup, website, noTelp, deskripsi;
    private TextView tvNamaWisata, tvLokasi, tvAlamatLengkap, tvWaktuBuka, tvWaktuTutup, tvWebsite, tvNoTelp, tvDeskripsi;
    private ImageView imgCover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_wisata);
        toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);

        findViews();
        initViews();
        initListeners();

        presenter.start();
    }

    @Override
    public void findViews() {
        inBundle = getIntent().getExtras();
        toolbar = findViewById(R.id.toolbar);
        imgCover = findViewById(R.id.img_cover);
        tvLokasi = findViewById(R.id.tv_lokasi);
        tvAlamatLengkap = findViewById(R.id.tv_alamat_lengkap);
        tvWaktuBuka = findViewById(R.id.tv_waktu_buka);
        tvWaktuTutup = findViewById(R.id.tv_waktu_tutup);
        tvWebsite = findViewById(R.id.tv_website);
        tvNoTelp = findViewById(R.id.tv_no_telp);
        tvDeskripsi = findViewById(R.id.tv_deskripsi);
    }

    @Override
    public void initViews() {
        setSupportActionBar(toolbar);
        inBundle = getIntent().getExtras();
        new DetailWisataPresenter(this, inBundle);
    }

    @Override
    public void initListeners() {

    }

    @Override
    public void setPresenter(@NonNull DetailWisataContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void detailWisata(Wisata wisata) {
        namaWisata = wisata.getNamaTempat();
        lokasi = wisata.getLokasi().getKabupaten();
        alamatLengkap = wisata.getLokasi().getNamaLokasi();
        waktuBuka = wisata.getWaktuBuka();
        waktuTutup = wisata.getWaktuTutup();
        website = wisata.getWebsite();
        noTelp = wisata.getNoTelepon();
        deskripsi = wisata.getDeskripsi();

        tvLokasi.setText(lokasi);
        tvAlamatLengkap.setText(alamatLengkap);
        tvWaktuBuka.setText("Buka : " + waktuBuka);
        tvWaktuTutup.setText("Tutup : " + waktuTutup);
        tvWebsite.setText(website);
        tvNoTelp.setText(noTelp);
        tvDeskripsi.setText(deskripsi);

        toolBarLayout.setTitle(namaWisata);
        toolbar.setTitle(namaWisata);
        Glide.with(this).load(wisata.getImageUrl()).into(imgCover).toString();

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
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
