/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// package table ini berisi class-class yang digunakan untuk mengatur tabel yang ada di dalam database
package com.smarttrash.table;

// import library yang dibutuhkan untuk membuat tabel
import javax.swing.table.*;
import java.util.List;
import com.smarttrash.model.Kategori;

// Membuat class KategoriTableModel yang berfungsi untuk mengatur tabel yang ada di dalam database
public class KategoriTableModel extends AbstractTableModel {
    // Array yang berisi beberapa kolom
    private String[] columnNames = {"Nama"};

    // List yang berisi data yang akan dimasukkan ke dalam tabel
    private List<Kategori> data;

    // Konstruktor dari class KategoriTableModel
    public KategoriTableModel(List<Kategori> data) {
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
        Kategori rowItem = data.get(row);
        String value = "";

        switch (col) {
            case 0:
                value = rowItem.getNamaKategori();
                break;
        }
        return value;
    }

    // Method isCellEditable untuk mengembalikan boolean apakah cell dapat diubah atau tidak
    public boolean isCellEditable(int row, int col) {
        return false;
    }

    // Method add untuk menambahkan data ke dalam tabel
    public void add(Kategori kategori) {
        data.add(kategori);
        fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
    }

    // Method delete untuk menghapus data dari tabel
    public void delete(int row) {
        data.remove(row);
        fireTableRowsDeleted(row, row);
    }
}