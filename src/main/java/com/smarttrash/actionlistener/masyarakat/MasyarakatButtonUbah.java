// package ini berisi button untuk masyarakat
package com.smarttrash.actionlistener.masyarakat;

// import library yang dibutuhkan untuk membuat button ubah
import java.awt.event.*;

import com.smarttrash.model.Masyarakat;
import com.smarttrash.dao.MasyarakatDao;
import com.smarttrash.frame.MasyarakatFrame;

// class MasyarakatButtonUbah untuk membuat button ubah
public class MasyarakatButtonUbah implements ActionListener {
    // deklarasi variabel yang dibutuhkan untuk membuat button ubah
    private MasyarakatFrame masyarakatFrame;
    private MasyarakatDao masyarakatDao;

    // constructor MasyarakatButtonUbah untuk membuat button ubah
    public MasyarakatButtonUbah(MasyarakatFrame masyarakatFrame, MasyarakatDao masyarakatDao) {
        this.masyarakatFrame = masyarakatFrame;
        this.masyarakatDao = masyarakatDao;
    }

    // method actionPerformed untuk membuat button ubah
    @Override
    public void actionPerformed(ActionEvent e) {
        // Mendapatkan baris terpilih dari tabel
        int selectedRow = masyarakatFrame.getMasyarakatTable().getSelectedRow();
        
        // Validasi: Memastikan baris terpilih
        if (selectedRow == -1) {
            masyarakatFrame.showAlertMessage("Pilih baris yang akan diubah!");
            return;
        }

        // Mendapatkan objek Masyarakat yang akan diubah dari model tabel
        Masyarakat masyarakat = masyarakatFrame.getMasyarakatTableModel().getMasyarakatAt(selectedRow);

        // Mengambil data dari input form di frame
        String nama = masyarakatFrame.getNama();
        String alamat = masyarakatFrame.getAlamat();
        String noTelp = masyarakatFrame.getNoTelp();
        String email = masyarakatFrame.getEmail();
        String statusPendaftaran = masyarakatFrame.getStatus();

        // Validasi: Memastikan semua input terisi
        if (nama.isEmpty() || alamat.isEmpty() || noTelp.isEmpty() || email.isEmpty() || statusPendaftaran.isEmpty()) {
            masyarakatFrame.showAlertMessage("Mohon lengkapi semua data!");
            return;
        }

        // Mengatur nilai atribut Masyarakat dengan data dari form
        masyarakat.setNama(nama);
        masyarakat.setAlamat(alamat);
        masyarakat.setNoTelp(noTelp);
        masyarakat.setEmail(email);
        masyarakat.setStatusPendaftaran(statusPendaftaran);

        // Memperbarui data di database
        int result = masyarakatDao.update(masyarakat);

        // Menampilkan pesan sesuai hasil operasi
        if (result >= 0) {
            masyarakatFrame.getMasyarakatTableModel().update(masyarakat, selectedRow); // Memperbarui data di tabel
            masyarakatFrame.showSuccessMessage("Data berhasil diubah!");
            masyarakatFrame.clearForm();
        } else {
            masyarakatFrame.showAlertMessage("Gagal mengubah data!");
        }
    }
}