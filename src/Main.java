
import javax.swing.*;
import java.util.Scanner;

public class Main {
    private static JTextArea txtProductos;

    public static void main(String[] args) {
        operacionesDeTienda();
    }

    public static void operacionesDeTienda() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("No. de productos que va a agregar: ");
        int capacidad = scanner.nextInt();
        Tienda tienda = new Tienda(capacidad);
        int opcion;

        do {
            System.out.println("\nOperaciones:");
            System.out.println("1. Agregar producto (push)");
            System.out.println("2. Eliminar último producto agregado (pop)");
            System.out.println("3. Mostrar último producto agregado (peek)");
            System.out.println("4. Mostrar todos los productos");
            System.out.println("5. Salir");
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del producto: ");
                    String nombre = scanner.next();
                    System.out.print("Precio del producto: ");
                    double precio = scanner.nextDouble();
                    tienda.agregarProducto(nombre, precio);
                    break;
                case 2:
                    String productoEliminado = tienda.eliminarProducto();
                    if (productoEliminado != null) {
                        System.out.println("Eliminar último producto agregado: " + productoEliminado);
                    }
                    break;
                case 3:
                    String productoCima = tienda.verificarProducto();
                    if (productoCima != null) {
                        System.out.println("Último producto agregado: " + productoCima);
                    }
                    break;
                case 4:
                    tienda.mostrarProductos(txtProductos);
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}