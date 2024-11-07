package com.example.lab8.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DaoBase {
    // URL de la base de datos, usuario y contraseña
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/mydb?serverTimezone=America/Lima";
    private static final String USER = "root";
    private static final String PASSWORD = "Foxi1234";

    // Método para obtener la conexión a la base de datos
    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
