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
    private List<Penjemputan> list;

    // Konstruktor dari class PenjemputanTableModel
    public PenjemputanTableModel(List<Penjemputan> list) {
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
        Penjemputan penjemputan = list.get(row);

        switch (col) {
            case 0:
                return penjemputan.getTanggalPenjemputan();
            case 1:
                return penjemputan.getStatusPenjemputan();
            case 2:
                return penjemputan.getKeputusanKonfirmasi();
            case 3:
                return penjemputan.getTanggalKonfirmasi();
            case 4:
                return penjemputan.getTanggalRiwayat();
            case 5:
                return (penjemputan.getMasyarakat() != null) ? penjemputan.getMasyarakat().getNama() : "";
            case 6:
                return (penjemputan.getPetugas() != null) ? penjemputan.getPetugas().getNama() : "";
            default:
                return "";
        }
    }
    
    // Method isCellEditable untuk mengembalikan boolean apakah cell dapat diubah atau tidak
    public boolean isCellEditable(int row, int col) {
        return false;
    }

    // Method getPenjemputanAt untuk mengembalikan objek Penjemputan yang ada di dalam tabel
    public Penjemputan getPenjemputanAt(int row) {
        return list.get(row);
    }

    // Method add untuk menambahkan data ke dalam tabel
    public void add(Penjemputan penjemputan) {
        list.add(penjemputan);
        fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
    }

    // method update untuk mengubah data yang ada di dalam tabel
    public void update(Penjemputan penjemputan, int row) {
        list.set(row, penjemputan);
        fireTableRowsUpdated(row, row);
    }

    // Method delete untuk menghapus data dari tabel
    public void delete(int row) {
        list.remove(row);
        fireTableRowsDeleted(row, row);
    }
}