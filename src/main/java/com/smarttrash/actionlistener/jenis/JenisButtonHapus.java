/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smarttrash.actionlistener.jenis;

/**
 *
 * @author Deni P
 */

// import library yang dibutuhkan untuk membuat button
import java.awt.event.*;

import com.smarttrash.dao.JenisDao;
import com.smarttrash.frame.JenisFrame;
import com.smarttrash.model.Jenis;

// Membuat class JenisButtonHapus yang berfungsi untuk mengatur button hapus yang ada di dalam database
public class JenisButtonHapus implements ActionListener {
    // deklarasi variabel yang dibutuhkan untuk membuat button hapus
    private JenisFrame jenisFrame;
    private JenisDao jenisDao;

    // constructor ButtonSimpanJenis untuk membuat button hapus
    public JenisButtonHapus(JenisFrame jenisFrame, JenisDao jenisDao) {
        this.jenisFrame = jenisFrame;
        this.jenisDao = jenisDao;
    }

    // Method actionPerformed untuk mengatur aksi yang dilakukan saat button hapus diklik
    @Override
    public void actionPerformed(ActionEvent e) {
        // Mendapatkan baris yang dipilih di tabel
        int selectedRow = jenisFrame.getJenisTable().getSelectedRow();
        
        // Validasi: Memastikan baris terpilih
        if (selectedRow == -1) {
            jenisFrame.showAlertMessage("Pilih baris yang akan dihapus!");
            return;
        }

        // Membuat objek Jenis dari baris yang dipilih
        Jenis jenis = jenisFrame.getJenisTableModel().getJenisAt(selectedRow);

        // Memanggil metode delete di JenisDao
        int result = jenisDao.delete(jenis);

        // Menangani hasil operasi delete
        if (result >= 0) {
            jenisFrame.getJenisTableModel().delete(selectedRow);
            jenisFrame.showSuccessMessage("Data berhasil dihapus!");
            jenisFrame.clearForm();
        } else {
            jenisFrame.showAlertMessage("Data gagal dihapus!");
        }
    }
}
