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

// import library yang dibutuhkan untuk membuat button ubah
import java.awt.event.*;

import com.smarttrash.model.Petugas;
import com.smarttrash.dao.PetugasDao;
import com.smarttrash.frame.PetugasFrame;

// class PetugasButtonUbah untuk membuat button ubah
public class PetugasButtonUbah implements ActionListener {
    // deklarasi variabel yang dibutuhkan untuk membuat button ubah
    private PetugasFrame petugasFrame;
    private PetugasDao petugasDao;

    // constructor PetugasButtonUbah untuk membuat button ubah
    public PetugasButtonUbah(PetugasFrame petugasFrame, PetugasDao petugasDao) {
        this.petugasFrame = petugasFrame;
        this.petugasDao = petugasDao;
    }

    // method actionPerformed untuk membuat button ubah
    @Override
    public void actionPerformed(ActionEvent e) {
        // Mendapatkan baris terpilih dari tabel
        int selectedRow = petugasFrame.getPetugasTable().getSelectedRow();

        // Validasi: Memastikan baris terpilih
        if (selectedRow == -1) {
            petugasFrame.showAlertMessage("Pilih data yang akan diubah!");
            return;
        }

        // Mendapatkan objek Petugas yang akan diubah dari model tabel
        Petugas petugas = petugasFrame.getPetugasTableModel().getPetugasAt(selectedRow);

        // Mengambil data dari input form di frame
        String nama = petugasFrame.getNama();
        String alamat = petugasFrame.getAlamat();
        String noTelp = petugasFrame.getNoTelp();
        String jabatan = petugasFrame.getJabatan();
        String statusPendaftaran = petugasFrame.getStatus();
        
        // Validasi: Memastikan semua input terisi
        if (nama.isEmpty() || alamat.isEmpty() || noTelp.isEmpty() || jabatan.isEmpty() || statusPendaftaran.isEmpty()) {
            petugasFrame.showAlertMessage("Mohon lengkapi semua data!");
            return;
        }

        // Mengatur nilai atribut Petugas dengan data dari form
        petugas.setNama(nama);
        petugas.setAlamat(alamat);
        petugas.setNoTelp(noTelp);
        petugas.setJabatan(jabatan);
        petugas.setStatusPendaftaran(statusPendaftaran);

        // Memperbarui data di database
        int result = petugasDao.update(petugas);

        // Menampilkan pesan sesuai hasil operasi
        if (result >= 0) {
            petugasFrame.getPetugasTableModel().update(petugas, selectedRow);
            petugasFrame.showSuccessMessage("Data berhasil diubah!");
            petugasFrame.clearForm();
        } else {
            petugasFrame.showAlertMessage("Data gagal diubah!");
        }
    }
}