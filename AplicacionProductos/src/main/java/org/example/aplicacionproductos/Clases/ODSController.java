package org.example.aplicacionproductos.Clases;

import java.sql.PreparedStatement;

public class ODSController extends DBController{

    public ODSController(){
        super("db.user_ods", "db.password_ods", "db.url_ods");
    }

    public boolean crearUsuario(String username, String nombreCompleto){
        try{
            String qryInsertaUsuario = "INSERT INTO `cliente`(`Usuario`, `NombreCompleto`) VALUES ( ?, ?)";
            PreparedStatement ps = conn.prepareStatement(qryInsertaUsuario);
            ps.setString(1, username);
            ps.setString(2, nombreCompleto);

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
}
