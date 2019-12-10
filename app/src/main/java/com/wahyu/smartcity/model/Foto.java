package com.wahyu.smartcity.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Ujang Wahyu on 12/10/2019.
 * PT Indocyber Global Teknologi
 * ujang.wahyu@indocyber.co.id
 */
public class Foto {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("nama_foto")
    @Expose
    private String namaFoto;
    @SerializedName("image_url")
    @Expose
    private String imageUrl;
    @SerializedName("wisata_id")
    @Expose
    private Integer wisataId;
    @SerializedName("penginapan_id")
    @Expose
    private Integer penginapanId;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("wisata")
    @Expose
    private Wisata wisata;
    @SerializedName("penginapan")
    @Expose
    private Penginapan penginapan;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNamaFoto() {
        return namaFoto;
    }

    public void setNamaFoto(String namaFoto) {
        this.namaFoto = namaFoto;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getWisataId() {
        return wisataId;
    }

    public void setWisataId(Integer wisataId) {
        this.wisataId = wisataId;
    }

    public Integer getPenginapanId() {
        return penginapanId;
    }

    public void setPenginapanId(Integer penginapanId) {
        this.penginapanId = penginapanId;
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

    public Wisata getWisata() {
        return wisata;
    }

    public void setWisata(Wisata wisata) {
        this.wisata = wisata;
    }

    public Penginapan getPenginapan() {
        return penginapan;
    }

    public void setPenginapan(Penginapan penginapan) {
        this.penginapan = penginapan;
    }
}
