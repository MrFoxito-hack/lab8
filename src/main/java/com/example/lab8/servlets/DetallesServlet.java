package com.example.lab8.servlets;

import com.example.lab8.daos.PeliculaDAO;
import com.example.lab8.beans.Pelicula;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/detalles")
public class DetallesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener el ID de la película desde la solicitud
        int idPelicula = Integer.parseInt(request.getParameter("id"));

        // Usar PeliculaDAO para obtener los detalles de la película
        PeliculaDAO peliculaDAO = new PeliculaDAO();
        Pelicula pelicula = peliculaDAO.obtenerPeliculaPorId(idPelicula);

        // Pasar los detalles de la película a la vista JSP
        request.setAttribute("pelicula", pelicula);
        request.getRequestDispatcher("/WEB-INF/viewPelicula.jsp").forward(request, response);
    }
}
