import javax.swing.*;

public class Tienda {
    private int capacidad;
    private Producto[] productos;
    private int cima;

    public Tienda(int capacidad) {
        this.capacidad = capacidad;
        this.productos = new Producto[capacidad];
        this.cima = -1;
    }

    public void agregarProducto(String nombre, double precio) {
        if (estaLlena()) {
            System.out.println("Error: La tienda está llena.");
        } else {
            cima++;
            productos[cima] = new Producto(nombre, precio);
            System.out.println("Producto " + nombre + " agregado.");
        }
    }

    public String eliminarProducto() {
        if (estaVacia()) {
            System.out.println("Error: La tienda está vacía.");
            return null;
        } else {
            String producto = productos[cima].getNombre();
            cima--;
            return producto;
        }
    }

    public String verificarProducto() {
        if (estaVacia()) {
            System.out.println("Error: La tienda está vacía.");
            return null;
        } else {
            return productos[cima].getNombre();
        }
    }

    public boolean estaVacia() {
        return cima == -1;
    }

    public boolean estaLlena() {
        return cima == capacidad - 1;
    }

    public void mostrarProductos(JTextArea txtProductos) {
        if (estaVacia()) {
            System.out.println("La tienda está vacía.");
        } else {
            System.out.print("Contenido de la tienda: ");
            for (int i = cima; i >= 0; i--) {
                System.out.print(productos[i].getNombre() + " ($" + productos[i].getPrecio() + ") ");
            }
            System.out.println();
        }
    }
}

