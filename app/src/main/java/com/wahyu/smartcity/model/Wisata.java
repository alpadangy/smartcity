package com.wahyu.smartcity.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Ujang Wahyu on 12/10/2019.
 * PT Indocyber Global Teknologi
 * ujang.wahyu@indocyber.co.id
 */
public class Wisata {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("nama_tempat")
    @Expose
    private String namaTempat;
    @SerializedName("image_url")
    @Expose
    private String imageUrl;
    @SerializedName("deskripsi")
    @Expose
    private String deskripsi;
    @SerializedName("waktu_buka")
    @Expose
    private String waktuBuka;
    @SerializedName("waktu_tutup")
    @Expose
    private String waktuTutup;
    @SerializedName("no_telepon")
    @Expose
    private String noTelepon;
    @SerializedName("website")
    @Expose
    private String website;
    @SerializedName("ratting")
    @Expose
    private String ratting;
    @SerializedName("kategori_id")
    @Expose
    private Integer kategoriId;
    @SerializedName("lokasi_id")
    @Expose
    private Integer lokasiId;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("deleted_at")
    @Expose
    private String deletedAt;
    @SerializedName("kategori")
    @Expose
    private Kategori kategori;
    @SerializedName("lokasi")
    @Expose
    private Lokasi lokasi;
    @SerializedName("foto")
    @Expose
    private List<Foto> foto = null;

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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
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

    public String getNoTelepon() {
        return noTelepon;
    }

    public void setNoTelepon(String noTelepon) {
        this.noTelepon = noTelepon;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getRatting() {
        return ratting;
    }

    public void setRatting(String ratting) {
        this.ratting = ratting;
    }

    public Integer getKategoriId() {
        return kategoriId;
    }

    public void setKategoriId(Integer kategoriId) {
        this.kategoriId = kategoriId;
    }

    public Integer getLokasiId() {
        return lokasiId;
    }

    public void setLokasiId(Integer lokasiId) {
        this.lokasiId = lokasiId;
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

    public String getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(String deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Kategori getKategori() {
        return kategori;
    }

    public void setKategori(Kategori kategori) {
        this.kategori = kategori;
    }

    public Lokasi getLokasi() {
        return lokasi;
    }

    public void setLokasi(Lokasi lokasi) {
        this.lokasi = lokasi;
    }

    public List<Foto> getFoto() {
        return foto;
    }

    public void setFoto(List<Foto> foto) {
        this.foto = foto;
    }
}
