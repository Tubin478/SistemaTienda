
package javaapplication35;
//importacion de herramientas para Mysql
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistrarProducto {
    public void registrarProducto(String codigo, String nombre, double precio, int stock) {
        
        ConexionDb conexionDb = new ConexionDb(); //se instancia el metodo para la conexcion 
        Connection conexion = null;
        PreparedStatement statement = null;
        //se utiliza un try cach para evitar que el sistema se detenga si da algun error

        try {
            conexion = conexionDb.obtenerConexion();
            // se prepara la consulta para setear los datos
            String query = "INSERT INTO Productos (Código, Nombre, Precio, Stock) VALUES (?, ?, ?, ?)";
            statement = conexion.prepareStatement(query);
            statement.setString(1, codigo);
            statement.setString(2, nombre);
            statement.setDouble(3, precio);
            statement.setInt(4, stock);
            //se ejecuta Update para ingresar la informacion a la base de datos 
            statement.executeUpdate();
            System.out.println("Producto registrado con éxito");
        } catch (SQLException e) {
            System.out.println("Error al registrar producto");
            System.out.println(e);
        } finally {
            //se cierran las consultas y la conexcion. 
            try {
                if (statement != null) {
                    statement.close();//cerrar consulta 
                }
                if (conexion != null) {
                    conexion.close(); //cerrar conexion 
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar statement");
            }
        }
    }
}
