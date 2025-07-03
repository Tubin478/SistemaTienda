/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication35;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author GP
 */
public class ConexionDb {
    Connection conexion = null;
    String database = "Tienda";
    String url = "jdbc:mysql://localhost:3306/" + database;
    String usuario = "root";
    String clave = "020592";

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
