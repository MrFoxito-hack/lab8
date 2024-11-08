package com.example.lab8.servlets;

import com.example.lab8.daos.PeliculaDAO;
import com.example.lab8.beans.Pelicula;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/detalles")
public class DetallesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener el ID de la película desde los parámetros de la solicitud
        String idStr = request.getParameter("id");
        Pelicula pelicula = null;

        try {
            int idPelicula = Integer.parseInt(idStr); // Convertir el ID a un entero
            PeliculaDAO peliculaDAO = new PeliculaDAO();

            // Obtener los detalles de la película usando el método getPeliculaById
            pelicula = peliculaDAO.getPeliculaById(idPelicula);

        } catch (NumberFormatException e) {
            System.err.println("ID de película no válido: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error al obtener detalles de la película: " + e.getMessage());
        }

        // Pasar la película a la vista JSP
        request.setAttribute("pelicula", pelicula);
        request.getRequestDispatcher("/WEB-INF/viewPelicula.jsp").forward(request, response);
    }
}
