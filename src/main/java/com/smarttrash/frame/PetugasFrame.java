/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.smarttrash.frame;

/**
 *
 * @author imam
 */

// import library yang dibutuhkan untuk membuat frame Petugas
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


import com.smarttrash.actionlistener.petugas.*;
import com.smarttrash.dao.PetugasDao;
import com.smarttrash.model.Petugas;
//import com.smarttrash.button.petugas.*;
import com.smarttrash.table.PetugasTableModel;

// class PetugasFrame untuk membuat frame Petugas
public class PetugasFrame extends JFrame {
    // deklarasi variabel yang dibutuhkan untuk membuat frame Petugas
    private List<Petugas> petugasList;
    private PetugasDao petugasDao;
    private PetugasTableModel petugasTableModel;
    private JTable petugasTable;
    private JScrollPane scrollableTable;

    private JLabel titleLabel;
    
    private JLabel namaLabel;
    private JLabel alamatLabel;
    private JLabel noTelpLabel;
    private JLabel jabatanLabel;
    private JLabel statusLabel;

    private JTextField namaTextField;
    private JTextArea alamatTextArea;
    private JTextField noTelpTextField;
    private JTextField jabatanTextField;
    private JTextField statusTextField;

    private JButton buttonSimpan;
    private JButton buttonUbah;
    private JButton buttonHapus;

    // constructor PetugasFrame untuk membuat frame Petugas
    public PetugasFrame(PetugasDao petugasDao) {
        // deklarasi variabel untuk membuat frame Petugas
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        this.petugasDao = petugasDao;
        this.petugasList = petugasDao.findAll();
        
        // membuat label judul
        titleLabel = new JLabel("Form Data Petugas");
        titleLabel.setBounds(250, 10, 300, 20);
        titleLabel.setFont(new java.awt.Font("Arial", 1, 16));

        // JLabel untuk membuat label Nama
        namaLabel = new JLabel("Nama");
        namaLabel.setBounds(15, 50, 150, 20);
        
        // JTextField untuk membuat text field Nama
        namaTextField = new JTextField();
        namaTextField.setBounds(150, 50, 350, 35);
        
        // JLabel untuk membuat label Alamat
        alamatLabel = new JLabel("Alamat");
        alamatLabel.setBounds(15, 100, 150, 20);

        // JTextArea untuk membuat text area Alamat
        alamatTextArea = new JTextArea();
        alamatTextArea.setBounds(150, 100, 350, 35);
        
        // JLabel untuk membuat label Nomor Telepon
        noTelpLabel = new JLabel("Nomor Telepon");
        noTelpLabel.setBounds(15, 150, 150, 20);

        // JTextField untuk membuat text field Nomor Telepon
        noTelpTextField = new JTextField();
        noTelpTextField.setBounds(150, 150, 350, 35);

        // JLabel untuk membuat label Jabatan
        jabatanLabel = new JLabel("Jabatan");
        jabatanLabel.setBounds(15, 200, 150, 20);

        // JTextField untuk membuat text field Jabatan
        jabatanTextField = new JTextField();
        jabatanTextField.setBounds(150, 200, 350, 35);

        // JLabel untuk membuat label Status Pendaftaran
        statusLabel = new JLabel("Status Pendaftaran");
        statusLabel.setBounds(15, 250, 150, 20);

        // JTextField untuk membuat text field Status Pendaftaran
        statusTextField = new JTextField();
        statusTextField.setBounds(150, 250, 350, 35);

        // JButton untuk membuat tombol Simpan
        buttonSimpan = new JButton("Simpan");
        buttonSimpan.setBounds(15, 300, 100, 35);

        // JButton untuk membuat tombol Ubah
        buttonUbah = new JButton("Ubah");
        buttonUbah.setBounds(120, 300, 100, 35);

        // JButton untuk membuat tombol Hapus
        buttonHapus = new JButton("Hapus");
        buttonHapus.setBounds(225, 300, 100, 35);
        
        // Action Listener untuk membuat tombol Simpan
        PetugasButtonSimpan simpanActionListener = new PetugasButtonSimpan(this, petugasDao);
        buttonSimpan.addActionListener(simpanActionListener);

        // Action Listener untuk membuat tombol Ubah
        PetugasButtonUbah ubahActionListener = new PetugasButtonUbah(this, petugasDao);
        buttonUbah.addActionListener(ubahActionListener);

        // Action Listener untuk membuat tombol Hapus
        PetugasButtonHapus hapusActionListener = new PetugasButtonHapus(this, petugasDao);
        buttonHapus.addActionListener(hapusActionListener);

        // JTable untuk membuat tabel Petugas
        petugasTable = new JTable();

        // JScrollPane untuk membuat scrollable tabel Masyarakat
        scrollableTable = new JScrollPane(petugasTable);
        // mengatur posisi scrollable tabel Masyarakat
        scrollableTable.setBounds(15, 350, 750, 300);

        // MasyarakatTableModel untuk membuat tabel model Masyarakat
        petugasTableModel = new PetugasTableModel(this.petugasList);
        // mengatur tabel model Masyarakat
        petugasTable.setModel(petugasTableModel);

        // mengatur semua komponen yang ada di frame Masyarakat
        this.add(titleLabel);
        this.add(namaLabel);
        this.add(namaTextField);
        this.add(alamatLabel);
        this.add(alamatTextArea);
        this.add(noTelpLabel);
        this.add(noTelpTextField);
        this.add(jabatanLabel);
        this.add(jabatanTextField);
        this.add(statusLabel);
        this.add(statusTextField);
        this.add(buttonSimpan);
        this.add(buttonUbah);
        this.add(buttonHapus);
        this.add(scrollableTable);
        
        // mengatur ukuran frame
        this.setSize(800, 700);
        this.setLayout(null);
    }

    /* 
        *  Kumpulan Getter
        *  Untuk mengambil nilai dari setiap variabel
        * 
     */

    // method getNama untuk mengambil nilai dari text field Nama
    public String getNama() {
        return namaTextField.getText();
    }

    // method getAlamat untuk mengambil nilai dari text area Alamat
    public String getAlamat() {
        return alamatTextArea.getText();
    }

    // method getNoTelp untuk mengambil nilai dari text field Nomor Telepon
    public String getNoTelp() {
        return noTelpTextField.getText();
    }

    // method getJabatan untuk mengambil nilai dari text field Jabatan
    public String getJabatan() {
        return jabatanTextField.getText();
    }

    // method getStatus untuk mengambil nilai dari text field Status Pendaftaran
    public String getStatus() {
        return statusTextField.getText();
    }

    // method JTable untuk mengambil tabel Petugas
    public JTable getPetugasTable() {
        return this.petugasTable;
    }

    // method PetugasTableModel untuk mengambil tabel model Petugas
    public PetugasTableModel getPetugasTableModel() {
        return this.petugasTableModel;
    }

    // Method untuk menampilkan pesan alert
    public void showAlertMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    // Method untuk menampilkan pesan sukses
    public void showSuccessMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    // Method clearForm untuk menghapus data yang ada di dalam form
    public void clearForm() {
        namaTextField.setText("");
        alamatTextArea.setText("");
        noTelpTextField.setText("");
        jabatanTextField.setText("");
        statusTextField.setText("");
    } 

    // method addPetugas untuk menambahkan petugas ke dalam tabel
    public void addPetugas(Petugas petugas) {
        petugasTableModel.add(petugas);
    }

    // method deletePetugas untuk menghapus petugas dari tabel
    public void deletePetugas() {
        petugasTableModel.delete(petugasTable.getSelectedRow());
    }
    
    // method updatePetugas untuk mengubah data petugas di tabel
    public void updatePetugas(Petugas petugas) {
        petugasTableModel.update(petugas, petugasTable.getSelectedRow());
    }
}