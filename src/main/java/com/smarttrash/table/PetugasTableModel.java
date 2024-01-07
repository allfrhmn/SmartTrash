/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

// package table ini berisi class-class yang digunakan untuk mengatur tabel yang ada di dalam database
package com.smarttrash.table;

/**
 *
 * @author imam
 */

// import library yang dibutuhkan untuk membuat tabel
import javax.swing.table.*;
import java.util.List;
import com.smarttrash.model.Petugas;

// Membuat class PetugasTableModel yang berfungsi untuk mengatur tabel yang ada di dalam database
public class PetugasTableModel extends AbstractTableModel {
    // Array yang berisi beberapa kolom
    private String[] columnNames = {"Nama", "Alamat", "Nomor Telepon", "Jabatan", "Status Pendaftaran"};

    // List yang berisi data yang akan dimasukkan ke dalam tabel
    private List<Petugas> list;

    // Konstruktor dari class PetugasTableModel
    public PetugasTableModel(List<Petugas> list) {
        this.list = list;
    }

    // Method getColumnCount untuk mengembalikan jumlah kolom yang ada di dalam tabel
    public int getColumnCount() {
        return columnNames.length;
    }

    // Method getRowCount untuk mengembalikan jumlah baris yang ada di dalam tabel
    public int getRowCount() {
        return list.size();
    }

    // Method getColumnName untuk mengembalikan nama kolom yang ada di dalam tabel
    public String getColumnName(int col) {
        return columnNames[col];
    }

    // Method getValueAt untuk mengembalikan nilai yang ada di dalam tabel
    public Object getValueAt(int row, int col) {
        Petugas petugas = list.get(row);

        switch (col) {
            case 0:
                return petugas.getNama();
            case 1:
                return petugas.getAlamat();
            case 2:
                return petugas.getNoTelp();
            case 3:
                return petugas.getJabatan();
            case 4:
                return petugas.getStatusPendaftaran();
            default:
                return "";
        }
    }

    // Method isCellEditable untuk mengembalikan nilai boolean apakah cell dapat diubah atau tidak
    public boolean isCellEditable(int row, int col) {
        return false;
    }
    
    // method untuk mendapatkan objek Petugas dari baris tertentu
    public Petugas getPetugasAt(int row) {
        return list.get(row);
    }

    // Method add untuk menambahkan data ke dalam tabel
    public void add(Petugas petugas) {
        list.add(petugas);
        fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
    }

    // Method delete untuk menghapus data dari tabel
    public void delete(int row) {
        list.remove(row);
        fireTableRowsDeleted(row, row);
    }
    
    // Method update untuk mengubah data yang ada di dalam tabel
    public void update(Petugas petugas, int row) {
        list.set(row, petugas);
        fireTableRowsUpdated(row, row);
    }
}