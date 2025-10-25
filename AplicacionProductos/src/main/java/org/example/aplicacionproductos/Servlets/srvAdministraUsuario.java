package org.example.aplicacionproductos.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.aplicacionproductos.Clases.Entidades.Usuario;
import org.example.aplicacionproductos.Clases.SeguridadController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/AdminUsuario")
public class srvAdministraUsuario  extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SeguridadController seguridad = new SeguridadController();
        request.setAttribute("listaClientes", seguridad.obtenerUsuarios());
        request.getRequestDispatcher("Pages/listadoClientes.jsp").forward(request, response);
    }
}
