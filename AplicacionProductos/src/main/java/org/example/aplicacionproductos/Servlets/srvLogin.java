package org.example.aplicacionproductos.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.aplicacionproductos.Clases.Entidades.Usuario;
import org.example.aplicacionproductos.Clases.SeguridadController;

import java.io.IOException;

@WebServlet("/login")
public class srvLogin extends HttpServlet {
    private String message;

    public void init() {

    }

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");



        int opt = Integer.parseInt(request.getParameter("opt"));
        if (opt == 2) {
            System.out.println("Ingresó opt 2");
            request.getRequestDispatcher("Pages/registrar.jsp").forward(request, response);
        }

        String usuario =  request.getParameter("usuario");
        String password =  request.getParameter("password");
        // Hello
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");


        System.out.println("Post");
        int opt = Integer.parseInt(request.getParameter("opt"));
        if (opt == 1) {
            // SE GENERA LA SESION PARA GUARDAR USUARIO
            HttpSession session = request.getSession();

            // SE REALIZA LA CONEXION A SEGURIDAD
            SeguridadController seg = new SeguridadController();

            String username = request.getParameter("in_usuario");
            String password = request.getParameter("in_pwd");

            Usuario usuario = seg.obtenerUsuario(username, password);
            session.setAttribute("usuarioConectado", usuario);

            if (usuario != null) {
                if(usuario.getTipoUsuario() == 1) {

                    request.getRequestDispatcher("Pages/menuAdmin.jsp").forward(request, response);
                } else {
                    response.sendRedirect("AdminUsuario");
                }
            }

            System.out.println("Ingresó opt 1");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    public void destroy() {
    }
}