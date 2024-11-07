package com.example.lab8.daos;

import com.example.lab8.beans.Pelicula;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PeliculaDAO extends DaoBase {

    // Método para listar todas las películas ordenadas por rating y box office
    public List<Pelicula> listarPeliculas() {
        List<Pelicula> peliculas = new ArrayList<>();
        String sql = "SELECT * FROM Pelicula ORDER BY rating DESC, boxOffice DESC";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Pelicula pelicula = mapResultSetToPelicula(rs);
                peliculas.add(pelicula);
            }

        } catch (SQLException e) {
            System.err.println("Error al listar películas: " + e.getMessage());
        }

        return peliculas;
    }

    // Método para obtener los detalles de una película por su ID
    public Pelicula obtenerPeliculaPorId(int id) {
        Pelicula pelicula = null;
        String sql = "SELECT * FROM Pelicula WHERE idPelicula = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                pelicula = mapResultSetToPelicula(rs);
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener película por ID: " + e.getMessage());
        }

        return pelicula;
    }

    // Método privado para mapear un ResultSet a un objeto Pelicula
    private Pelicula mapResultSetToPelicula(ResultSet rs) throws SQLException {
        Pelicula pelicula = new Pelicula();
        pelicula.setIdPelicula(rs.getInt("idPelicula"));
        pelicula.setTitulo(rs.getString("titulo"));
        pelicula.setDirector(rs.getString("director"));
        pelicula.setAnoPublicacion(rs.getInt("anoPublicacion"));
        pelicula.setRating(rs.getDouble("rating"));
        pelicula.setBoxOffice(rs.getDouble("boxOffice"));
        pelicula.setIdGenero(rs.getInt("idGenero"));
        return pelicula;
    }
}
