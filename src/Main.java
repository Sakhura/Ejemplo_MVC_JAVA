import controlador.Controlador;
import modelo.Modelo_Estudiante;
import vista.VistaPrincipal;

import javax.swing.SwingUtilities;

/**
 * PUNTO DE ENTRADA de la aplicacion.
 *
 * Aqui se "arma" el patron MVC: se crean las tres piezas y se conectan.
 * Fijarse en el orden:
 *  1. Se crea el Modelo (datos + logica).
 *  2. Se crea la Vista (interfaz).
 *  3. Se crea el Controlador, pasandole Modelo y Vista para que los una.
 *  4. Se muestra la ventana.
 */
public class Main {
    public static void main(String[] args) {
        // SwingUtilities.invokeLater asegura que la interfaz se construya
        // en el hilo correcto de Swing (buena practica).
        SwingUtilities.invokeLater(() -> {
            Modelo_Estudiante modelos = new Modelo_Estudiante();
            VistaPrincipal vista = new VistaPrincipal();
            new Controlador(modelos, vista);
            vista.setVisible(true);
        });
    }
}