package com.wahyu.smartcity.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Ujang Wahyu on 12/10/2019.
 * PT Indocyber Global Teknologi
 * ujang.wahyu@indocyber.co.id
 */
public class Jeniskuliner {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("nama_jenis")
    @Expose
    private String namaJenis;
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

    public String getNamaJenis() {
        return namaJenis;
    }

    public void setNamaJenis(String namaJenis) {
        this.namaJenis = namaJenis;
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
