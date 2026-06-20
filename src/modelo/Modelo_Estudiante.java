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
    public Estudiante agregar(String nombre,String carrera, double promedio){
        if (nombre == null || nombre.trim().isEmpty()){
            throw  new IllegalArgumentException("El nombre es obligatorio, no puede ir el campo vacio");
        }
        if (promedio < 1.0 || promedio > 7.0){
            throw new IllegalArgumentException("El promedio debe estar entre 1.0 y 7.0");
        }
        Estudiante e= new Estudiante(siguienteId,nombre.trim(),carrera.trim(), promedio);
        estudiantes.add(e);
        siguienteId++;
        return e;
    }

    // eliminar un estudiante
    public boolean eliminarPorId(int id){
        return  estudiantes.remove(id) != null;
        // return estudiantes.removeIf(e -> e.getId() == id)
    }

    //lista similar al select * from
    public List<Estudiante> obtenerEstudiantes(){
        return estudiantes;
    }

    //cantidad de alumnos
    public int cantidad(){
        return estudiantes.size();
    }
}
