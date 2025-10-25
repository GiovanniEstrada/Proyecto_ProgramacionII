package org.example.aplicacionproductos.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.aplicacionproductos.Clases.ODSController;
import org.example.aplicacionproductos.Clases.SeguridadController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/AdminProducto")
public class srvAdministraProducto  extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ODSController ods = new ODSController();
        request.setAttribute("listaProductos", ods.obtenerLotes());
        request.getRequestDispatcher("Pages/listadoProductos.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SeguridadController seguridad = new SeguridadController();

        try{
            int id =  Integer.parseInt(request.getParameter("id"));
            seguridad.actualizarUsuario(id);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
