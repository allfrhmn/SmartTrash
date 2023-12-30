/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smarttrash.dao;

/**
 *
 * @author Emilia Paradila S
 */


    // import libraries yang dibutuhkan
import com.smarttrash.model.Masyarakat;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.smarttrash.db.MySqlConnection;

// membuat class MasyarakatDao yang berfungsi untuk mengatur data yang ada di dalam database
public class MasyarakatDao {
    // method insert untuk menambahkan data ke dalam database
    public int insert(Masyarakat masyarakat) {
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection();) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO masyarakat (id, nama, alamat, nomor_telepon, email, status_pendaftaran) VALUES (?, ?, ?, ?, ?, ?)");
            statement.setInt(1, 0);
            statement.setString(2, masyarakat.getNama());
            statement.setString(3, masyarakat.getAlamat());
            statement.setString(4, masyarakat.getNoTelp());
            statement.setString(5, masyarakat.getEmail());
            statement.setString(6, masyarakat.getStatusPendaftaran());

            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // method update untuk mengubah data yang ada di dalam database
    public int update(Masyarakat masyarakat) {
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection();) {
            PreparedStatement statement = connection.prepareStatement("UPDATE masyarakat SET nama = ?, alamat = ?, nomor_telepon = ?, email = ?, status_pendaftaran = ? WHERE id = ?");
            statement.setString(1, masyarakat.getNama());
            statement.setString(2, masyarakat.getAlamat());
            statement.setString(3, masyarakat.getNoTelp());
            statement.setString(4, masyarakat.getEmail());
            statement.setString(5, masyarakat.getStatusPendaftaran());
            statement.setInt(6, masyarakat.getIdMasyarakat());

            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // method delete untuk menghapus data yang ada di dalam database
    public int delete(Masyarakat masyarakat) {
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM masyarakat WHERE id = ?");
            
            statement.setInt(1, masyarakat.getIdMasyarakat());

            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // method findAll untuk menampilkan semua data yang ada di dalam database
    public List<Masyarakat> findAll() {
        List<Masyarakat> list = new ArrayList<>();
        try(Connection connection = MySqlConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();) {
            try(ResultSet resultSet = statement.executeQuery("SELECT * FROM masyarakat")) {
                while (resultSet.next()) {
                    Masyarakat masyarakat = new Masyarakat();
                    masyarakat.setIdMasyarakat(resultSet.getInt("id"));
                    masyarakat.setNama(resultSet.getString("nama"));
                    masyarakat.setAlamat(resultSet.getString("alamat"));
                    masyarakat.setNoTelp(resultSet.getString("nomor_telepon"));
                    masyarakat.setEmail(resultSet.getString("email"));
                    masyarakat.setStatusPendaftaran(resultSet.getString("status_pendaftaran"));
                    list.add(masyarakat);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
    

