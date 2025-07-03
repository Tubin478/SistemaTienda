package javaapplication35;


public class Main {

    public static void main(String[] args) {
        RegistrarProducto registrarProducto = new RegistrarProducto();
        try {
            registrarProducto.registrarProducto("1020", "Leche", 10.99, 50);
            System.out.println("Registro exitoso");
        } catch (Exception e) {
            System.out.println("Registro no exitoso");
            System.out.println("Error: " + e.getMessage());
        }

    }
}
