package org.example.aplicacionproductos.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.aplicacionproductos.Clases.ODSController;
import org.example.aplicacionproductos.Clases.SeguridadController;
import org.example.aplicacionproductos.Clases.Entidades.*;

import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/register")
public class srvRegistrar extends HttpServlet {

    public void init(){

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try{
            SeguridadController seguridad = new SeguridadController();
            ODSController ods = new ODSController();
            String usuario = request.getParameter("usuario");
            String pwd = request.getParameter("pwd");
            String nombreCompleto = request.getParameter("nombreCompleto");
            String correo = request.getParameter("correo");
            LocalDateTime time = null;

            if(seguridad.crearUsuario(usuario, pwd, correo, nombreCompleto)){
                if(ods.crearUsuario(usuario, nombreCompleto)){
                    System.out.println("Usuario creado correctamente");
                } else {
                    System.err.println("No se pudo crear el usuario");
                }
            } else {
                System.err.println("No se pudo crear el usuario");
            }


            System.out.println(correo);
            System.out.println(pwd);
            System.out.println(nombreCompleto);
            System.out.println(usuario);

        } catch (Exception e) {
            System.err.println("Error al procesar el registro: " + e.getMessage());
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }

    public void destroy(){

    }
}
