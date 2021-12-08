package com.example.latihan1.model;

import java.io.Serializable;

public class PostingansStruktur implements Serializable {

    private String lokasi;
    private String nama_akun;
    private String tanggal_upload;
    private String jumlah_suka;
    private int drawableRes;

    public PostingansStruktur(String lokasi,String nama_akun, String tanggal_upload, String jumlah_suka, int drawableRes) {
        this.lokasi = lokasi;
        this.nama_akun = nama_akun;
        this.tanggal_upload = tanggal_upload;
        this.jumlah_suka = jumlah_suka;
        this.drawableRes = drawableRes;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getNama_akun() {
        return nama_akun;
    }

    public void setNama_akun(String nama_akun) {
        this.nama_akun = nama_akun;
    }

    public String getTanggal_upload() {
        return tanggal_upload;
    }

    public void setTanggal_upload(String tanggal_upload) {
        this.tanggal_upload = tanggal_upload;
    }

    public String getJumlah_suka() {
        return jumlah_suka;
    }

    public void setJumlah_suka(String jumlah_suka) {
        this.jumlah_suka = jumlah_suka;
    }

    public int getDrawableRes() {
        return drawableRes;
    }

    public void setDrawableRes(int drawableRes) {
        this.drawableRes = drawableRes;
    }
}
