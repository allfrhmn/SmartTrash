/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smarttrash.frame;

/**
 *
 * @author allfiandi
 */

// import library yang dibutuhkan untuk membuat frame Poin
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

import com.smarttrash.dao.PoinDao;
import com.smarttrash.dao.KategoriDao;
import com.smarttrash.model.Poin;
import com.smarttrash.model.Kategori;
import com.smarttrash.table.PoinTableModel;
import com.smarttrash.actionlistener.poin.*;

// class PoinFrame untuk membuat frame Poin
public class PoinFrame extends JFrame {
    // deklarasi variabel yang dibutuhkan untuk membuat frame Poin
    private List<Poin> poinList;
    private List<Kategori> kategoriList;
    private PoinDao poinDao;
    private KategoriDao kategoriDao;
    private PoinTableModel poinTableModel;
    private JTable poinTable;
    private JScrollPane scrollableTable;

    private JLabel titleLabel;
    private JLabel jumlahPoinLabel;
    private JLabel kategoriLabel;

    private JTextField jumlahPoinTextField;
    private JComboBox kategoriComboBox;
    
    private JButton buttonSimpan;
    private JButton buttonUbah;
    private JButton buttonHapus;

    // constructor PoinFrame untuk membuat frame Poin
    public PoinFrame(PoinDao poinDao, KategoriDao kategoriDao) {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // deklarasi variabel untuk membuat frame Poin
        this.poinDao = poinDao;
        this.kategoriDao = kategoriDao;

        this.poinList = poinDao.findAll();
        this.kategoriList = kategoriDao.findAll();

        // membuat label judul
        titleLabel = new JLabel("Form Data Poin");
        titleLabel.setBounds(100, 10, 300, 20);
        titleLabel.setFont(new java.awt.Font("Arial", 1, 16));

        // membuat label jumlah poin
        jumlahPoinLabel = new JLabel("Jumlah Poin");
        jumlahPoinLabel.setBounds(50, 50, 100, 20);

        // membuat text field jumlah poin
        jumlahPoinTextField = new JTextField();
        jumlahPoinTextField.setBounds(150, 50, 315, 35);

        // membuat label kategori
        kategoriLabel = new JLabel("Kategori");
        kategoriLabel.setBounds(50, 100, 100, 20);

        // membuat combo box kategori
        kategoriComboBox = new JComboBox();
        kategoriComboBox.setBounds(150, 100, 315, 35);

        populateComboKategori();

        // membuat button simpan
        buttonSimpan = new JButton("Simpan");
        buttonSimpan.setBounds(15, 150, 100, 35);

        // menambahkan action listener untuk button simpan
        PoinButtonSimpan simpanActionListener = new PoinButtonSimpan(this, poinDao);
        buttonSimpan.addActionListener(simpanActionListener);

        // membuat button ubah
        buttonUbah = new JButton("Ubah");
        buttonUbah.setBounds(120, 150, 100, 35);

        // menambahkan action listener untuk button ubah
        PoinButtonUbah ubahActionListener = new PoinButtonUbah(this, poinDao);
        buttonUbah.addActionListener(ubahActionListener);

        // membuat button hapus
        buttonHapus = new JButton("Hapus");
        buttonHapus.setBounds(225, 150, 100, 35);

        // menambahkan action listener untuk button hapus
        PoinButtonHapus hapusActionListener = new PoinButtonHapus(this, poinDao);
        buttonHapus.addActionListener(hapusActionListener);
        
        // membuat tabel poin
        poinTable = new JTable();

        // membuat table model poin
        poinTableModel = new PoinTableModel(poinList);
        poinTable.setModel(poinTableModel);

        // membuat scrollable table
        scrollableTable = new JScrollPane(poinTable);
        scrollableTable.setBounds(15, 200, 450, 200);

        // menambahkan semua komponen ke dalam frame
        this.add(titleLabel);
        this.add(jumlahPoinLabel);
        this.add(jumlahPoinTextField);
        this.add(kategoriLabel);
        this.add(kategoriComboBox);
        this.add(buttonSimpan);
        this.add(buttonUbah);
        this.add(buttonHapus);
        this.add(scrollableTable);

        // mengatur ukuran frame
        this.setSize(500, 500);
        // mengatur layout frame
        this.setLayout(null);
    }

    // method untuk mengisi combo box kategori
    public void populateComboKategori() {
        for (Kategori kategori : kategoriList) {
            kategoriComboBox.addItem(kategori.getNamaKategori());
        }
    }

    // method untuk mendapatkan jumlah poin
    public int getJumlahPoin() {
        return Integer.parseInt(this.jumlahPoinTextField.getText());
    }

    // getter untuk mendapatkan kategori
    public Kategori getKategori() {
        return this.kategoriList.get(kategoriComboBox.getSelectedIndex());
    }

    // JTable untuk membuat tabel poin
    public JTable getPoinTable() {
        return this.poinTable;
    }

    // TableModel untuk membuat table model poin
    public PoinTableModel getPoinTableModel() {
        return poinTableModel;
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
        this.jumlahPoinTextField.setText("");
        this.kategoriComboBox.setSelectedIndex(0);
    } 

    // method addPoin untuk menambahkan petugas ke dalam tabel
    public void addPoin(Poin poin) {
        poinTableModel.add(poin);
    }

    // method updatePoin untuk mengubah data petugas di dalam tabel
    public void updatePoin(Poin poin, int row) {
        poinTableModel.update(poin, row);
    }
    
    // method deletePoin untuk menghapus petugas dari tabel
    public void deletePoin() {
        poinTableModel.delete(poinTable.getSelectedRow());
    }
}