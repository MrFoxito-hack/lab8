package com.example.lab8.daos;

import com.example.lab8.beans.Genero;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GeneroDAO extends DaoBase {
    public List<Genero> listarGeneros() {
        List<Genero> generos = new ArrayList<>();
        String sql = "SELECT * FROM Genero";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Genero genero = new Genero();
                genero.setIdGenero(rs.getInt("idGenero"));
                genero.setNombre(rs.getString("nombre"));
                generos.add(genero);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return generos;
    }
}
