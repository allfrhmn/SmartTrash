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
import com.smarttrash.model.Kategori;

// Membuat class JenisButtonHapus yang berfungsi untuk mengatur button ubah yang ada di dalam database
public class JenisButtonUbah implements ActionListener {
    // deklarasi variabel yang dibutuhkan untuk membuat button ubah
    private JenisFrame jenisFrame;
    private JenisDao jenisDao;

    // Konstruktor dari class JenisButtonUbahActionListener
    public JenisButtonUbah(JenisFrame jenisFrame, JenisDao jenisDao) {
        this.jenisFrame = jenisFrame;
        this.jenisDao = jenisDao;
    }

    // Method actionPerformed untuk mengatur aksi yang dilakukan saat button ubah diklik
    @Override
    public void actionPerformed(ActionEvent e) {
        // Mendapatkan data dari frame
        String nama = jenisFrame.getNama();
        Kategori kategori = jenisFrame.getKategori();

        // Validasi data
        if (nama.isEmpty() || kategori == null) {
            jenisFrame.showAlertMessage("Pilih data yang akan diubah!");
            return;
        }

        // Mendapatkan baris yang dipilih di tabel
        int selectedRow = jenisFrame.getJenisTable().getSelectedRow();
        if (selectedRow == -1) {
            jenisFrame.showAlertMessage("Pilih baris yang ingin diubah.");
            return;
        }

        // Membuat objek Jenis dari baris yang dipilih
        Jenis jenis = jenisFrame.getJenisTableModel().getJenisAt(selectedRow);
        jenis.setNamaJenis(nama);
        jenis.setKategori(kategori);

        // Memanggil metode update di JenisDao
        int result = jenisDao.update(jenis);

        // Menangani hasil operasi update
        if (result >= 0) {
            jenisFrame.showSuccessMessage("Data berhasil diubah.");
            jenisFrame.getJenisTableModel().update(jenis, selectedRow);
            jenisFrame.clearForm(); 
        } else {
            jenisFrame.showAlertMessage("Terjadi kesalahan saat mengubah data.");
        }
    }
}
