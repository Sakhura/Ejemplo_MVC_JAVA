package controlador;

import modelo.Estudiante;
import modelo.ModeloEstudiantes;
import vista.VistaPrincipal;

import java.util.List;

/**
 * CONTROLADOR: el intermediario.
 *
 * Es la UNICA clase que conoce al Modelo Y a la Vista al mismo tiempo.
 * Su trabajo:
 *  1. Escuchar las acciones del usuario (clicks en la Vista).
 *  2. Pedirle al Modelo que haga el trabajo (agregar, eliminar, etc.).
 *  3. Pedirle a la Vista que muestre el resultado.
 *
 * Asi, ni el Modelo ni la Vista dependen el uno del otro:
 * todo pasa por aqui.
 */
public class Controlador {

    private final ModeloEstudiantes modelo;
    private final VistaPrincipal vista;

    public Controlador(ModeloEstudiantes modelo, VistaPrincipal vista) {
        this.modelo = modelo;
        this.vista = vista;

        // Conectamos los botones de la Vista con metodos de esta clase.
        // Usamos lambdas: cada vez que se presione el boton, se ejecuta el metodo.
        this.vista.agregarListenerAgregar(e -> agregarEstudiante());
        this.vista.agregarListenerEliminar(e -> eliminarEstudiante());

        // Mostramos el estado inicial.
        refrescarTabla();
    }

    /** Se ejecuta al presionar "Agregar". */
    private void agregarEstudiante() {
        try {
            String nombre = vista.getNombre();
            String carrera = vista.getCarrera();
            // Convertir el texto a numero puede fallar: lo controlamos.
            double promedio = Double.parseDouble(vista.getPromedio().replace(",", "."));

            modelo.agregar(nombre, carrera, promedio);

            refrescarTabla();
            vista.limpiarFormulario();
            vista.mostrarMensaje("Estudiante agregado correctamente.");
        } catch (NumberFormatException ex) {
            vista.mostrarError("El promedio debe ser un numero (ej: 5.8).");
        } catch (IllegalArgumentException ex) {
            // Estas son las reglas de negocio que lanzo el Modelo.
            vista.mostrarError(ex.getMessage());
        }
    }

    /** Se ejecuta al presionar "Eliminar seleccionado". */
    private void eliminarEstudiante() {
        int id = vista.getIdSeleccionado();
        if (id == -1) {
            vista.mostrarError("Selecciona primero una fila en la tabla.");
            return;
        }
        modelo.eliminarPorId(id);
        refrescarTabla();
    }

    /** Pide los datos al Modelo y le dice a la Vista que los pinte. */
    private void refrescarTabla() {
        vista.limpiarTabla();
        List<Estudiante> lista = modelo.obtenerTodos();
        for (Estudiante e : lista) {
            vista.agregarFila(e.getId(), e.getNombre(), e.getCarrera(), e.getPromedio());
        }
    }
}