package org.example.aplicacionproductos.Clases;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBController {
    private final String user;
    private final String pass;
    private final String url;
    protected Connection conn;

    public DBController(String user, String pass, String url) {

        Properties prop = new Properties();

        try(InputStream in = getClass().getClassLoader().getResourceAsStream("/db.properties")){
            if(in == null){
                System.err.println("No se encontraron parámetros");

            } else {
                prop.load(in);
            }
        } catch (Exception e) {
            System.err.println("Error al obtener parámetros inciales");
        }

        this.user = prop.getProperty(user);
        this.pass = prop.getProperty(pass);
        this.url = prop.getProperty(url);

        // SE REALIZA LA CONEXION INICIAL
        fnGetConnection();
    }

    private void fnGetConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Driver JDBC no encontrado en classpath: " + e.getMessage());
        }

        try{
            conn =  DriverManager.getConnection(url, user, pass);
            System.out.println("Se realizó la conexión hacia la base de datos...");
        } catch (SQLException e) {
            System.out.println("Ocurrió un error al conectarse!!");
            System.out.println(e.getMessage());
            conn = null;
        }
    }
}
