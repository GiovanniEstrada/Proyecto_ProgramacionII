package org.example.aplicacionproductos.Clases;

import org.example.aplicacionproductos.Clases.Entidades.Usuario;

import javax.xml.transform.Result;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SeguridadController extends DBController {

    public SeguridadController() {
        super("db.user_dbseg", "db.password_dbseg", "db.url_dbseg");
    }

    public Usuario obtenerUsuario(String username, String password){
        try{
            String qryValidaUsuario = "SELECT * FROM `usuarios` WHERE Usuario = '"+username+"' AND Pwd = '"+password+"' AND Estatus = 1";
            PreparedStatement ps = conn.prepareStatement(qryValidaUsuario);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                int id = rs.getInt("Id");
                String usuario = rs.getString("Usuario");
                String pwd = rs.getString("Pwd");
                String nombreCompleto = rs.getString("NombreCompleto");
                String correo = rs.getString("Correo");
                byte estatus = rs.getByte("Estatus");
                byte tipoUsuario = rs.getByte("TipoUsuario");
                LocalDateTime fechaHoraCreacion = null;
                LocalDateTime fechaHoraUltimaConexion = null;
                return new Usuario(id, usuario, pwd, nombreCompleto, correo, estatus, tipoUsuario, fechaHoraCreacion, fechaHoraUltimaConexion);
            }

        } catch (Exception e) {
            System.out.println("Error al obtener el usuario: " + e.getMessage());
        }

        return null;
    }

    public boolean crearUsuario(String username, String password, String correo, String nombreCompleto){
        try{
            String qryInsertaUsuario = "INSERT INTO `usuarios`(`Usuario`, `Pwd`, `NombreCompleto`, `Correo`, `Estatus`, `TipoUsuario`) VALUES ( ?, ?, ?, ?, 1, 2)";
            PreparedStatement ps = conn.prepareStatement(qryInsertaUsuario);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, nombreCompleto);
            ps.setString(4, correo);

            int resultado = ps.executeUpdate();
            if (resultado > 0) {
                return true;
            } else {
                System.out.println("No se logró crear el usuario");
                return false;
            }

        } catch (Exception e) {
            System.out.println("Error al obtener el usuario: " + e.getMessage());
        }

        return false;
    }

    public List<Usuario> obtenerUsuarios(){
        try{
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM `usuarios` WHERE Estatus = 1 AND TipoUsuario = 2");
            ResultSet rs = ps.executeQuery();
            List<Usuario> listaUsuarios = new ArrayList<Usuario>();
            while(rs.next()){
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("Id"));
                usuario.setUsuario(rs.getString("Usuario"));
                usuario.setPassword(rs.getString("Pwd"));
                usuario.setNombreCompleto(rs.getString("NombreCompleto"));
                usuario.setCorreo(rs.getString("Correo"));
                listaUsuarios.add(usuario);

            }
            return listaUsuarios;
        } catch (Exception e) {
            System.err.println("Error al obtener el usuarios: " + e.getMessage());
        }
        return null;
    }
}
