/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smarttrash.model;

/**
 *
 * @author allfiandi
 */

// membuat class Poin yang berfungsi untuk mengatur data yang ada di dalam database
public class Poin {
    // deklarasi variabel
    private int idPoin;
    private int jumlahPoin;
    private Kategori kategori;

    /* 
        * << Kumpulan Getter dan Setter >>
        * membuat getter dan setter untuk mengambil dan mengisi data
     */

    public int getIdPoin() {
        return idPoin;
    }

    public void setIdPoin(int idPoin) {
        this.idPoin = idPoin;
    }

    public int getJumlahPoin() {
        return jumlahPoin;
    }

    public void setJumlahPoin(int jumlahPoin){
        this.jumlahPoin = jumlahPoin;
    }

    public Kategori getKategori(){
        return kategori;
    }

    public void setKategori(Kategori kategori){
        this.kategori = kategori;
    }
}