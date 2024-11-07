package com.example.lab8.servlets;

import com.example.lab8.daos.PeliculaDAO;
import com.example.lab8.beans.Pelicula;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/peliculas")
public class PeliculaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Usar PeliculaDAO para obtener la lista de películas
        PeliculaDAO peliculaDAO = new PeliculaDAO();
        List<Pelicula> peliculas = peliculaDAO.listarPeliculas();

        // Pasar la lista de películas a la vista JSP
        request.setAttribute("peliculas", peliculas);
        request.getRequestDispatcher("/WEB-INF/listaPeliculas.jsp").forward(request, response);
    }
}
