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

// Membuat class JenisButtonSimpanActionListener yang berfungsi untuk mengatur button simpan yang ada di dalam database
public class JenisButtonSimpan implements ActionListener {
    private JenisFrame jenisFrame;
    private JenisDao jenisDao;

    public JenisButtonSimpan(JenisFrame jenisFrame, JenisDao jenisDao) {
        this.jenisFrame = jenisFrame;
        this.jenisDao = jenisDao;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Mendapatkan data dari frame
        String nama = jenisFrame.getNama();
        Kategori kategori = jenisFrame.getKategori();

        // Validasi data
        if (nama.isEmpty() || kategori == null) {
            jenisFrame.showAlertMessage("Nama dan kategori harus diisi.");
            return;
        }

        // Membuat objek Jenis
        Jenis jenis = new Jenis();
        jenis.setNamaJenis(nama);
        jenis.setKategori(kategori);

        // Memanggil metode insert di JenisDao
        int result = jenisDao.insert(jenis);

        // Menangani hasil operasi insert
        if (result >= 0) {
            jenisFrame.showSuccessMessage("Data berhasil disimpan.");
            jenisFrame.addJenis(jenis);
            jenisFrame.clearForm();
        } else {
            jenisFrame.showAlertMessage("Terjadi kesalahan saat menyimpan data.");
        }
    }
}