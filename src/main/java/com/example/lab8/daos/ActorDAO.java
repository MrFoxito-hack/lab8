package com.example.lab8.daos;

import com.example.lab8.beans.Actor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActorDAO extends DaoBase {

    public List<Actor> getActorsByPelicula(int idPelicula) throws SQLException {
        List<Actor> actores = new ArrayList<>();
        String query = "SELECT a.idActor, a.nombre, a.apellido, a.anoNacimiento, a.premioOscar " +
                "FROM Actor a JOIN Protagonistas p ON a.idActor = p.idActor " +
                "WHERE p.idPelicula = ?";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idPelicula);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Actor actor = new Actor();
                    actor.setIdActor(resultSet.getInt("idActor"));
                    actor.setNombre(resultSet.getString("nombre"));
                    actor.setApellido(resultSet.getString("apellido"));
                    actor.setAnoNacimiento(resultSet.getInt("anoNacimiento"));
                    actor.setPremioOscar(resultSet.getBoolean("premioOscar"));
                    actores.add(actor);
                }
            }
        }
        return actores;
    }
}
