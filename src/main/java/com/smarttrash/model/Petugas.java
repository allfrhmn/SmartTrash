/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smarttrash.model;

/**
 *
 * @author imam
 */
public class Petugas {
    // deklarasi variabel
    private int idPetugas;
    private String nama;
    private String alamat;
    private String noTelp;
    private String jabatan;
    private String statusPendaftaran;

    /* 
        * << Kumpulan Getter dan Setter >>
        * membuat getter dan setter untuk mengambil dan mengisi data
     */

    public int getIdPetugas() {
        return idPetugas;
    }

    public void setIdPetugas(int idPetugas) {
        this.idPetugas = idPetugas;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    public String getAlamat(){
        return alamat;
    }

    public void setAlamat(String alamat){
        this.alamat = alamat;
    }

    public String getNoTelp(){
        return noTelp;
    }

    public void setNoTelp(String noTelp){
        this.noTelp = noTelp;
    }

    public String getJabatan(){
        return jabatan;
    }

    public void setJabatan(String jabatan){
        this.jabatan = jabatan;
    }

    public String getStatusPendaftaran(){
        return statusPendaftaran;
    }

    public void setStatusPendaftaran(String statusPendaftaran){
        this.statusPendaftaran = statusPendaftaran;
    }
}
