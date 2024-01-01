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
import com.smarttrash.model.Penjemputan;

// Membuat class PenjemputanTableModel yang berfungsi untuk mengatur tabel yang ada di dalam database
public class PenjemputanTableModel extends AbstractTableModel {
    // Array yang berisi beberapa kolom
    String[] columnNames = {"Tanggal Penjemputan", "Status Penjemputan", "Keputusan Konfirmasi", "Jadwal Konfirmasi", "Tanggal Riwayat", "Nama Masyarakat", "Nama Petugas"};

    // List yang berisi data yang akan dimasukkan ke dalam tabel
    private List<Penjemputan> data;

    // Konstruktor dari class PenjemputanTableModel
    public PenjemputanTableModel(List<Penjemputan> data) {
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
        Penjemputan rowItem = data.get(row);
        String value = "";

        switch (col) {
            case 0:
                value = rowItem.getTanggalPenjemputan();
                break;
            case 1:
                value = rowItem.getStatusPenjemputan();
                break;
            case 2:
                value = rowItem.getKeputusanKonfirmasi();
                break;
            case 3:
                value = rowItem.getTanggalKonfirmasi();
                break;
            case 4:
                value = rowItem.getTanggalRiwayat();
                break;
            case 5:
                value = rowItem.getMasyarakat().getNama();
                break;
            case 6:
                value = rowItem.getPetugas().getNama();
                break;
        }
        return value;
    }
    
    // Method isCellEditable untuk mengembalikan boolean apakah cell dapat diubah atau tidak
    public boolean isCellEditable(int row, int col) {
        return false;
    }

    // Method add untuk menambahkan data ke dalam tabel
    public void add(Penjemputan penjemputan) {
        data.add(penjemputan);
        fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
    }

    // Method delete untuk menghapus data dari tabel
    public void delete(int row) {
        data.remove(row);
        fireTableRowsDeleted(row, row);
    }
}