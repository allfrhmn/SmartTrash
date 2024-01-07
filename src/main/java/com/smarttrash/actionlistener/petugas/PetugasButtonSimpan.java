/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

// package ini berisi button untuk petugas
package com.smarttrash.actionlistener.petugas;

/**
 *
 * @author imam
 */

// import library yang dibutuhkan untuk membuat button simpan
import java.awt.event.*;

import com.smarttrash.model.Petugas;
import com.smarttrash.dao.PetugasDao;
import com.smarttrash.frame.PetugasFrame;

// class PetugasButtonSimpan untuk membuat button simpan
public class PetugasButtonSimpan implements ActionListener {
    // deklarasi variabel yang dibutuhkan untuk membuat button simpan
    private PetugasDao petugasDao;
    private PetugasFrame petugasFrame;

    // constructor PetugasButtonSimpan untuk membuat button simpan
    public PetugasButtonSimpan(PetugasFrame petugasFrame, PetugasDao petugasDao) {
        this.petugasDao = petugasDao;
        this.petugasFrame = petugasFrame;
    }

    // method actionPerformed untuk menangani event klik pada button simpan
    @Override
    public void actionPerformed(ActionEvent e) {
        String nama = petugasFrame.getNama();
        String alamat = petugasFrame.getAlamat();
        String noTelp = petugasFrame.getNoTelp();
        String jabatan = petugasFrame.getJabatan();
        String statusPendaftaran = petugasFrame.getStatus();

        // Validasi: Memeriksa apakah ada teks yang kosong
        if (nama.isEmpty() || alamat.isEmpty() || noTelp.isEmpty() || jabatan.isEmpty() || statusPendaftaran.isEmpty()) {
            petugasFrame.showAlertMessage("Mohon lengkapi semua data!");
            return; // Menghentikan eksekusi lebih lanjut jika data tidak valid
        }

        // Membuat objek Petugas baru
        Petugas petugas = new Petugas();
        petugas.setNama(nama);
        petugas.setAlamat(alamat);
        petugas.setNoTelp(noTelp);
        petugas.setJabatan(jabatan);
        petugas.setStatusPendaftaran(statusPendaftaran);

        // Menyimpan data baru ke database
        int result = petugasDao.insert(petugas);

        // Menampilkan pesan sesuai hasil operasi
        if (result >= 0) {
            petugasFrame.getPetugasTableModel().add(petugas);
            petugasFrame.showSuccessMessage("Data berhasil disimpan!");
            petugasFrame.clearForm();
        } else {
            petugasFrame.showAlertMessage("Data gagal disimpan!");
        }
    }
}