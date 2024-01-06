/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

// package dao ini berfungsi untuk mengatur data yang ada di dalam database
package com.smarttrash.dao;

/**
 * 
 *  @author Deni P
 * 
*/

// import libraries yang dibutuhkan
import com.smarttrash.model.Jenis;
import com.smarttrash.model.Kategori;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.smarttrash.db.MySqlConnection;

// membuat class JenisDao yang berfungsi untuk mengatur data yang ada di dalam database
public class JenisDao {
    // method insert untuk menambahkan data ke dalam database
    public int insert(Jenis jenis) {
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection();) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO jenis (id, nama, id_kategori) VALUES (?, ?, ?)");
            statement.setInt(1, 0);
            statement.setString(2, jenis.getNamaJenis());
            statement.setInt(3, jenis.getKategori().getIdKategori());
            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // method update untuk mengubah data yang ada di dalam database
    public int update(Jenis jenis) {
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection();) {
            PreparedStatement statement = connection.prepareStatement("UPDATE jenis SET nama = ?, id_kategori = ? WHERE id = ?");
            statement.setString(1, jenis.getNamaJenis());
            statement.setInt(2, jenis.getKategori().getIdKategori());
            statement.setInt(3, jenis.getIdJenis());
            result = statement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // method delete untuk menghapus data yang ada di dalam database
    public int delete(Jenis jenis) {
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection();) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM jenis WHERE id = ?");
            
            statement.setInt(1, jenis.getIdJenis());

            result = statement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // method findAll untuk mengambil semua data yang ada di dalam database
    public List<Jenis> findAll() {
        List<Jenis> list = new ArrayList<>();
        try(Connection connection = MySqlConnection.getInstance().getConnection(); 
            Statement statement = connection.createStatement()) {
                try(ResultSet resultSet = statement.executeQuery("SELECT jenis.id, jenis.nama, jenis.id_kategori, kategori.id AS id_kategori, kategori.nama AS nama_kategori " 
                + " FROM jenis JOIN kategori ON jenis.id_kategori = kategori.id");) {
                    while(resultSet.next()) {
                        Jenis jenis = new Jenis();
                        jenis.setIdJenis(resultSet.getInt("id"));
                        jenis.setNamaJenis(resultSet.getString("nama"));
                        
                        Kategori kategori = new Kategori();
                        kategori.setIdKategori(resultSet.getInt("id_kategori"));
                        kategori.setNamaKategori(resultSet.getString("nama_kategori"));
                        
                        jenis.setKategori(kategori);
                        list.add(jenis);
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