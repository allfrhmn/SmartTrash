/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

// package ini berisi button untuk kategori
package com.smarttrash.actionlistener.kategori;

/**
 *
 * @author salma
 */


// import library yang dibutuhkan untuk membuat button
import java.awt.event.*;

import com.smarttrash.model.Kategori;
import com.smarttrash.dao.KategoriDao;
import com.smarttrash.frame.KategoriFrame;

// Membuat class KategoriButtonSimpan yang berfungsi untuk mengatur button simpan di dalam frame Kategori
public class KategoriButtonSimpan implements ActionListener {
    // deklarasi variabel yang dibutuhkan untuk mengatur button simpan
    private KategoriFrame kategoriFrame;
    private KategoriDao kategoriDao;

    // constructor KategoriButtonSimpan untuk mengatur button simpan
    public KategoriButtonSimpan(KategoriFrame kategoriFrame, KategoriDao kategoriDao) {
        this.kategoriFrame = kategoriFrame;
        this.kategoriDao = kategoriDao;
    }

    // method actionPerformed untuk mengatur button simpan
    @Override
    public void actionPerformed(ActionEvent e) {
        // Mengambil data dari input form di frame
        String nama = kategoriFrame.getNama();

        // Validasi: Memastikan semua input terisi
        if (nama.isEmpty()) {
            kategoriFrame.showAlertMessage("Mohon lengkapi semua data!");
            return;
        }

        // Membuat objek Kategori baru dengan data dari form
        Kategori kategori = new Kategori();
        kategori.setNamaKategori(nama);

        // Menyimpan data baru ke database
        int result = kategoriDao.insert(kategori);

        // Menampilkan pesan sesuai hasil operasi
        if (result >= 0) {
            kategoriFrame.getKategoriTableModel().add(kategori);
            kategoriFrame.showSuccessMessage("Data berhasil disimpan!");
            kategoriFrame.clearForm();
        } else {
            kategoriFrame.showAlertMessage("Data gagal disimpan!");
        }
    }
}