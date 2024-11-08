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
        PeliculaDAO peliculaDAO = new PeliculaDAO();

        // Obtener el parámetro de búsqueda
        String searchQuery = request.getParameter("search");

        List<Pelicula> peliculas;
        if (searchQuery != null && !searchQuery.isEmpty()) {
            // Buscar películas con el término proporcionado
            peliculas = peliculaDAO.buscarPeliculas(searchQuery);
        } else {
            // Obtener todas las películas si no hay búsqueda
            peliculas = peliculaDAO.listarPeliculas();
        }

        // Pasar la lista de películas a la vista JSP
        request.setAttribute("peliculas", peliculas);
        request.getRequestDispatcher("/WEB-INF/listaPeliculas.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Manejar la eliminación de la película
        String idStr = request.getParameter("id");


        try {
            int id = Integer.parseInt(idStr); // Convertir el ID a un entero
            PeliculaDAO peliculaDAO = new PeliculaDAO();

            // Llamar al método para eliminar la película
            boolean eliminado = peliculaDAO.eliminarPelicula(id);

            if (eliminado) {
                // Redirigir a la lista de películas si la eliminación fue exitosa
                response.sendRedirect("peliculas");
            } else {
                // Mostrar un mensaje de error si no se pudo eliminar
                response.getWriter().write("Hubo un error al eliminar la pelicula.");
            }
        } catch (NumberFormatException e) {
            // Manejar el caso de un ID no válido
            response.getWriter().write("ID de película no válido.");
        }
    }
}
