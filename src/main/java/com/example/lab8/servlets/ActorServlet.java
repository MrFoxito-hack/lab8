package com.example.lab8.servlets;

import com.example.lab8.daos.ActorDAO;
import com.example.lab8.beans.Actor;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/actores")
public class ActorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Usar ActorDAO para obtener la lista de actores
        ActorDAO actorDAO = new ActorDAO();
        List<Actor> actores = actorDAO.listarActores();

        // Pasar la lista de actores a la vista JSP
        request.setAttribute("actores", actores);
        request.getRequestDispatcher("/WEB-INF/listaActores.jsp").forward(request, response);
    }
}