/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smarttrash.model;

/**
 *
 * @author Emilia Paradila S
 */

    // membuat class Masyarakat yang berfungsi untuk mengatur data yang ada di dalam database
public class Masyarakat {
    // deklarasi variabel
    private int idMasyarakat;
    private String nama;
    private String alamat;
    private String noTelp;
    private String email;
    private String statusPendaftaran;

    /* 
        * << Kumpulan Getter dan Setter >>
        * membuat getter dan setter untuk mengambil dan mengisi data
     */
    public int getIdMasyarakat() {
        return idMasyarakat;
    }

    public void setIdMasyarakat(int idMasyarakat) {
        this.idMasyarakat = idMasyarakat;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
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

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getStatusPendaftaran(){
        return statusPendaftaran;
    }

    public void setStatusPendaftaran(String statusPendaftaran){
        this.statusPendaftaran = statusPendaftaran;
    }
}
    
