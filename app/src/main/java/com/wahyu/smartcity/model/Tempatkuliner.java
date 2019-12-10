package com.wahyu.smartcity.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Ujang Wahyu on 12/10/2019.
 * PT Indocyber Global Teknologi
 * ujang.wahyu@indocyber.co.id
 */
public class Tempatkuliner {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("nama_tempat")
    @Expose
    private String namaTempat;
    @SerializedName("nama_pemilik")
    @Expose
    private String namaPemilik;
    @SerializedName("lokasi")
    @Expose
    private String lokasi;
    @SerializedName("latitude")
    @Expose
    private String latitude;
    @SerializedName("longitude")
    @Expose
    private String longitude;
    @SerializedName("image_url")
    @Expose
    private String imageUrl;
    @SerializedName("waktu_buka")
    @Expose
    private String waktuBuka;
    @SerializedName("waktu_tutup")
    @Expose
    private String waktuTutup;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("kuliner")
    @Expose
    private List<Kuliner> kuliner = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNamaTempat() {
        return namaTempat;
    }

    public void setNamaTempat(String namaTempat) {
        this.namaTempat = namaTempat;
    }

    public String getNamaPemilik() {
        return namaPemilik;
    }

    public void setNamaPemilik(String namaPemilik) {
        this.namaPemilik = namaPemilik;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getWaktuBuka() {
        return waktuBuka;
    }

    public void setWaktuBuka(String waktuBuka) {
        this.waktuBuka = waktuBuka;
    }

    public String getWaktuTutup() {
        return waktuTutup;
    }

    public void setWaktuTutup(String waktuTutup) {
        this.waktuTutup = waktuTutup;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Kuliner> getKuliner() {
        return kuliner;
    }

    public void setKuliner(List<Kuliner> kuliner) {
        this.kuliner = kuliner;
    }
}
