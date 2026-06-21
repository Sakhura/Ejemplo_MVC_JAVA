package modelo;

import java.util.ArrayList;
import java.util.List;


public class Modelo_Estudiante {

    private final List<Estudiante> estudiantes;
    private int siguienteId;

    public Modelo_Estudiante() {
        this.estudiantes = new ArrayList<>();
        this.siguienteId = 1;
    }

    // insertar estudiante
    public Estudiante agregar(String nombre, String apellido, double nota) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre es obligatorio, no puede ir el campo vacio");
        }
        if (nota < 1.0 || nota > 7.0) {
            throw new IllegalArgumentException("La nota debe estar entre 1.0 y 7.0");
        }
        Estudiante e = new Estudiante(siguienteId, nombre.trim(), apellido.trim(), nota);
        estudiantes.add(e);
        siguienteId++;
        return e;
    }

    // eliminar un estudiante por su id (no por su posicion en la lista)
    public boolean eliminarPorId(int id) {
        return estudiantes.removeIf(e -> e.getId() == id);
    }

    // lista similar al select * from
    public List<Estudiante> obtenerEstudiantes() {
        return estudiantes;
    }

    // cantidad de alumnos
    public int cantidad() {
        return estudiantes.size();
    }
}