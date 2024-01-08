/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smarttrash.actionlistener.poin;

/**
 *
 * @author allfiandi
 */

// import library yang dibutuhkan untuk membuat button
import java.awt.event.*;

import com.smarttrash.model.Poin;
import com.smarttrash.model.Kategori;
import com.smarttrash.dao.PoinDao;
import com.smarttrash.frame.PoinFrame;

// Membuat class PoinButtonUbah yang berfungsi untuk mengatur button ubah yang ada di dalam database
public class PoinButtonUbah implements ActionListener {
    // deklarasi variabel yang dibutuhkan untuk membuat button simpan
    private PoinFrame poinFrame;
    private PoinDao poinDao;

    // constructor PoinButtonUbah untuk membuat button ubah
    public PoinButtonUbah(PoinFrame poinFrame, PoinDao poinDao) {
        this.poinFrame = poinFrame;
        this.poinDao = poinDao;
    }
    
    // Method actionPerformed untuk mengatur aksi yang dilakukan saat button simpan diklik
    @Override
    public void actionPerformed(ActionEvent e) {
        int jumlahPoin = poinFrame.getJumlahPoin();
        Kategori kategori = poinFrame.getKategori();

        // Validasi data
        if (jumlahPoin <= 0 || kategori == null) {
            poinFrame.showAlertMessage("Mohon lengkapi semua data!");
            return;
        }

        // Mendapatkan baris yang dipilih di tabel
        int selectedRow = poinFrame.getPoinTable().getSelectedRow();
        if (selectedRow == -1) {
            poinFrame.showAlertMessage("Pilih baris yang ingin diubah!");
            return;
        }

        // Membuat objek Poin dari baris yang dipilih
        Poin poin = poinFrame.getPoinTableModel().getPoinAt(selectedRow);
        poin.setJumlahPoin(jumlahPoin);
        poin.setKategori(kategori);

        // Memanggil metode update di PoinDao
        int result = poinDao.update(poin);

        // Menangani hasil operasi update
        if (result >= 0) {
            poinFrame.showSuccessMessage("Data berhasil diubah!");
            poinFrame.getPoinTableModel().update(poin, selectedRow);
            poinFrame.clearForm();
        } else {
            poinFrame.showAlertMessage("Data gagal diubah!");
        }
    }
}
