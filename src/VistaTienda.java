import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VistaTienda extends JFrame {
    private Tienda tienda;
    private JTextField txtNombre;
    private JTextField txtPrecio;
    private JTextArea txtProductos;
    private JButton btnAgregar;
    private JButton btnEliminar;
    private JButton btnMostrar;
    private JButton btnSalir;

    public VistaTienda(Tienda tienda) {
        this.tienda = tienda;
        setTitle("Tienda");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Panel para agregar producto
        JPanel panelAgregar = new JPanel();
        panelAgregar.add(new JLabel("Nombre:"));
        txtNombre = new JTextField(20);
        panelAgregar.add(txtNombre);
        panelAgregar.add(new JLabel("Precio:"));
        txtPrecio = new JTextField(10);
        panelAgregar.add(txtPrecio);
        btnAgregar = new JButton("Agregar");
        btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarProducto();
            }
        });
        panelAgregar.add(btnAgregar);
        panel.add(panelAgregar);

        // Panel para eliminar producto
        JPanel panelEliminar = new JPanel();
        btnEliminar = new JButton("Eliminar último producto");
        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eliminarProducto();
            }
        });
        panelEliminar.add(btnEliminar);
        panel.add(panelEliminar);

        // Panel para mostrar productos
        JPanel panelMostrar = new JPanel();
        btnMostrar = new JButton("Mostrar todos los productos");
        btnMostrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarProductos();
            }
        });
        panelMostrar.add(btnMostrar);
        txtProductos = new JTextArea(10, 30);
        txtProductos.setEditable(false);
        panelMostrar.add(new JScrollPane(txtProductos));
        panel.add(panelMostrar);

        // Panel para salir
        JPanel panelSalir = new JPanel();
        btnSalir = new JButton("Salir");
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        panelSalir.add(btnSalir);
        panel.add(panelSalir);

        add(panel);
        setVisible(true);
    }

    private void agregarProducto() {
        String nombre = txtNombre.getText();
        double precio = Double.parseDouble(txtPrecio.getText());
        tienda.agregarProducto(nombre, precio);
        txtNombre.setText("");
        txtPrecio.setText("");
    }

    private void eliminarProducto() {
        String productoEliminado = tienda.eliminarProducto();
        if (productoEliminado != null) {
            JOptionPane.showMessageDialog(this, "Producto eliminado: " + productoEliminado);
        } else {
            JOptionPane.showMessageDialog(this, "Error: La tienda está vacía.");
        }
    }

    private void mostrarProductos() {
        txtProductos.setText("");
        tienda.mostrarProductos(txtProductos);
    }
    public static void main(String[] args) {
        Tienda tienda = new Tienda(10);
        new VistaTienda(tienda);
    }
}



    

