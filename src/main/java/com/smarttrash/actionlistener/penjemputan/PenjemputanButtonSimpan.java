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

public class PenjemputanButtonSimpan implements ActionListener {
    // deklarasi variabel yang dibutuhkan untuk membuat button simpan
    private PenjemputanDao penjemputanDao;
    private PenjemputanFrame penjemputanFrame;
    
    // constructor ButtonSimpanPenjemputan untuk membuat button simpan
    public PenjemputanButtonSimpan(PenjemputanFrame penjemputanFrame, PenjemputanDao penjemputanDao) {
        this.penjemputanDao = penjemputanDao;
        this.penjemputanFrame = penjemputanFrame;
    }

    // Method actionPerformed untuk mengatur aksi yang dilakukan saat button simpan diklik
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

        // Membuat objek Penjemputan
        Penjemputan penjemputan = new Penjemputan();
        penjemputan.setTanggalPenjemputan(tanggalPenjemputan);
        penjemputan.setStatusPenjemputan(statusPenjemputan);
        penjemputan.setKeputusanKonfirmasi(keputusanKonfirmasi);
        penjemputan.setTanggalKonfirmasi(tanggalKonfirmasi);
        penjemputan.setTanggalRiwayat(tanggalRiwayat);
        penjemputan.setMasyarakat(masyarakat);
        penjemputan.setPetugas(petugas);

        // Memanggil metode insert di PenjemputanDao
        int result = penjemputanDao.insert(penjemputan);

        // Menangani hasil operasi insert
        if (result >= 0) {
            penjemputanFrame.showSuccessMessage("Data berhasil disimpan!");
            penjemputanFrame.addPenjemputan(penjemputan);
            penjemputanFrame.clearForm();
        } else {
            penjemputanFrame.showAlertMessage("Data gagal disimpan!");
        }
    }
}
