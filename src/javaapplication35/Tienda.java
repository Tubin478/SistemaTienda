package javaapplication35;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Tienda {

    public static void main(String[] args) {
       
        Scanner leer = new Scanner(System.in);

        System.out.println("\n= Tienda =\n");
        System.out.println("\n=============== CONSUTA DE PRODUCTOS  ===============\n");
        
        System.out.print("Ingrese el código del producto a buscar: ");
        String codigoProducto = leer.nextLine().trim();

        consultarProductoPorCodigo(codigoProducto);

        leer.close();
    }

    public static void consultarProductoPorCodigo(String codigo) {
        System.out.println("\n---------------------------------------------------------\n");
        System.out.println("Buscando producto con código: [" + codigo + "]");
        System.out.println("\n---------------------------------------------------------\n");
         
        ConexionDb conexionDb = new ConexionDb();
        Connection conexion = conexionDb.obtenerConexion();
        // es para verificar que si este leendo la base de datos 
        if (conexion == null) {
        System.out.println("No se pudo conectar a la base de datos.");
        return;
       }

        String consulta = "SELECT * FROM Productos WHERE Código = ?";

        try {
            PreparedStatement ps = conexion.prepareStatement(consulta);
            ps.setString(1, codigo);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("\n--- Producto Encontrado ---");
                System.out.println("Código: " + rs.getString("Código"));
                System.out.println("Nombre: " + rs.getString("Nombre"));
                System.out.println("Precio: Q." + rs.getDouble("Precio"));
                System.out.println("Stock: " + rs.getInt("Stock"));
                System.out.println("----------------------------");
            } else {
                System.out.println("No se encontró ningún producto con el código ingresado.");
            }

            rs.close();
            ps.close();
            conexion.close();

        } catch (Exception e) {
            System.out.println("Error al consultar el producto: " + e.getMessage());
            e.printStackTrace();
        }
      
    }
}