package org.example.aplicacionproductos.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.aplicacionproductos.Clases.ODSController;

import java.io.IOException;

@WebServlet("/despliegaProductos")
public class srvDespliegueProductos extends HttpServlet {
    public void init() {
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ODSController ods =  new ODSController();

        request.setAttribute("listaProductos", ods.obtieneCatalogoProductos());
        request.getRequestDispatcher("Pages/menuUsuario.jsp").forward(request, response);
    }
}
