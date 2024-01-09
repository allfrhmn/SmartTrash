/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

// package ini berisi button untuk masyarakat
package com.smarttrash.actionlistener.masyarakat;

/**
 *
 * @author Emilia Paradila S
 */

// import library yang dibutuhkan untuk membuat button
import java.awt.event.*;

import com.smarttrash.model.Masyarakat;
import com.smarttrash.dao.MasyarakatDao;
import com.smarttrash.frame.MasyarakatFrame;

// class MasyarakatButtonHapus untuk membuat button simpan
public class MasyarakatButtonHapus implements ActionListener {
    // deklarasi variabel yang dibutuhkan untuk membuat button
    private MasyarakatFrame masyarakatFrame;
    private MasyarakatDao masyarakatDao;

    // constructor MasyarakatButtonHapus untuk membuat button
    public MasyarakatButtonHapus(MasyarakatFrame masyarakatFrame, MasyarakatDao masyarakatDao) {
        this.masyarakatFrame = masyarakatFrame;
        this.masyarakatDao = masyarakatDao;
    }

    // method actionPerformed untuk menangani event klik pada button
    @Override
    public void actionPerformed(ActionEvent e) {
        // Mendapatkan baris terpilih dari tabel
        int selectedRow = masyarakatFrame.getMasyarakatTable().getSelectedRow();

        // Validasi: Memastikan baris terpilih
        if (selectedRow == -1) {
            masyarakatFrame.showAlertMessage("Pilih baris yang akan dihapus!");
            return;
        }

        // Mendapatkan objek Masyarakat yang akan dihapus dari model tabel
        Masyarakat masyarakat = masyarakatFrame.getMasyarakatTableModel().getMasyarakatAt(selectedRow);

        // Menghapus data dari database
        int result = masyarakatDao.delete(masyarakat);

        // Menampilkan pesan sesuai hasil operasi
        if (result >= 0) {
            masyarakatFrame.getMasyarakatTableModel().delete(selectedRow);
            masyarakatFrame.showSuccessMessage("Data berhasil dihapus!");
        } else {
            masyarakatFrame.showAlertMessage("Gagal menghapus data!");
        }
    }
}