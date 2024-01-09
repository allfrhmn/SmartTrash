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

// Membuat class PoinButtonHapus yang berfungsi untuk mengatur button hapus yang ada di dalam database
public class PoinButtonHapus implements ActionListener {
     // deklarasi variabel yang dibutuhkan untuk membuat button simpan
    private PoinFrame poinFrame;
    private PoinDao poinDao;

    // constructor PoinButtonHapus untuk membuat button hapus
    public PoinButtonHapus(PoinFrame poinFrame, PoinDao poinDao) {
        this.poinFrame = poinFrame;
        this.poinDao = poinDao;
    }
    
    // Method actionPerformed untuk mengatur aksi yang dilakukan saat button hapus diklik
    @Override
    public void actionPerformed(ActionEvent e) {
        // Mendapatkan baris yang dipilih di tabel
        int selectedRow = poinFrame.getPoinTable().getSelectedRow();
        
        // Validasi: Memastikan baris terpilih
        if (selectedRow == -1) {
            poinFrame.showAlertMessage("Pilih baris yang akan dihapus!");
            return;
        }

        // Membuat objek Poin dari baris yang dipilih
        Poin poin = poinFrame.getPoinTableModel().getPoinAt(selectedRow);

        // Memanggil metode delete di PoinDao
        int result = poinDao.delete(poin);

        // Menangani hasil operasi delete
        if (result >= 0) {
            poinFrame.showSuccessMessage("Data berhasil dihapus!");
            poinFrame.getPoinTableModel().delete(selectedRow);
            poinFrame.clearForm();
        } else {
            poinFrame.showAlertMessage("Data gagal dihapus!");
        }
    }
}
