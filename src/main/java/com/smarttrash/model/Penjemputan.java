/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smarttrash.model;

/**
 *
 * @author allfiandi
 */

// membuat class Penjemputan yang berfungsi untuk mengatur data yang ada di dalam database
public class Penjemputan {
    // deklarasi variabel
    private int idPenjemputan;
    private String tanggalPenjemputan;
    private String statusPenjemputan;
    private String keputusanKonfirmasi;
    private String tanggalKonfirmasi;
    private String tanggalRiwayat;
    private Masyarakat masyarakat;
    private Petugas petugas;
    

    /* 
        * << Kumpulan Getter dan Setter >>
        * membuat getter dan setter untuk mengambil dan mengisi data
     */

    public int getIdPenjemputan() {
        return idPenjemputan;
    }

    public void setIdPenjemputan(int idPenjemputan) {
        this.idPenjemputan = idPenjemputan;
    }

    public String getTanggalPenjemputan() {
        return tanggalPenjemputan;
    }

    public void setTanggalPenjemputan(String tanggalPenjemputan) {
        this.tanggalPenjemputan = tanggalPenjemputan;
    }
    

    public String getStatusPenjemputan() {
        return statusPenjemputan;
    }

    public void setStatusPenjemputan(String statusPenjemputan) {
        this.statusPenjemputan = statusPenjemputan;
    }

    public String getKeputusanKonfirmasi() {
        return keputusanKonfirmasi;
    }

    public void setKeputusanKonfirmasi(String keputusanKonfirmasi) {
        this.keputusanKonfirmasi = keputusanKonfirmasi;
    }

    public String getTanggalKonfirmasi() {
        return tanggalKonfirmasi;
    }

    public void setTanggalKonfirmasi(String tanggalKonfirmasi) {
        this.tanggalKonfirmasi = tanggalKonfirmasi;
    }

    public String getTanggalRiwayat() {
        return tanggalRiwayat;
    }

    public void setTanggalRiwayat(String tanggalRiwayat) {
        this.tanggalRiwayat = tanggalRiwayat;
    }

    public Masyarakat getMasyarakat() {
        return masyarakat;
    }

    public void setMasyarakat(Masyarakat masyarakat) {
        this.masyarakat = masyarakat;
    }

    public Petugas getPetugas() {
        return petugas;
    }

    public void setPetugas(Petugas petugas) {
        this.petugas = petugas;
    }
}
