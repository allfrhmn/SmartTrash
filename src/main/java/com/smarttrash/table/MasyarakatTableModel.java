/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

// package tabel ini berisi class-class yang digunakan untuk mengatur tabel yang ada di dalam database
package com.smarttrash.table;

/**
 *
 * @author Emilia Paradila S
 */

// import library yang dibutuhkan untuk membuat tabel   
import com.smarttrash.model.Masyarakat;
import javax.swing.table.*;
import java.util.List;

// Membuat class MasyarakatTableModel yang berfungsi untuk mengatur tabel yang ada di dalam database
public class MasyarakatTableModel extends AbstractTableModel {
    // Array yang berisi beberapa kolom
    private String[] columnNames = {"Nama", "Alamat", "Nomor Telepon", "Email", "Status Pendaftaran"};
    
    // List yang berisi data yang akan dimasukkan ke dalam tabel
    private List<Masyarakat> list;

    // Konstruktor dari class MasyarakatTableModel
    public MasyarakatTableModel(List<Masyarakat> list) {
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
        Masyarakat masyarakat = list.get(row);
        switch (col) {
            case 0:
                return masyarakat.getNama();
            case 1:
                return masyarakat.getAlamat();
            case 2:
                return masyarakat.getNoTelp();
            case 3:
                return masyarakat.getEmail();
            case 4:
                return masyarakat.getStatusPendaftaran();
            default:
                return "";
        }
    }

    // Mrthod isCellEditable untuk mengembalikan nilai boolean apakah cell dapat diubah atau tidak
    public boolean isCellEditable(int row, int col) {
        return false;
    }
    
    // method untuk mendapatkan objek Masyarakat dari baris tertentu
    public Masyarakat getMasyarakatAt(int row) {
        return list.get(row);
    }

    // Method add untuk menambahkan data ke dalam tabel
    public void add(Masyarakat masyarakat) {
        list.add(masyarakat);
        fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
    }
    
    // Method update untuk mengubah data ke dalam tabel
    public void update(Masyarakat masyarakat, int row) {
        list.set(row, masyarakat);
        fireTableRowsUpdated(row, row); 
    }

    // Method delete untuk menghapus data dari tabel
    public void delete(int row) {
        list.remove(row);
        fireTableRowsDeleted(row, row);
    }
}