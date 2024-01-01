/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smarttrash.table;

/**
 *
 * @author Emilia Paradila S
 */


    // package tabel ini berisi class-class yang digunakan untuk mengatur tabel yang ada di dalam database


// import library yang dibutuhkan untuk membuat tabel   
import com.smarttrash.model.Masyarakat;
import javax.swing.table.*;
import java.util.List;

// Membuat class MasyarakatTableModel yang berfungsi untuk mengatur tabel yang ada di dalam database
public class MasyarakatTableModel extends AbstractTableModel {
    // Array yang berisi beberapa kolom
    private String[] columnNames = {"Nama", "Alamat", "Nomor Telepon", "Email", "Status Pendaftaran"};
    
    // List yang berisi data yang akan dimasukkan ke dalam tabel
    private List<Masyarakat> data;

    // Konstruktor dari class MasyarakatTableModel
    public MasyarakatTableModel(List<Masyarakat> data) {
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
        Masyarakat rowItem = data.get(row);
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
                value = rowItem.getEmail();
                break;
            case 4:
                value = rowItem.getStatusPendaftaran();
                break;
        }
        return value;
    }

    // Mrthod isCellEditable untuk mengembalikan nilai boolean apakah cell dapat diubah atau tidak
    public boolean isCellEditable(int row, int col) {
        return false;
    }

    // Method add untuk menambahkan data ke dalam tabel
    public void add(Masyarakat masyarakat) {
        data.add(masyarakat);
        fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
    }
}
 