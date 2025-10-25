package org.example.aplicacionproductos.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.aplicacionproductos.Clases.Entidades.Carrito;
import org.example.aplicacionproductos.Clases.Entidades.RelacionUsuarioCarrito;
import org.example.aplicacionproductos.Clases.Entidades.Usuario;
import org.example.aplicacionproductos.Clases.ODSController;

import java.io.IOException;

@WebServlet("/agregaCarrito")
public class srvAgregarCarrito extends HttpServlet {

    public void init(){}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sesion = request.getSession(false);
        ODSController ods =  new ODSController();

        if(sesion!=null){

            Usuario usuario = (Usuario)sesion.getAttribute("usuarioConectado");
            if(usuario==null){
                usuario = new Usuario();
            }
            ods.obtieneUsuarioPorNombre(usuario.getUsuario());

            // SE VALIDA SI EXISTE EL CARRITO
            RelacionUsuarioCarrito relacionCarrito = new RelacionUsuarioCarrito();
            relacionCarrito = ods.obtieneRelacionCarro(usuario.getId());
            int idCarrito = 0;
            // SI NO EXISTE SE CREA EL CARRITO
            if(relacionCarrito==null){
                idCarrito = ods.creaCarrito(0, 0, 1);
            } else {
                idCarrito = relacionCarrito.idCarrito;
            }

            Carrito carrito = new Carrito();
            carrito = ods.obtieneCarrito(usuario.getId());

            if(relacionCarrito==null){
                ods.creaRelacionCarrito(idCarrito, usuario.getId());
            }

            ods.creaDetalleCarrito(
                    idCarrito,
                    Integer.parseInt(request.getParameter("idProducto")),
                    0,
                    1,
                    Float.parseFloat(request.getParameter("precio")));

        }

        response.sendRedirect("despliegaProductos");

    }
}
