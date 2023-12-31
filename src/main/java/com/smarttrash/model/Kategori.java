/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smarttrash.model;

/**
 *
 * @author salma
 */

// membuat class Kategori yang berfungsi untuk mengatur pemodelan data yang ada di dalam database
public class Kategori {
    // deklarasi variabel
    private int idKategori;
    private String namaKategori;

    /* 
        * << Kumpulan Getter dan Setter >>
        * membuat getter dan setter untuk mengambil dan mengisi data
     */

    public int getIdKategori() {
        return idKategori;
    }

    public void setIdKategori(int idKategori) {
        this.idKategori = idKategori;
    }

    public String getNamaKategori() {
        return namaKategori;
    }

    public void setNamaKategori(String namaKategori){
        this.namaKategori = namaKategori;
    }
}