/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smarttrash.frame;

/**
 *
 * @author Deni P
 */

// import library yang dibutuhkan untuk membuat frame Jenis
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

//import com.smarttrash.button.jenis.*;
import com.smarttrash.dao.JenisDao;
import com.smarttrash.dao.KategoriDao;
import com.smarttrash.model.Jenis;
import com.smarttrash.model.Kategori;
import com.smarttrash.table.JenisTableModel;

// class JenisFrame untuk membuat frame Jenis
public class JenisFrame extends JFrame {
    // deklarasi variabel yang dibutuhkan untuk membuat frame Jenis
    private List<Jenis> jenisList;
    private List<Kategori> kategoriList;
    private JenisDao jenisDao;
    private KategoriDao kategoriDao;
    private JenisTableModel jenisTableModel;
    private JTable jenisTable;
    private JScrollPane scrollableTable;

    private JLabel titleLabel;
    private JLabel namaLabel;
    private JLabel kategoriLabel;

    private JTextField namaTextField;
    private JComboBox kategoriComboBox;

    private JButton buttonSimpan;
    private JButton buttonUbah;
    private JButton buttonHapus;

    // constructor JenisFrame untuk membuat frame Jenis
    public JenisFrame(JenisDao jenisDao, KategoriDao kategoriDao) {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // deklarasi variabel untuk membuat frame Jenis
        this.jenisDao = jenisDao;
        this.kategoriDao = kategoriDao;

        this.jenisList = jenisDao.findAll();
        this.kategoriList = kategoriDao.findAll();

        // membuat label judul
        titleLabel = new JLabel("Form Data Jenis Sampah Elektronik");
        titleLabel.setBounds(100, 10, 300, 20);
        titleLabel.setFont(new java.awt.Font("Arial", 1, 16));

        // membuat label nama
        namaLabel = new JLabel("Nama");
        namaLabel.setBounds(50, 50, 100, 20);

        // membuat text field nama
        namaTextField = new JTextField();
        namaTextField.setBounds(150, 50, 315, 35);

        // membuat label kategori
        kategoriLabel = new JLabel("Kategori");
        kategoriLabel.setBounds(50, 100, 100, 20);

        // membuat combo box kategori
        kategoriComboBox = new JComboBox();
        kategoriComboBox.setBounds(150, 100, 315, 35);

        // membuat button simpan
        buttonSimpan = new JButton("Simpan");
        buttonSimpan.setBounds(15, 150, 100, 35);

        // membuat button ubah
        buttonUbah = new JButton("Ubah");
        buttonUbah.setBounds(120, 150, 100, 35);

        // membuat button hapus
        buttonHapus = new JButton("Hapus");
        buttonHapus.setBounds(225, 150, 100, 35);

        // JTable untuk membuat tabel jenis
        jenisTable = new JTable();
        
        // JScrollPane untuk membuat scrollable table
        scrollableTable = new JScrollPane(jenisTable);

        // menambahkan scrollable table ke dalam frame
        scrollableTable.setBounds(15, 200, 400, 200);

        // membuat table model untuk jenis
        jenisTableModel = new JenisTableModel(jenisList);
        jenisTable.setModel(jenisTableModel);
        
        this.add(titleLabel);
        this.add(namaLabel);
        this.add(namaTextField);
        this.add(kategoriLabel);
        this.add(kategoriComboBox);
        this.add(buttonSimpan);
        this.add(buttonUbah);
        this.add(buttonHapus);
        this.add(scrollableTable);

        this.setSize(500, 500);
        this.setLayout(null);
    }

    // method combo box untuk mengisi combo box kategori
    public void populateComboKategori() {
        this.kategoriList = kategoriDao.findAll();
        kategoriComboBox.removeAllItems();
        for(Kategori kategori : kategoriList) {
            kategoriComboBox.addItem(kategori.getNamaKategori());
        }
    }

    // getter untuk mendapatkan nama
    public String getNama() {
        return this.namaTextField.getText();
    }

    // getter untuk mendapatkan kategori
    public Kategori getKategori() {
        return this.kategoriList.get(kategoriComboBox.getSelectedIndex());
    }

    // JTable untuk mendapatkan jenis
    public JTable getJenisTable() {
        return this.jenisTable;
    }

    // TableModel untuk mendapatkan jenis
    public JenisTableModel getJenisTableModel() {
        return jenisTableModel;
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
        kategoriComboBox.setSelectedIndex(0);
    } 
    
    // method untuk menambahkan jenis
    public void addJenis(Jenis jenis) {
        jenisTableModel.add(jenis);
    }
    
    // method untuk menghapus jenis
    public void deleteJenis() {
        jenisTableModel.delete(jenisTable.getSelectedRow());
    }
}