package com.example.lab8.daos;

import com.example.lab8.beans.Actor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActorDAO extends DaoBase {
    public List<Actor> listarActores() {
        List<Actor> actores = new ArrayList<>();
        String sql = "SELECT * FROM Actor";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Actor actor = new Actor();
                actor.setIdActor(rs.getInt("idActor"));
                actor.setNombre(rs.getString("nombre"));
                actor.setApellido(rs.getString("apellido"));
                actor.setAnoNacimiento(rs.getInt("anoNacimiento"));
                actor.setPremioOscar(rs.getBoolean("premioOscar"));
                actores.add(actor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actores;
    }
}
