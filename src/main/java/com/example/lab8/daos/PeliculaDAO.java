package com.example.lab8.daos;

import com.example.lab8.beans.Pelicula;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PeliculaDAO extends DaoBase {

    // Método para listar todas las películas ordenadas por rating y box office
    public List<Pelicula> listarPeliculas() {
        List<Pelicula> peliculas = new ArrayList<>();
        String sql = "SELECT p.idPelicula, p.titulo, p.director, p.anoPublicacion, p.rating, p.boxOffice, g.nombre AS genero " +
                "FROM Pelicula p JOIN Genero g ON p.idGenero = g.idGenero " +
                "ORDER BY p.rating DESC, p.boxOffice DESC";


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
    public Pelicula getPeliculaById(int idPelicula) throws SQLException {
        String query = "SELECT * FROM Pelicula WHERE idPelicula = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idPelicula);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Pelicula pelicula = new Pelicula();
                    pelicula.setIdPelicula(resultSet.getInt("idPelicula"));
                    pelicula.setTitulo(resultSet.getString("titulo"));
                    pelicula.setDirector(resultSet.getString("director"));
                    pelicula.setAnoPublicacion(resultSet.getInt("anoPublicacion"));
                    pelicula.setRating(resultSet.getDouble("rating"));
                    pelicula.setBoxOffice(resultSet.getDouble("boxOffice"));
                    pelicula.setIdGenero(resultSet.getInt("idGenero"));
                    // Agrega más campos según los atributos en tu tabla Pelicula
                    return pelicula;
                }
            }
        }
        return null;
    }


    private Pelicula mapResultSetToPelicula(ResultSet rs) throws SQLException {
        Pelicula pelicula = new Pelicula();
        pelicula.setIdPelicula(rs.getInt("idPelicula"));
        pelicula.setTitulo(rs.getString("titulo"));
        pelicula.setDirector(rs.getString("director"));
        pelicula.setAnoPublicacion(rs.getInt("anoPublicacion"));
        pelicula.setRating(rs.getDouble("rating"));
        pelicula.setBoxOffice(rs.getDouble("boxOffice"));
        pelicula.setGenero(rs.getString("genero"));
        return pelicula;
    }

    public List<Pelicula> buscarPeliculas(String searchQuery) {
        List<Pelicula> peliculas = new ArrayList<>();
        String sql = "SELECT p.idPelicula, p.titulo, p.director, p.anoPublicacion, p.rating, p.boxOffice, g.nombre AS genero " +
                "FROM Pelicula p JOIN Genero g ON p.idGenero = g.idGenero " +
                "WHERE p.titulo LIKE ? ORDER BY rating DESC, boxOffice DESC";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + searchQuery + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Pelicula pelicula = mapResultSetToPelicula(rs);
                peliculas.add(pelicula);
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar películas: " + e.getMessage());
        }

        return peliculas;
    }

    // En tu archivo PeliculaDAO.java
    public boolean eliminarPelicula(int id) {
        String sql = "DELETE FROM Pelicula WHERE idPelicula = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.err.println("hubo un error al eliminar la película: " + e.getMessage());
            return false;
        }
    }

}
