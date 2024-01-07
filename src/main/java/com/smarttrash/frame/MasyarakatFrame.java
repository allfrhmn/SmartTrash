package com.smarttrash.frame;

/**
 *
 * @author Emilia Paradila S
 */

// import library yang dibutuhkan untuk membuat frame Masyarakat
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

import com.smarttrash.dao.MasyarakatDao;
import com.smarttrash.model.Masyarakat;
import com.smarttrash.table.MasyarakatTableModel;
import com.smarttrash.actionlistener.masyarakat.*;

// class MasyarakatFrame untuk membuat frame Masyarakat
public class MasyarakatFrame extends JFrame {
    // deklarasi variabel yang dibutuhkan untuk membuat frame Masyarakat
    private List<Masyarakat> masyarakatList;
    private MasyarakatDao masyarakatDao;
    private MasyarakatTableModel masyarakatTableModel;
    private JTable masyarakatTable;
    private JScrollPane scrollableTable;

    private JLabel titleLabel;
    
    private JLabel namaLabel;
    private JLabel alamatLabel;
    private JLabel noTelpLabel;
    private JLabel emailLabel;
    private JLabel statusLabel;

    private JTextField namaTextField;
    private JTextArea alamatTextArea;
    private JTextField noTelpTextField;
    private JTextField emailTextField;
    private JTextField statusTextField;

    private JButton buttonSimpan;
    private JButton buttonUbah;
    private JButton buttonHapus;
    private JButton buttonPrint;
    private JButton buttonPreview;
    private JButton buttonExport;

    // constructor MasyarakatFrame untuk membuat frame Masyarakat
    public MasyarakatFrame(MasyarakatDao masyarakatDao) {
        // deklarasi variabel untuk membuat frame Masyarakat
        this.masyarakatDao = masyarakatDao;
        this.masyarakatList = masyarakatDao.findAll();
        
        // membuat label judul
        titleLabel = new JLabel("Form Data Masyarakat");
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

        // JLabel untuk membuat label Email
        emailLabel = new JLabel("Email");
        emailLabel.setBounds(15, 200, 150, 20);

        // JTextField untuk membuat text field Email
        emailTextField = new JTextField();
        emailTextField.setBounds(150, 200, 350, 35);

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
        
        // JButton untuk membuat tombol Print
        buttonPrint = new JButton("Print");
        buttonPrint.setBounds(330, 300, 100, 35);

        // JButton untuk membuat tombol Preview
        buttonPreview = new JButton("Preview");
        buttonPreview.setBounds(435, 300, 100, 35);

        // JButton untuk membuat tombol Export
        buttonExport = new JButton("Export");
        buttonExport.setBounds(540, 300, 100, 35);
        
        // Action Listener untuk membuat tombol Hapus
        MasyarakatButtonHapus hapusActionListener = new MasyarakatButtonHapus(this, masyarakatDao);
        buttonHapus.addActionListener(hapusActionListener);

        // Action Listener untuk membuat tombol Simpan
        MasyarakatButtonSimpan simpanActionListener = new MasyarakatButtonSimpan(this, masyarakatDao);
        buttonSimpan.addActionListener(simpanActionListener);
        
        // Action Listener untuk membuat tombol Ubah
        MasyarakatButtonUbah ubahActionListener = new MasyarakatButtonUbah(this, masyarakatDao);
        buttonUbah.addActionListener(ubahActionListener);

        // JTable untuk membuat tabel Masyarakat
        masyarakatTable = new JTable();

        // JScrollPane untuk membuat scrollable tabel Masyarakat
        scrollableTable = new JScrollPane(masyarakatTable);
        // mengatur posisi scrollable tabel Masyarakat
        scrollableTable.setBounds(15, 350, 750, 300);

        // MasyarakatTableModel untuk membuat tabel model Masyarakat
        masyarakatTableModel = new MasyarakatTableModel(this.masyarakatList);
        // mengatur tabel model Masyarakat
        masyarakatTable.setModel(masyarakatTableModel);

        // mengatur semua komponen yang ada di frame Masyarakat
        this.add(titleLabel);
        this.add(namaLabel);
        this.add(namaTextField);
        this.add(alamatLabel);
        this.add(alamatTextArea);
        this.add(noTelpLabel);
        this.add(noTelpTextField);
        this.add(emailLabel);
        this.add(emailTextField);
        this.add(statusLabel);
        this.add(statusTextField);
        this.add(buttonSimpan);
        this.add(buttonUbah);
        this.add(buttonHapus);
        this.add(buttonPrint);
        this.add(buttonPreview);
        this.add(buttonExport);
        this.add(scrollableTable);
        
        // mengatur ukuran Swing
        this.setSize(800, 700);
        this.setLayout(null);
    }

    /* 
        * Kumpulan Getter
        * Untuk mengambil dan mengisi data ke dalam variabel
        * 
    */

    // getter untuk mengambil data nama
    public String getNama() {
        return this.namaTextField.getText();
    }

    // getter untuk mengambil data alamat
    public String getAlamat() {
        return this.alamatTextArea.getText();
    }

    // getter untuk mengambil data nomor telepon
    public String getNoTelp() {
        return this.noTelpTextField.getText();
    }

    // getter untuk mengambil data email
    public String getEmail() {
        return this.emailTextField.getText();
    }

    // getter untuk mengambil data status pendaftaran
    public String getStatus() {
        return this.statusTextField.getText();
    }
    
    // getter untuk mengambil tabel masyarakat
    public JTable getMasyarakatTable() {
        return this.masyarakatTable;
    }

    // getter untuk mengambil tabel model masyarakat
    public MasyarakatTableModel getMasyarakatTableModel() {
        return this.masyarakatTableModel;
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
        emailTextField.setText("");
        statusTextField.setText("");
    } 
    
    // method untuk menambah masyarakat ke dalam tabel
    public void addMasyarakat(Masyarakat masyarakat) {
        masyarakatTableModel.add(masyarakat);
    }
    
    // method untuk mengubah masyarakat ke dalam tabel
    public void updateMasyarakat(Masyarakat masyarakat) {
//        masyarakatTableModel.update(masyarakat, masyarakatTable.getSelectedRow());
    }
    // method untuk menghapus masyarakat dari tabel 
    public void deleteMasyarakat(Masyarakat masyarakat) {
        masyarakatTableModel.delete(masyarakatTable.getSelectedRow());
    }
}