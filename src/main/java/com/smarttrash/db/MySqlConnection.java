// Tugas Besar Praktikum Pemrograman II - Kelompok 5 

// package ini berfungsi untuk menghubungkan aplikasi dengan database
package com.smarttrash.db;

// import yang digunakan untuk menghubungkan aplikasi dengan database
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// deklarasi class MySqlConnection
public class MySqlConnection {
    // atribut yang digunakan untuk menghubungkan aplikasi dengan database
    private final String DB_URL = "jdbc:mysql://localhost:3306/smarttrash";
    private final String DB_USER = "root";
    private final String DB_PASS = "";

    // instance dari class MySqlConnection
    private static MySqlConnection instance;

    // method yang digunakan untuk mengembalikan nilai dari atribut DB_URL
    public static MySqlConnection getInstance() {
        if (instance == null) {
            instance = new MySqlConnection();
        }
        return instance;
    }

    // connection untuk mendapatkan koneksi dari database
    public Connection getConnection() {
        Connection connection = null;
        try {
            // menghubungkan aplikasi dengan database
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}