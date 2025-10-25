package org.example.aplicacionproductos.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.aplicacionproductos.Clases.ODSController;

import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/nuevoProducto")
public class srvNuevoProducto extends HttpServlet {
    public void init() {
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ODSController ods =  new ODSController();

        request.setAttribute("tipoProductos", ods.obtenerTipoProducto());
        request.getRequestDispatcher("Pages/nuevoProducto.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ODSController ods = new ODSController();

        ods.ingresaProducto(
                Integer.parseInt(request.getParameter("tipoProducto")),
                request.getParameter("nombreProducto"),
                new BigDecimal(request.getParameter("precioUnidad"))
        );

        request.getRequestDispatcher("Pages/menuAdmin.jsp").forward(request, response);
    }
}
