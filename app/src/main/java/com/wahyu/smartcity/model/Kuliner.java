package com.wahyu.smartcity.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Ujang Wahyu on 12/10/2019.
 * PT Indocyber Global Teknologi
 * ujang.wahyu@indocyber.co.id
 */
public class Kuliner {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("nama_kuliner")
    @Expose
    private String namaKuliner;
    @SerializedName("image_url")
    @Expose
    private String imageUrl;
    @SerializedName("stok")
    @Expose
    private Integer stok;
    @SerializedName("deskripsi")
    @Expose
    private String deskripsi;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("jeniskuliner_id")
    @Expose
    private Integer jeniskulinerId;
    @SerializedName("tempatkuliner_id")
    @Expose
    private Integer tempatkulinerId;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("jeniskuliner")
    @Expose
    private Jeniskuliner jeniskuliner;
    @SerializedName("tempatkuliner")
    @Expose
    private Tempatkuliner tempatkuliner;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNamaKuliner() {
        return namaKuliner;
    }

    public void setNamaKuliner(String namaKuliner) {
        this.namaKuliner = namaKuliner;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getStok() {
        return stok;
    }

    public void setStok(Integer stok) {
        this.stok = stok;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getJeniskulinerId() {
        return jeniskulinerId;
    }

    public void setJeniskulinerId(Integer jeniskulinerId) {
        this.jeniskulinerId = jeniskulinerId;
    }

    public Integer getTempatkulinerId() {
        return tempatkulinerId;
    }

    public void setTempatkulinerId(Integer tempatkulinerId) {
        this.tempatkulinerId = tempatkulinerId;
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

    public Jeniskuliner getJeniskuliner() {
        return jeniskuliner;
    }

    public void setJeniskuliner(Jeniskuliner jeniskuliner) {
        this.jeniskuliner = jeniskuliner;
    }

    public Tempatkuliner getTempatkuliner() {
        return tempatkuliner;
    }

    public void setTempatkuliner(Tempatkuliner tempatkuliner) {
        this.tempatkuliner = tempatkuliner;
    }
}
