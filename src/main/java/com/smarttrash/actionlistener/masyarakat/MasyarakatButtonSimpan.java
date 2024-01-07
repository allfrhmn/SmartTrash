// package ini berisi button untuk masyarakat
package com.smarttrash.actionlistener.masyarakat;

/**
 *
 * @author Emilia Paradila S
 */

 // import library yang dibutuhkan untuk membuat button simpan
import java.awt.event.*;

import com.smarttrash.model.Masyarakat;
import com.smarttrash.dao.MasyarakatDao;
import com.smarttrash.frame.MasyarakatFrame;

// class MasyarakatButtonSimpanActionListener untuk membuat button simpan
public class MasyarakatButtonSimpan implements ActionListener {
    // deklarasi variabel yang dibutuhkan untuk membuat button simpan
    private MasyarakatDao masyarakatDao;
    private MasyarakatFrame masyarakatFrame;
    
    // constructor MasyarakatButtonSimpanActionListener untuk membuat button simpan
    public MasyarakatButtonSimpan(MasyarakatFrame masyarakatFrame, MasyarakatDao masyarakatDao) {
        this.masyarakatFrame = masyarakatFrame;
        this.masyarakatDao = masyarakatDao;
    }

    // method actionPerformed untuk menangani event klik pada button simpan
    @Override
    public void actionPerformed(ActionEvent e) {
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

        // Membuat objek Masyarakat baru dengan data dari form
        Masyarakat masyarakat = new Masyarakat();
        masyarakat.setNama(nama);
        masyarakat.setAlamat(alamat);
        masyarakat.setNoTelp(noTelp);
        masyarakat.setEmail(email);
        masyarakat.setStatusPendaftaran(statusPendaftaran);

        // Menyimpan data baru ke database
        int result = masyarakatDao.insert(masyarakat);

        // Menampilkan pesan sesuai hasil operasi
        if (result >= 0) {
            masyarakatFrame.getMasyarakatTableModel().add(masyarakat);
            masyarakatFrame.showSuccessMessage("Data berhasil disimpan!");
            masyarakatFrame.clearForm();
        } else {
            masyarakatFrame.showAlertMessage("Gagal menyimpan data!");
        }
    }
}