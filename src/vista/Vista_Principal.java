package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * VISTA: todo lo visual (la ventana, campos, botones, tabla).
 *
 * Reglas importantes para los alumnos:
 *  - La Vista NO contiene reglas de negocio.
 *  - La Vista NO conoce al Modelo. No importa nada del paquete modelo.
 *  - Solo expone:
 *      * componentes / metodos para LEER lo que el usuario escribio,
 *      * metodos para MOSTRAR datos (pintar la tabla, mostrar mensajes),
 *      * metodos para que el Controlador "escuche" los botones.
 *
 * El Controlador sera quien decida que hacer cuando se presiona un boton.
 */
public class Vista_Principal extends JFrame {

    private final JTextField campoNombre = new JTextField(15);
    private final JTextField campoCarrera = new JTextField(15);
    private final JTextField campoPromedio = new JTextField(5);

    private final JButton botonAgregar = new JButton("Agregar");
    private final JButton botonEliminar = new JButton("Eliminar seleccionado");

    private final DefaultTableModel modeloTabla =
            new DefaultTableModel(new String[]{"ID", "Nombre", "Carrera", "Promedio"}, 0) {
                @Override
                public boolean isCellEditable(int fila, int columna) {
                    return false; // la tabla es solo de lectura
                }
            };
    private final JTable tabla = new JTable(modeloTabla);

    public Vista_Principal() {
        super("Gestion de Estudiantes - Ejemplo MVC");
        construirInterfaz();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null); // centrar en pantalla
    }

    private void construirInterfaz() {
        // Panel superior: formulario de ingreso
        JPanel panelFormulario = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelFormulario.add(new JLabel("Nombre:"));
        panelFormulario.add(campoNombre);
        panelFormulario.add(new JLabel("Carrera:"));
        panelFormulario.add(campoCarrera);
        panelFormulario.add(new JLabel("Promedio:"));
        panelFormulario.add(campoPromedio);
        panelFormulario.add(botonAgregar);

        // Panel inferior: boton eliminar
        JPanel panelAcciones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelAcciones.add(botonEliminar);

        // Tabla central con scroll
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setPreferredSize(new Dimension(560, 220));

        setLayout(new BorderLayout(10, 10));
        add(panelFormulario, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        add(panelAcciones, BorderLayout.SOUTH);
    }

    // ----- Metodos para que el CONTROLADOR conecte los botones -----
    // Recibimos un ActionListener desde afuera y se lo pasamos al boton.

    public void agregarListenerAgregar(java.awt.event.ActionListener listener) {
        botonAgregar.addActionListener(listener);
    }

    public void agregarListenerEliminar(java.awt.event.ActionListener listener) {
        botonEliminar.addActionListener(listener);
    }

    // ----- Metodos para LEER lo que escribio el usuario -----

    public String getNombre() {
        return campoNombre.getText();
    }

    public String getCarrera() {
        return campoCarrera.getText();
    }

    public String getPromedio() {
        return campoPromedio.getText();
    }

    /**
     * Devuelve el ID del estudiante seleccionado en la tabla,
     * o -1 si no hay ninguna fila seleccionada.
     */
    public int getIdSeleccionado() {
        int fila = tabla.getSelectedRow();
        if (fila == -1) {
            return -1;
        }
        return (int) modeloTabla.getValueAt(fila, 0);
    }

    // ----- Metodos para MOSTRAR informacion -----

    public void limpiarFormulario() {
        campoNombre.setText("");
        campoCarrera.setText("");
        campoPromedio.setText("");
        campoNombre.requestFocus();
    }

    /** Borra la tabla y la vuelve a llenar fila por fila. */
    public void agregarFila(int id, String nombre, String carrera, double promedio) {
        modeloTabla.addRow(new Object[]{id, nombre, carrera, promedio});
    }

    public void limpiarTabla() {
        modeloTabla.setRowCount(0);
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
}