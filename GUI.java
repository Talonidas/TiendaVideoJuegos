//La GUI de la clase trabajador.
package standard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    private JTextField serialField, stockField, nombreField, precioField, proveedorField;
    private JTextArea resultArea;
    private Producto[] productosTemp = new Producto[10]; // Fixed array instead of ArrayList
    private int productCount = 0;
    private Trabajador trabajador;

    public GUI() throws EValorNulo, EObjetoNoEncontrado, EValidacionVariable{        
        setTitle("Productos");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Form panel
        JPanel formPanel = new JPanel(new GridLayout(5, 2));
        
        // (Optional: Initialize your JTextFields here and add them to formPanel)
        serialField = new JTextField();
        stockField = new JTextField();
        nombreField = new JTextField();
        precioField = new JTextField();
        proveedorField = new JTextField();
        
        formPanel.add(new JLabel("Serial:"));
        formPanel.add(serialField);
        formPanel.add(new JLabel("Stock:"));
        formPanel.add(stockField);
        formPanel.add(new JLabel("Nombre:"));
        formPanel.add(nombreField);
        formPanel.add(new JLabel("Precio:"));
        formPanel.add(precioField);
        formPanel.add(new JLabel("Proveedor:"));
        formPanel.add(proveedorField);
        
        // Buttons panel
        JPanel panelBoton = new JPanel(new FlowLayout());
        JButton addButton = new JButton("Agregar");
        JButton findButton = new JButton("Buscar");
        JButton botonCalc = new JButton("Calcular");
        JButton botonVender = new JButton("Vender");
        panelBoton.add(addButton);
        panelBoton.add(findButton);
        panelBoton.add(botonCalc);
        panelBoton.add(botonVender);
        
        // Results area
        resultArea = new JTextArea(8, 30);
        resultArea.setEditable(false);
        
        // Layout
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(panelBoton, BorderLayout.CENTER);
        mainPanel.add(new JScrollPane(resultArea), BorderLayout.SOUTH);
        add(mainPanel);

        // Calculate button functionality
        botonCalc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (productCount > 0) {
                    Producto[] array = new Producto[productCount];
                    System.arraycopy(productosTemp, 0, array, 0, productCount);
                    double total = Trabajador.calcularPrecios(array);
                    resultArea.append("Precio total: $" + total + "\n");
                } else {
                    resultArea.append("No hay productos\n");
                }
            }
        });
        
        // Sell button functionality
        botonVender.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) throws EValorNulo, EObjetoNoEncontrado, EValorNegativo{
                if (productCount > 0) {

                        Producto[] array = new Producto[productCount];
                        System.arraycopy(productosTemp, 0, array, 0, productCount);
                        Trabajador.venderProductos(array);
                        resultArea.append("Venta completada: " + productCount + " productos\n");
                        productCount = 0; // Reset counter
                }else {
                    resultArea.append("No hay productos\n");
                }
            }
        });
    }
}

// Exception classes if needed
class ENoEncontrado extends Exception {
    public ENoEncontrado(String id) {
        super("Producto " + id + " no encontrado");
    }
}

class EValorNegativo extends Exception {
    public EValorNegativo() {
        super("Valor negativo no permitido");
    }
}
