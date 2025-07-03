package javaapplication35;


public class Main {

    public static void main(String[] args) {
        //se instancia para acceder al metodo registrar producto
        RegistrarProducto registrarProducto = new RegistrarProducto();
        //se realiza una prueba con try catch para evitar que el programa no se ejecute correctamente
        try {
            //registro de prueba
            registrarProducto.registrarProducto("3020", "cafe", 12.99, 50);
            System.out.println("Registro exitoso");
        } catch (Exception e) {
            System.out.println("Registro no exitoso");
            System.out.println("Error: " + e.getMessage());
        }

    }
}
