/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smarttrash.frame;

/**
 *
 * @author salma
 */

// import library yang dibutuhkan untuk membuat frame Kategori  
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

import com.smarttrash.actionlistener.kategori.*;
import com.smarttrash.dao.KategoriDao;
import com.smarttrash.model.Kategori;
import com.smarttrash.table.KategoriTableModel;

public class KategoriFrame extends JFrame {
    // deklarasi variabel yang dibutuhkan untuk membuat frame Kategori
    private List<Kategori> kategoriList;
    private KategoriDao kategoriDao;
    private KategoriTableModel kategoriTableModel;
    private JTable kategoriTable;
    private JScrollPane scrollableTable;

    private JLabel titleLabel;
    private JLabel namaLabel;

    private JTextField namaTextField;

    private JButton buttonSimpan;
    private JButton buttonUbah;
    private JButton buttonHapus;

    // constructor KategoriFrame untuk membuat frame Kategori
    public KategoriFrame(KategoriDao kategoriDao) {
        this.kategoriDao = kategoriDao;
        this.kategoriList = kategoriDao.findAll();

        // membuat label judul
        titleLabel = new JLabel("Form Data Kategori Sampah Elektronik");
        titleLabel.setBounds(100, 10, 300, 20);
        titleLabel.setFont(new java.awt.Font("Arial", 1, 16));

        // membuat label nama
        namaLabel = new JLabel("Nama");
        namaLabel.setBounds(50, 50, 100, 20);

        // membuat text field nama
        namaTextField = new JTextField();
        namaTextField.setBounds(150, 50, 315, 35);

        // membuat button simpan
        buttonSimpan = new JButton("Simpan");
        buttonSimpan.setBounds(15, 100, 100, 35);
        
        // menambahkan action listener untuk button simpan
        KategoriButtonSimpan simpanActionListener = new KategoriButtonSimpan(this, kategoriDao);
        buttonSimpan.addActionListener(simpanActionListener);

        // membuat button ubah
        buttonUbah = new JButton("Ubah");
        buttonUbah.setBounds(120, 100, 100, 35);

        // menambahkan action listener untuk button ubah
        KategoriButtonUbah ubahActionListener = new KategoriButtonUbah(this, kategoriDao);
        buttonUbah.addActionListener(ubahActionListener);

        // membuat button hapus
        buttonHapus = new JButton("Hapus");
        buttonHapus.setBounds(225, 100, 100, 35);
        
        // menambahkan action listener untuk button hapus
        KategoriButtonHapus hapusActionListener = new KategoriButtonHapus(this, kategoriDao);
        buttonHapus.addActionListener(hapusActionListener);

        // JTable untuk membuat tabel kategori
        kategoriTable = new JTable();

        // JScrollPane untuk membuat scrollable table
        scrollableTable = new JScrollPane(kategoriTable);
        scrollableTable.setBounds(15, 150, 400, 200);

        // membuat table model untuk kategori
        kategoriTableModel = new KategoriTableModel(kategoriList);
        kategoriTable.setModel(kategoriTableModel);

        // menambahkan komponen ke frame
        this.add(titleLabel);
        this.add(namaLabel);
        this.add(namaTextField);
        this.add(buttonSimpan);
        this.add(buttonUbah);
        this.add(buttonHapus);
        this.add(scrollableTable);

        // mengatur ukuran frame
        this.setSize(500, 500);
        // mengatur layout frame
        this.setLayout(null);
    }

    // getter untuk mendapatkan nama
    public String getNama() {
        return this.namaTextField.getText();
    }
    
    // JTable untuk membuat tabel kategori
    public JTable getKategoriTable() {
        return this.kategoriTable;
    }

    // TableModel untuk membuat tabel model kategori
    public KategoriTableModel getKategoriTableModel() {
        return this.kategoriTableModel;
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
    } 

    // method untuk menambahkan kategori
    public void addKategori(Kategori kategori) {
        kategoriTableModel.add(kategori);
    }

    // method untuk mengubah kategori
    public void updateKategori(Kategori kategori, int row) {
        kategoriTableModel.update(kategori, row);
    }
    
    // method untuk menghapus kategori
    public void deleteKategori() {
        kategoriTableModel.delete(kategoriTable.getSelectedRow());
    }
}