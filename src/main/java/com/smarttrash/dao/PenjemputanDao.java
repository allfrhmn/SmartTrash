/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

// package dao ini berfungsi untuk mengatur data yang ada di dalam database
package com.smarttrash.dao;

/**
 *
 * @author allfiandi
 */

// import library yang dibutuhkan
import com.smarttrash.model.Penjemputan;
import com.smarttrash.model.Masyarakat;
import com.smarttrash.model.Petugas;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.smarttrash.db.MySqlConnection;

// membuat class PenjemputanDao yang berfungsi untuk mengatur data yang ada di dalam database
public class PenjemputanDao {
    // method insert untuk menambahkan data ke dalam database
    public int insert(Penjemputan penjemputan) {
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection();) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO penjemputan (id, tanggal_penjemputan, status_penjemputan, keputusan_konfirmasi, jadwal_konfirmasi, tanggal_riwayat, id_masyarakat, id_petugas) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            statement.setInt(1, 0);
            statement.setString(2, penjemputan.getTanggalPenjemputan());
            statement.setString(3, penjemputan.getStatusPenjemputan());
            statement.setString(4, penjemputan.getKeputusanKonfirmasi());
            statement.setString(5, penjemputan.getTanggalKonfirmasi());
            statement.setString(6, penjemputan.getTanggalRiwayat());
            statement.setInt(7, penjemputan.getMasyarakat().getIdMasyarakat());
            statement.setInt(8, penjemputan.getPetugas().getIdPetugas());

            result = statement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // method update untuk mengubah data yang ada di dalam database
    public int update(Penjemputan penjemputan) {
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection();) {
            PreparedStatement statement = connection.prepareStatement("UPDATE penjemputan SET tanggal_penjemputan = ?, status_penjemputan = ?, keputusan_konfirmasi = ?, jadwal_konfirmasi = ?, tanggal_riwayat = ?, id_masyarakat = ?, id_petugas = ? WHERE id = ?");
            statement.setString(1, penjemputan.getTanggalPenjemputan());
            statement.setString(2, penjemputan.getStatusPenjemputan());
            statement.setString(3, penjemputan.getKeputusanKonfirmasi());
            statement.setString(4, penjemputan.getTanggalKonfirmasi());
            statement.setString(5, penjemputan.getTanggalRiwayat());
            statement.setInt(6, penjemputan.getMasyarakat().getIdMasyarakat());
            statement.setInt(7, penjemputan.getPetugas().getIdPetugas());
            statement.setInt(8, penjemputan.getIdPenjemputan());

            result = statement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // method delete untuk menghapus data yang ada di dalam database
    public int delete(Penjemputan penjemputan) {
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection();) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM penjemputan WHERE id = ?");
            statement.setInt(1, penjemputan.getIdPenjemputan());

            result = statement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // method findAll untuk menampilkan semua data yang ada di dalam database
    public List<Penjemputan> findAll() {
        List<Penjemputan> list = new ArrayList<>();
        try(Connection connection = MySqlConnection.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT penjemputan.id, penjemputan.tanggal_penjemputan, penjemputan.status_penjemputan, penjemputan.keputusan_konfirmasi, penjemputan.jadwal_konfirmasi, penjemputan.tanggal_riwayat, penjemputan.id_masyarakat, penjemputan.id_petugas, masyarakat.id AS id_masyarakat, masyarakat.nama AS nama_masyarakat, petugas.id AS id_petugas, petugas.nama AS nama_petugas " 
            + " FROM penjemputan JOIN masyarakat ON penjemputan.id_masyarakat = masyarakat.id " 
            + " JOIN petugas ON penjemputan.id_petugas = petugas.id");) {
            try(ResultSet resultSet = statement.executeQuery();) {
                while(resultSet.next()) {
                    Penjemputan penjemputan = new Penjemputan();
                    penjemputan.setIdPenjemputan(resultSet.getInt("id"));
                    penjemputan.setTanggalPenjemputan(resultSet.getString("tanggal_penjemputan"));
                    penjemputan.setStatusPenjemputan(resultSet.getString("status_penjemputan"));
                    penjemputan.setKeputusanKonfirmasi(resultSet.getString("keputusan_konfirmasi"));
                    penjemputan.setTanggalKonfirmasi(resultSet.getString("jadwal_konfirmasi"));
                    penjemputan.setTanggalRiwayat(resultSet.getString("tanggal_riwayat"));

                    Masyarakat masyarakat = new Masyarakat();
                    masyarakat.setIdMasyarakat(resultSet.getInt("id_masyarakat"));
                    masyarakat.setNama(resultSet.getString("nama_masyarakat"));
                    penjemputan.setMasyarakat(masyarakat);

                    Petugas petugas = new Petugas();
                    petugas.setIdPetugas(resultSet.getInt("id_petugas"));
                    petugas.setNama(resultSet.getString("nama_petugas"));
                    penjemputan.setPetugas(petugas);

                    list.add(penjemputan);
                }
            } catch(SQLException e) {
                e.printStackTrace();
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}