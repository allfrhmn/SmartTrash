// package table ini berisi class-class yang digunakan untuk mengatur tabel yang ada di dalam database
package com.smarttrash.table;

// import library yang dibutuhkan untuk membuat tabel
import javax.swing.table.*;
import java.util.List;
import com.smarttrash.model.Jenis;

// Membuat class JenisTableModel yang berfungsi untuk mengatur tabel yang ada di dalam database
public class JenisTableModel extends AbstractTableModel {
    // Array yang berisi beberapa kolom
    private String[] columnNames = {"Nama", "Kategori"};

    // List yang berisi data yang akan dimasukkan ke dalam tabel
    private List<Jenis> data;

    // Konstruktor dari class JenisTableModel
    public JenisTableModel(List<Jenis> data) {
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
        Jenis rowItem = data.get(row);
        String value = "";

        switch (col) {
            case 0:
                value = rowItem.getNamaJenis();
                break;
            case 1:
                value = rowItem.getKategori().getNamaKategori();
                break;
        }
        return value;
    }

    // Method isCellEditable untuk mengembalikan boolean apakah cell dapat diubah atau tidak
    public boolean isCellEditable(int row, int col) {
        return false;
    }

    // Method add untuk menambahkan data ke dalam tabel
    public void add(Jenis jenis) {
        data.add(jenis);
        fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
    }

    // Method remove untuk menghapus data dari tabel
    public void remove(int row) {
        data.remove(row);
        fireTableRowsDeleted(row, row);
    }    
}