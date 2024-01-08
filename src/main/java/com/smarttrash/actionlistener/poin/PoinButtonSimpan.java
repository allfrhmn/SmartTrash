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

// Membuat class PoinButtonSimpan yang berfungsi untuk mengatur button simpan yang ada di dalam database
public class PoinButtonSimpan implements ActionListener {
    // deklarasi variabel yang dibutuhkan untuk membuat button simpan
    private PoinFrame poinFrame;
    private PoinDao poinDao;

    // constructor PoinButtonSimpan untuk membuat button simpan
    public PoinButtonSimpan(PoinFrame poinFrame, PoinDao poinDao) {
        this.poinFrame = poinFrame;
        this.poinDao = poinDao;
    }

    // Method actionPerformed untuk mengatur aksi yang dilakukan saat button simpan diklik
    @Override
    public void actionPerformed(ActionEvent e) {
        // Mendapatkan data dari frame
        int jumlahPoin = poinFrame.getJumlahPoin();
        Kategori kategori = poinFrame.getKategori();

        // Validasi data
        if (jumlahPoin <= 0 || kategori == null) {
            poinFrame.showAlertMessage("Mohon lengkapi semua data!");
            return;
        }

        // Membuat objek Poin
        Poin poin = new Poin();
        poin.setJumlahPoin(jumlahPoin);
        poin.setKategori(kategori);

        // Memanggil metode insert di PoinDao
        int result = poinDao.insert(poin);

        // Menangani hasil operasi insert
        if (result >= 0) {
            poinFrame.showSuccessMessage("Data berhasil disimpan!");
            poinFrame.addPoin(poin);
            poinFrame.clearForm();
        } else {
            poinFrame.showAlertMessage("Data gagal dihapus");
        }
    }
}
