import controlador.Controlador;
import modelo.Modelo_Estudiante;
import vista.Vista_Principal;

import javax.swing.SwingUtilities;

/**
 * PUNTO DE ENTRADA de la aplicacion.
 *
 * Aquí se "arma" el patron MVC: se crean las tres piezas y se conectan.
 * Fijarse en el orden:
 *  1. Se crea el Modelo (datos + logica).
 *  2. Se crea la Vista (interfaz).
 *  3. Se crea el Controlador, pasandole Modelo y Vista para que los una.
 *  4. Se muestra la ventana.
 */
public class Main {
    public static void main(String[] args) {
        // SwingUtilities.invokeLater asegura que la interfaz se construya
        // en el hilo correcto de Swing (buena práctica).
        SwingUtilities.invokeLater(() -> {
            Modelo_Estudiante modelo = new Modelo_Estudiante();
            Vista_Principal vista = new Vista_Principal();
            new Controlador(modelo, vista);
            vista.setVisible(true);
        });
    }
}