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
    private List<Petugas> data;

    // Konstruktor dari class PetugasTableModel
    public PetugasTableModel(List<Petugas> data) {
        this.data = data;
    }

    // Method getColumnCount untuk mengembalikan jumlah kolom yang ada di dalam tabel
    public int getColumnCount() {
        return columnNames.length;
    }

    // Method getRowCount untuk mengembalikan jumlah baris yang ada di dalam tabel
    public int getRowCount() {
        return data.size();
    }

    // Method getColumnName untuk mengembalikan nama kolom yang ada di dalam tabel
    public String getColumnName(int col) {
        return columnNames[col];
    }

    // Method getValueAt untuk mengembalikan nilai yang ada di dalam tabel
    public Object getValueAt(int row, int col) {
        Petugas rowItem = data.get(row);
        String value = "";

        switch (col) {
            case 0:
                value = rowItem.getNama();
                break;
            case 1:
                value = rowItem.getAlamat();
                break;
            case 2:
                value = rowItem.getNoTelp();
                break;
            case 3:
                value = rowItem.getJabatan();
                break;
            case 4:
                value = rowItem.getStatusPendaftaran();
                break;
        }
        return value;
    }

    // Method isCellEditable untuk mengembalikan nilai boolean apakah cell dapat diubah atau tidak
    public boolean isCellEditable(int row, int col) {
        return false;
    }

    // Method add untuk menambahkan data ke dalam tabel
    public void add(Petugas petugas) {
        data.add(petugas);
        fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
    }
}