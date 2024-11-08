package com.example.lab8.servlets;

import com.example.lab8.daos.ActorDAO;
import com.example.lab8.beans.Actor;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/actores")
public class ActorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener el parámetro id de la película
        String idPeliculaStr = request.getParameter("idPelicula");

        if (idPeliculaStr != null && !idPeliculaStr.isEmpty()) {
            try {
                int idPelicula = Integer.parseInt(idPeliculaStr);
                ActorDAO actorDAO = new ActorDAO();
                List<Actor> actores = actorDAO.getActorsByPelicula(idPelicula);

                // Pasar la lista de actores al JSP
                request.setAttribute("actores", actores);
                request.getRequestDispatcher("/WEB-INF/listaActores.jsp").forward(request, response);
            } catch (NumberFormatException | SQLException e) {
                // Manejar excepciones y mostrar un mensaje de error
                response.getWriter().write("Error: " + e.getMessage());
            }
        } else {
            response.getWriter().write("El id no ha sido proporcionado");
        }
    }
}
