package org.example.aplicacionproductos.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.aplicacionproductos.Clases.ODSController;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;

@WebServlet("/nuevoLote")
public class srvNuevoLote extends HttpServlet {
    public void init() {
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ODSController ods =  new ODSController();

        request.setAttribute("listaProductos", ods.obtenerListaProductos());
        request.getRequestDispatcher("Pages/nuevoLote.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ODSController ods = new ODSController();

        ods.ingresaLote(
                Integer.parseInt(request.getParameter("idProducto")),
                LocalDate.parse(request.getParameter("fechaCaducidad")),
                Integer.parseInt(request.getParameter("cantidadInicial"))
        );

        request.getRequestDispatcher("Pages/menuAdmin.jsp").forward(request, response);
    }
}
