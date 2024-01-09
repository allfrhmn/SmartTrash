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

public class PenjemputanButtonUbah implements ActionListener {
    // deklarasi variabel yang dibutuhkan untuk membuat button ubah
    private PenjemputanDao penjemputanDao;
    private PenjemputanFrame penjemputanFrame;

    // constructor ButtonUbahPenjemputan untuk membuat button ubah
    public PenjemputanButtonUbah(PenjemputanFrame penjemputanFrame, PenjemputanDao penjemputanDao) {
        this.penjemputanDao = penjemputanDao;
        this.penjemputanFrame = penjemputanFrame;
    }

    // Method actionPerformed untuk mengatur aksi yang dilakukan saat button ubah diklik
    @Override
    public void actionPerformed(ActionEvent e) {
        // Mendapatkan data dari frame
        String tanggalPenjemputan = penjemputanFrame.getTanggalPenjemputan();
        String statusPenjemputan = penjemputanFrame.getStatusPenjemputan();
        String keputusanKonfirmasi = penjemputanFrame.getKeputusanKonfirmasi();
        String tanggalKonfirmasi = penjemputanFrame.getTanggalKonfirmasi();
        String tanggalRiwayat = penjemputanFrame.getTanggalRiwayat();
        
        Masyarakat masyarakat = penjemputanFrame.getMasyarakat();
        Petugas petugas = penjemputanFrame.getPetugas();

        // Validasi data
        if (tanggalPenjemputan.isEmpty() || statusPenjemputan.isEmpty() || keputusanKonfirmasi.isEmpty() || tanggalKonfirmasi.isEmpty() || tanggalRiwayat.isEmpty() || masyarakat == null || petugas == null) {
            penjemputanFrame.showAlertMessage("Mohon lengkapi semua data!");
            return;
        }

        // Mendapatkan baris yang dipilih di tabel
        int selectedRow = penjemputanFrame.getPenjemputanTable().getSelectedRow();
        
        // Validasi: Memastikan baris terpilih
        if (selectedRow == -1) {
            penjemputanFrame.showAlertMessage("Pilih baris yang akan diubah!");
            return;
        }
        
        // Membuat objek Penjemputan dari baris yang dipilih
        Penjemputan penjemputan = penjemputanFrame.getPenjemputanTableModel().getPenjemputanAt(selectedRow);

        // Mengatur nilai atribut Penjemputan dengan data dari form
        penjemputan.setTanggalPenjemputan(tanggalPenjemputan);
        penjemputan.setStatusPenjemputan(statusPenjemputan);
        penjemputan.setKeputusanKonfirmasi(keputusanKonfirmasi);
        penjemputan.setTanggalKonfirmasi(tanggalKonfirmasi);
        penjemputan.setTanggalRiwayat(tanggalRiwayat);
        penjemputan.setMasyarakat(masyarakat);
        penjemputan.setPetugas(petugas);

        // Memanggil metode update di PenjemputanDao
        int result = penjemputanDao.update(penjemputan);

        // Menangani hasil operasi update
        if (result >= 0) {
            penjemputanFrame.showSuccessMessage("Data berhasil diubah!");
            penjemputanFrame.getPenjemputanTableModel().update(penjemputan, selectedRow);
            penjemputanFrame.clearForm(); 
        } else {
            penjemputanFrame.showAlertMessage("Data gagal diubah!");
        }
    }
}