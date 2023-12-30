/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.smarttrash.dao;

// import libraries yang dibutuhkan
import com.smarttrash.model.Petugas;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.smarttrash.db.MySqlConnection;

/**
 *
 * @author imam
 */

// membuat class PetugasDao yang berfungsi untuk mengatur data yang ada di dalam database
public class PetugasDao {
    // method insert untuk menambahkan data ke dalam database
    public int insert(Petugas petugas) {
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection();) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO petugas (id, nama, alamat, nomor_telepon, jabatan, status_pendaftaran) VALUES (?, ?, ?, ?, ?, ?)");
            statement.setInt(1, 0);
            statement.setString(2, petugas.getNama());
            statement.setString(3, petugas.getAlamat());
            statement.setString(4, petugas.getNoTelp());
            statement.setString(5, petugas.getJabatan());
            statement.setString(6, petugas.getStatusPendaftaran());

            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // method update untuk mengubah data yang ada di dalam database
    public int update(Petugas petugas) {
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection();) {
            PreparedStatement statement = connection.prepareStatement("UPDATE petugas SET nama = ?, alamat = ?, nomor_telepon = ?, jabatan = ?, status_pendaftaran = ? WHERE id = ?");
            statement.setString(1, petugas.getNama());
            statement.setString(2, petugas.getAlamat());
            statement.setString(3, petugas.getNoTelp());
            statement.setString(4, petugas.getJabatan());
            statement.setString(5, petugas.getStatusPendaftaran());
            statement.setInt(6, petugas.getIdPetugas());

            result = statement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // method delete untuk menghapus data yang ada di dalam database
    public int delete(Petugas petugas) {
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection();) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM petugas WHERE id = ?");
            
            statement.setInt(1, petugas.getIdPetugas());

            result = statement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // method findAll untuk menampilkan semua data yang ada di dalam database
    public List<Petugas> findAll() {
        List<Petugas> list = new ArrayList<>();
        try(Connection connection = MySqlConnection.getInstance().getConnection();
            Statement statement = connection.createStatement(); ) {
            try(ResultSet resultSet = statement.executeQuery("SELECT * FROM petugas");) {
                while(resultSet.next()) {
                    Petugas petugas = new Petugas();
                    petugas.setIdPetugas(resultSet.getInt("id"));
                    petugas.setNama(resultSet.getString("nama"));
                    petugas.setAlamat(resultSet.getString("alamat"));
                    petugas.setNoTelp(resultSet.getString("nomor_telepon"));
                    petugas.setJabatan(resultSet.getString("jabatan"));
                    petugas.setStatusPendaftaran(resultSet.getString("status_pendaftaran"));
                    list.add(petugas);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}