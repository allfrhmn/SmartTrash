/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smarttrash.frame;

/**
 *
 * @author allfiandi
 */

// import library yang dibutuhkan 
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

import com.smarttrash.dao.PenjemputanDao;
import com.smarttrash.dao.MasyarakatDao;
import com.smarttrash.dao.PetugasDao;
import com.smarttrash.model.Penjemputan;
import com.smarttrash.model.Masyarakat;
import com.smarttrash.model.Petugas;
import com.smarttrash.table.PenjemputanTableModel;

// class PenjemputanFrame untuk membuat frame Penjemputan
public class PenjemputanFrame extends JFrame {
    // deklarasi variabel yang dibutuhkan untuk membuat frame Penjemputan
    private List<Penjemputan> penjemputanList;
    private List<Masyarakat> masyarakatList;
    private List<Petugas> petugasList;
    private PenjemputanDao penjemputanDao;
    private MasyarakatDao masyarakatDao;
    private PetugasDao petugasDao;
    private PenjemputanTableModel penjemputanTableModel;
    private JTable penjemputanTable;
    private JScrollPane scrollableTable;

    private JLabel titleLabel;
    private JLabel tanggalPenjemputanLabel;
    private JLabel statusPenjemputanLabel;
    private JLabel keputusanKonfirmasiLabel;
    private JLabel tanggalKonfirmasiLabel;
    private JLabel tanggalRiwayatLabel;
    private JLabel masyarakatLabel;
    private JLabel petugasLabel;
    
    private JTextField tanggalPenjemputanTextField;
    private JTextField statusPenjemputanTextField;
    private JTextField keputusanKonfirmasiTextField;
    private JTextField tanggalKonfirmasiTextField;
    private JTextField tanggalRiwayatTextField;
    private JComboBox masyarakatComboBox;
    private JComboBox petugasComboBox;

    private JButton buttonSimpan;
    private JButton buttonUbah;
    private JButton buttonHapus;
    private JButton buttonPrint;
    private JButton buttonPreview;
    private JButton buttonExport;

    // constructor PenjemputanFrame untuk membuat frame Penjemputan
    public PenjemputanFrame(PenjemputanDao penjemputanDao, MasyarakatDao masyarakatDao, PetugasDao petugasDao) {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // deklarasi variabel untuk membuat frame Penjemputan
        this.penjemputanDao = penjemputanDao;
        this.masyarakatDao = masyarakatDao;
        this.petugasDao = petugasDao;

        this.penjemputanList = penjemputanDao.findAll();
        this.masyarakatList = masyarakatDao.findAll();
        this.petugasList = petugasDao.findAll();

        // membuat label judul
        titleLabel = new JLabel("Data Penjemputan Sampah Elektronik");
        titleLabel.setBounds(350, 10, 300, 20);
        titleLabel.setFont(new java.awt.Font("Arial", 1, 16));

        // membuat label tanggal penjemputan
        tanggalPenjemputanLabel = new JLabel("Tanggal Penjemputan");
        tanggalPenjemputanLabel.setBounds(50, 50, 150, 20);

        // membuat text field tanggal penjemputan
        tanggalPenjemputanTextField = new JTextField();
        tanggalPenjemputanTextField.setBounds(200, 50, 350, 35);

        // membuat label status penjemputan
        statusPenjemputanLabel = new JLabel("Status Penjemputan");
        statusPenjemputanLabel.setBounds(50, 100, 150, 20);

        // membuat text field status penjemputan
        statusPenjemputanTextField = new JTextField();
        statusPenjemputanTextField.setBounds(200, 100, 350, 35);

        // membuat label keputusan konfirmasi
        keputusanKonfirmasiLabel = new JLabel("Keputusan Konfirmasi");
        keputusanKonfirmasiLabel.setBounds(50, 150, 150, 20);

        // membuat text field keputusan konfirmasi
        keputusanKonfirmasiTextField = new JTextField();
        keputusanKonfirmasiTextField.setBounds(200, 150, 350, 35);

        // membuat label tanggal konfirmasi
        tanggalKonfirmasiLabel = new JLabel("Tanggal Konfirmasi");
        tanggalKonfirmasiLabel.setBounds(50, 200, 150, 20);

        // membuat text field tanggal konfirmasi
        tanggalKonfirmasiTextField = new JTextField();
        tanggalKonfirmasiTextField.setBounds(200, 200, 350, 35);

        // membuat label tanggal riwayat
        tanggalRiwayatLabel = new JLabel("Tanggal Riwayat");
        tanggalRiwayatLabel.setBounds(50, 250, 150, 20);

        // membuat text field tanggal riwayat
        tanggalRiwayatTextField = new JTextField();
        tanggalRiwayatTextField.setBounds(200, 250, 350, 35);

        // membuat label masyarakat
        masyarakatLabel = new JLabel("Masyarakat");
        masyarakatLabel.setBounds(50, 300, 150, 20);

        // membuat label masyarakat
        masyarakatComboBox = new JComboBox();
        masyarakatComboBox.setBounds(200, 300, 350, 35);

        // membuat label petugas
        petugasLabel = new JLabel("Petugas");
        petugasLabel.setBounds(50, 350, 150, 20);

        // membuat label petugas
        petugasComboBox = new JComboBox();
        petugasComboBox.setBounds(200, 350, 350, 35);

        // membuat button simpan
        buttonSimpan = new JButton("Simpan");
        buttonSimpan.setBounds(15, 400, 100, 35);

        // membuat button ubah
        buttonUbah = new JButton("Ubah");
        buttonUbah.setBounds(120, 400, 100, 35);

        // membuat button hapus
        buttonHapus = new JButton("Hapus");
        buttonHapus.setBounds(225, 400, 100, 35);

        // membuat button print
        buttonPrint = new JButton("Print");
        buttonPrint.setBounds(330, 400, 100, 35);

        // membuat button preview
        buttonPreview = new JButton("Preview");
        buttonPreview.setBounds(435, 400, 100, 35);

        // membuat button export
        buttonExport = new JButton("Export");
        buttonExport.setBounds(540, 400, 100, 35);

        // menambahkan action listener untuk button simpan
        // PenjemputanButtonSimpanActionListener simpanActionListener = new PenjemputanButtonSimpanActionListener(this, penjemputanDao);
        // buttonSimpan.addActionListener(simpanActionListener);

        // JTable untuk membuat tabel penjemputan
        penjemputanTable = new JTable();

        // JScrollPane untuk membuat scrollable table
        scrollableTable = new JScrollPane(penjemputanTable);

        // menambahkan scrollable table ke dalam frame
        scrollableTable.setBounds(15, 450, 1000, 300);

        // membuat table model untuk penjemputan
        penjemputanTableModel = new PenjemputanTableModel(penjemputanList);
        penjemputanTable.setModel(penjemputanTableModel);

        // menambahkan komponen ke frame
        this.add(titleLabel);
        this.add(tanggalPenjemputanLabel);
        this.add(tanggalPenjemputanTextField);
        this.add(statusPenjemputanLabel);
        this.add(statusPenjemputanTextField);
        this.add(keputusanKonfirmasiLabel);
        this.add(keputusanKonfirmasiTextField);
        this.add(tanggalKonfirmasiLabel);
        this.add(tanggalKonfirmasiTextField);
        this.add(tanggalRiwayatLabel);
        this.add(tanggalRiwayatTextField);
        this.add(masyarakatLabel);
        this.add(petugasLabel);
        this.add(masyarakatComboBox);
        this.add(petugasComboBox);
        this.add(buttonSimpan);
        this.add(buttonUbah);
        this.add(buttonHapus);
        this.add(buttonPrint);
        this.add(buttonPreview);
        this.add(buttonExport);
        this.add(scrollableTable);

        // mengatur ukuran frame
        this.setSize(1100, 750);
        // mengatur layout frame
        this.setLayout(null);
    }

    // method combo box untuk mengisi combo box masyarakat
    public void populateComboMasyarakat() {
        this.masyarakatList = masyarakatDao.findAll();
        masyarakatComboBox.removeAllItems();

        for (Masyarakat masyarakat : masyarakatList) {
            masyarakatComboBox.addItem(masyarakat.getNama());
        }
    }

    // method combo box untuk mengisi combo box petugas
    public void populateComboPetugas() {
        this.petugasList = petugasDao.findAll();
        petugasComboBox.removeAllItems();

        for (Petugas petugas : petugasList) {
            petugasComboBox.addItem(petugas.getNama());
        }
    }

    // getter untuk mendapatkan tanggal penjemputan
    public String getTanggalPenjemputan() {
        return this.tanggalPenjemputanTextField.getText();
    }

    // getter untuk mendapatkan status penjemputan
    public String getStatusPenjemputan() {
        return this.statusPenjemputanTextField.getText();
    }

    // getter untuk mendapatkan keputusan konfirmasi
    public String getKeputusanKonfirmasi() {
        return this.keputusanKonfirmasiTextField.getText();
    }

    // getter untuk mendapatkan tanggal konfirmasi
    public String getTanggalKonfirmasi() {
        return this.tanggalKonfirmasiTextField.getText();
    }

    // getter untuk mendapatkan tanggal riwayat
    public String getTanggalRiwayat() {
        return this.tanggalRiwayatTextField.getText();
    }

    // getter untuk mendapatkan masyarakat
    public Masyarakat getMasyarakat() {
        return this.masyarakatList.get(this.masyarakatComboBox.getSelectedIndex());
    }
    
    // getter untuk mendapatkan petugas
    public Petugas getPetugas() {
        return this.petugasList.get(this.petugasComboBox.getSelectedIndex());
    }
    
    // JTable untuk membuat tabel penjemputan
    public JTable getPenjemputanTable() {
        return this.penjemputanTable;
    }

    // TableModel untuk membuat table model penjemputan
    public PenjemputanTableModel getPenjemputanTableModel() {
        return this.penjemputanTableModel;
    }
    
    // Method untuk menampilkan pesan alert
    public void showAlertMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    // Method untuk menampilkan pesan sukses
    public void showSuccessMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }
    
    // method untuk mengosongkan text field
    public void clearTextField() {
        this.tanggalPenjemputanTextField.setText("");
        this.statusPenjemputanTextField.setText("");
        this.keputusanKonfirmasiTextField.setText("");
        this.tanggalKonfirmasiTextField.setText("");
        this.tanggalRiwayatTextField.setText("");
        this.masyarakatComboBox.setSelectedIndex(0);
        this.petugasComboBox.setSelectedIndex(0);
    }

    // method addPenjemputan untuk menambahkan petugas ke dalam tabel
    public void addPenjemputan(Penjemputan penjemputan) {
        penjemputanTableModel.add(penjemputan);
    }

    // method deletePenjemputan untuk menghapus petugas dari tabel
    public void deletePenjemputan() {
        penjemputanTableModel.delete(penjemputanTable.getSelectedRow());
    }
}