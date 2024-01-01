/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

// package dao ini berfungsi untuk mengatur data yang ada di dalam database
package com.smarttrash.dao;

/**
 *
 * @author salma
 */

// import libraries yang dibutuhkan
import com.smarttrash.model.Kategori;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.smarttrash.db.MySqlConnection;

// membuat class KategoriDao yang berfungsi untuk mengatur data yang ada di dalam database
public class KategoriDao {
    // method insert untuk menambahkan data ke dalam database
    public int insert(Kategori kategori) {
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO kategori (id, nama) VALUES (?, ?)");) {
            statement.setInt(1, 0);
            statement.setString(2, kategori.getNamaKategori());

            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // method update untuk mengubah data yang ada di dalam database
    public int update(Kategori kategori) {
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection();) {
            PreparedStatement statement = connection.prepareStatement("UPDATE kategori SET nama = ? WHERE id = ?");
            statement.setString(1, kategori.getNamaKategori());
            statement.setInt(2, kategori.getIdKategori());

            result = statement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // method delete untuk menghapus data yang ada di dalam database
    public int delete(Kategori kategori) {
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection();) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM kategori WHERE id = ?");
            
            statement.setInt(1, kategori.getIdKategori());

            result = statement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // method findAll untuk mengambil semua data yang ada di dalam database
    public List<Kategori> findAll() {
        List<Kategori> list = new ArrayList<>();
        try(Connection connection = MySqlConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();) {
            try(ResultSet resultSet = statement.executeQuery("SELECT * FROM kategori");) {
                while(resultSet.next()) {
                    Kategori kategori = new Kategori();
                    kategori.setIdKategori(resultSet.getInt("id"));
                    kategori.setNamaKategori(resultSet.getString("nama"));
    
                    list.add(kategori);
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