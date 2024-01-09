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

public class PetugasButtonHapus implements ActionListener {
    // deklarasi variabel yang dibutuhkan untuk membuat button ubah
    private PetugasFrame petugasFrame;
    private PetugasDao petugasDao;

    // constructor PetugasButtonHapus untuk membuat button hapus
    public PetugasButtonHapus (PetugasFrame petugasFrame, PetugasDao petugasDao) {
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
            petugasFrame.showAlertMessage("Pilih baris yang akan dihapus!");
            return;
        }

        // Mendapatkan objek Petugas yang akan dihapus dari model tabel
        Petugas petugas = petugasFrame.getPetugasTableModel().getPetugasAt(selectedRow);

        // Menghapus data di database
        int result = petugasDao.delete(petugas);

        // Menampilkan pesan sesuai hasil operasi
        if (result >= 0) {
            petugasFrame.getPetugasTableModel().delete(selectedRow);
            petugasFrame.showSuccessMessage("Data berhasil dihapus!");
            petugasFrame.clearForm();
        } else {
            petugasFrame.showAlertMessage("Data gagal dihapus!");
        }
    }
}