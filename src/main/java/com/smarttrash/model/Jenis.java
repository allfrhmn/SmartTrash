<<<<<<< HEAD
package com.smarttrash.model;

=======
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smarttrash.model;

/**
 *
 * @author Deni P
 */

>>>>>>> 7f03aae843bf151b2a76a8d4102322cd44051ad4
// membuat class Jenis yang berfungsi untuk mengatur data yang ada di dalam database
public class Jenis {
    // deklarasi variabel
    private int idJenis;
    private String namaJenis;
    private Kategori kategori;

    /* 
        * << Kumpulan Getter dan Setter >>
        * membuat getter dan setter untuk mengambil dan mengisi data
     */

    public int getIdJenis() {
        return idJenis;
    }

    public void setIdJenis(int idJenis) {
        this.idJenis = idJenis;
    }

    public String getNamaJenis() {
        return namaJenis;
    }

    public void setNamaJenis(String namaJenis){
        this.namaJenis = namaJenis;
    }

    public Kategori getKategori(){
        return kategori;
    }

    public void setKategori(Kategori kategori){
        this.kategori = kategori;
    }
}