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

// class KategoriButtonHapus untuk membuat button hapus
public class KategoriButtonHapus implements ActionListener {
    // deklarasi variabel yang dibutuhkan untuk membuat button hapus
    private KategoriFrame kategoriFrame;
    private KategoriDao kategoriDao;

    // constructor KategoriButtonHapus untuk membuat button hapus
    public KategoriButtonHapus(KategoriFrame kategoriFrame, KategoriDao kategoriDao) {
        this.kategoriFrame = kategoriFrame;
        this.kategoriDao = kategoriDao;
    }

    // method actionPerformed untuk membuat button hapus
    @Override
    public void actionPerformed(ActionEvent e) {
        // Mendapatkan baris terpilih dari tabel
        int selectedRow = kategoriFrame.getKategoriTable().getSelectedRow();

        // Validasi: Memastikan baris terpilih
        if (selectedRow == -1) {
            kategoriFrame.showAlertMessage("Pilih baris yang akan dihapus!");
            return;
        }

        // Mendapatkan objek Kategori yang akan dihapus dari model tabel
        Kategori kategori = kategoriFrame.getKategoriTableModel().getKategoriAt(selectedRow);

        // Menghapus data dari database
        int result = kategoriDao.delete(kategori);

        // Menampilkan pesan sesuai hasil operasi
        if (result >= 0) {
            kategoriFrame.getKategoriTableModel().delete(selectedRow); // Menghapus data dari tabel
            kategoriFrame.showSuccessMessage("Data berhasil dihapus!");
            kategoriFrame.clearForm();
        } else {
            kategoriFrame.showAlertMessage("Gagal menghapus data!");
        }
    }
}