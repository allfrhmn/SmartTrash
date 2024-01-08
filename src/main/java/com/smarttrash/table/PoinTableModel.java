/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smarttrash.table;

/**
 *
 * @author allfiandi
 */

// import library yang dibutuhkan untuk membuat tabel
import javax.swing.table.*;
import java.util.List;
import com.smarttrash.model.Poin;

// Membuat class PoinTableModel yang berfungsi untuk mengatur tabel yang ada di dalam database
public class PoinTableModel extends AbstractTableModel {
    // Array yang berisi beberapa kolom
    private String[] columnNames = {"Jumlah Poin", "Nama Kategori"};

    // List yang berisi data yang akan dimasukkan ke dalam tabel
    private List<Poin> data;

    // Konstruktor dari class PoinTableModel
    public PoinTableModel(List<Poin> data) {
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
        Poin poin = data.get(row);
        // String value = "";
        // int valueInt = 0;

        switch (col) {
            case 0:
                return poin.getJumlahPoin();
            case 1:
                return (poin.getKategori() != null) ? poin.getKategori().getNamaKategori() : "";
            default:
                return "";
            
        }
    }

    // Method isCellEditable untuk mengembalikan boolean apakah cell dapat diubah atau tidak
    public boolean isCellEditable(int row, int col) {
        return false;
    }

    // Method untuk mendapatkan objek yang ada di dalam tabel
    public Poin getPoin(int row) {
        return data.get(row);
    }

    // Method add untuk menambahkan data ke dalam tabel
    public void add(Poin poin) {
        data.add(poin);
        fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
    }

    // Method update untuk mengubah data yang ada di dalam tabel
    public void update(Poin poin, int row) {
        data.set(row, poin);
        fireTableRowsUpdated(row, row);
    }
    
    // Method delete untuk menghapus data dari tabel
    public void delete(int row) {
        data.remove(row);
        fireTableRowsDeleted(row, row);
    }
}