package com.example.latihanrv;

public class ModelRV {
    private int id;
    private String nama,nik, nomor,email,tanggal,asal,tujuan;

    public ModelRV(int id, String nama, String nik, String nomor, String email, String tanggal, String asal, String tujuan) {
        this.id = id;
        this.nama = nama;
        this.nik = nik;
        this.nomor = nomor;
        this.email = email;
        this.tanggal = tanggal;
        this.asal = asal;
        this.tujuan = tujuan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNomor() {
        return nomor;
    }

    public void setNomor(String nomor) {
        this.nomor = nomor;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getAsal() {
        return asal;
    }

    public void setAsal(String asal) {
        this.asal = asal;
    }

    public String getTujuan() {
        return tujuan;
    }

    public void setTujuan(String tujuan) {
        this.tujuan = tujuan;
    }
}
