/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smarttrash.actionlistener.penjemputan;

/**
 *
 * @author allfiandi
 */

// import library yang dibutuhkan untuk membuat button
import java.awt.event.*;

import com.smarttrash.model.Penjemputan;
import com.smarttrash.model.Masyarakat;
import com.smarttrash.model.Petugas;
import com.smarttrash.dao.PenjemputanDao;
import com.smarttrash.frame.PenjemputanFrame;
public class PenjemputanButtonHapus implements ActionListener {
        // deklarasi variabel yang dibutuhkan untuk membuat button hapus
    private PenjemputanDao penjemputanDao;
    private PenjemputanFrame penjemputanFrame;

    // constructor ButtonSimpanPenjemputan untuk membuat button hapus
    public PenjemputanButtonHapus(PenjemputanFrame penjemputanFrame, PenjemputanDao penjemputanDao) {
        this.penjemputanDao = penjemputanDao;
        this.penjemputanFrame = penjemputanFrame;
    }

    // Method actionPerformed untuk mengatur aksi yang dilakukan saat button hapus diklik
    @Override
    public void actionPerformed(ActionEvent e) {
        // Mendapatkan baris yang dipilih di tabel
        int selectedRow = penjemputanFrame.getPenjemputanTable().getSelectedRow();
        
        // Validasi: Memastikan baris terpilih
        if (selectedRow == -1) {
            penjemputanFrame.showAlertMessage("Pilih baris yang akan dihapus!");
            return;
        }

        // Membuat objek Penjemputan dari baris yang dipilih
        Penjemputan penjemputan = penjemputanFrame.getPenjemputanTableModel().getPenjemputanAt(selectedRow);

        // Memanggil metode delete di PenjemputanDao
        int result = penjemputanDao.delete(penjemputan);

        // Menangani hasil operasi delete
        if (result >= 0) {
            penjemputanFrame.showSuccessMessage("Data berhasil dihapus!");
            penjemputanFrame.getPenjemputanTableModel().delete(selectedRow);
            penjemputanFrame.clearForm();
        } else {
            penjemputanFrame.showAlertMessage("Data gagal dihapus!");
        }
    }
}