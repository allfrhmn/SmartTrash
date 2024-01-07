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

// class KategoriButtonUbah untuk membuat button ubah
public class KategoriButtonUbah implements ActionListener {
    // deklarasi variabel yang dibutuhkan untuk membuat button ubah
    private KategoriFrame kategoriFrame;
    private KategoriDao kategoriDao;
    
    // constructor KategoriButtonUbahuntuk membuat button ubah
    public KategoriButtonUbah(KategoriFrame kategoriFrame, KategoriDao kategoriDao) {
        this.kategoriFrame = kategoriFrame;
        this.kategoriDao = kategoriDao;
    }

    // method actionPerformed untuk membuat button ubah
    @Override
    public void actionPerformed(ActionEvent e) {
        // Mendapatkan baris terpilih dari tabel
        int selectedRow = kategoriFrame.getKategoriTable().getSelectedRow();
        
        // Validasi: Memastikan baris terpilih
        if (selectedRow == -1) {
            kategoriFrame.showAlertMessage("Pilih data yang akan diubah!");
            return;
        }

        // Mendapatkan objek Kategori yang akan diubah dari model tabel
        Kategori kategori = kategoriFrame.getKategoriTableModel().getKategoriAt(selectedRow);

        // Mengambil data dari input form di frame
        String nama = kategoriFrame.getNama();

        // Validasi: Memastikan semua input terisi
        if (nama.isEmpty()) {
            kategoriFrame.showAlertMessage("Mohon lengkapi semua data!");
            return;
        }

        // Mengatur nilai atribut Kategori dengan data dari form
        kategori.setNamaKategori(nama);

        // Memperbarui data di database
        int result = kategoriDao.update(kategori);

        // Menampilkan pesan sesuai hasil operasi
        if (result >= 0) {
            kategoriFrame.getKategoriTableModel().update(kategori, selectedRow);
            kategoriFrame.showSuccessMessage("Data berhasil diubah!");
            kategoriFrame.clearForm();
        } else {
            kategoriFrame.showAlertMessage("Data gagal diubah!");
        }
    }
}