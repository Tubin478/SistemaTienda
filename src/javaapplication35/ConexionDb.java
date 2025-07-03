package javaapplication35;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexionDb {
    Connection conexion = null;
    String database = "Tienda";
    String url = "jdbc:mysql://localhost:3306/" + database;
    String usuario = "root";
    String clave = "Shirley1017.";

    public Connection obtenerConexion() {
        try {
            conexion = DriverManager.getConnection(url, usuario, clave);

        } catch (SQLException e) {
            System.out.println("Ocurrio un erro al conectarse a la base de datos " + database);
            System.out.println(e);
        } 

        return conexion;
    }
    
}
