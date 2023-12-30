/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smarttrash.dao;

/**
 *
 * @author allfiandi
 */

// import libraries yang dibutuhkan
import com.smarttrash.model.Poin;
import com.smarttrash.model.Kategori;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.smarttrash.db.MySqlConnection;

// class PoinDao yang berfungsi untuk mengatur data yang ada di dalam database
public class PoinDao {
    // method insert untuk menambahkan data ke dalam database
    public int insert(Poin poin) {
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection();) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO poin (id, jumlah_poin, id_kategori) VALUES (?, ?, ?)");
            statement.setInt(1, 0);
            statement.setInt(2, poin.getJumlahPoin());
            statement.setInt(3, poin.getKategori().getIdKategori());

            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // method update untuk mengubah data yang ada di dalam database
    public int update(Poin poin) {
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection();) {
            PreparedStatement statement = connection.prepareStatement("UPDATE poin SET jumlah_poin = ?, id_kategori = ? WHERE id = ?");
            statement.setInt(1, poin.getJumlahPoin());
            statement.setInt(2, poin.getKategori().getIdKategori());
            statement.setInt(3, poin.getIdPoin());

            result = statement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // method delete untuk menghapus data yang ada di dalam database
    public int delete(Poin poin) {
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection();) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM poin WHERE id = ?");
            statement.setInt(1, poin.getIdPoin());

            result = statement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // method findAll untuk mengambil semua data yang ada di dalam database
    public List<Poin> findAll() {
        List<Poin> list = new ArrayList<>();
        try(Connection connection = MySqlConnection.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * " 
            + " FROM poin INNER JOIN kategori ON poin.id_kategori = kategori.id");
            ResultSet resultSet = statement.executeQuery();) {
            while(resultSet.next()) {
                Poin poin = new Poin();
                poin.setIdPoin(resultSet.getInt("poin.id"));
                poin.setJumlahPoin(resultSet.getInt("poin.jumlah_poin"));

                Kategori kategori = new Kategori();
                kategori.setIdKategori(resultSet.getInt("kategori.id"));
                kategori.setNamaKategori(resultSet.getString("kategori.nama"));

                poin.setKategori(kategori);

                list.add(poin);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return list;
    }   
}   