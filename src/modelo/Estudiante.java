package modelo;

public class Estudiante {
    //declaracion tipo atributo+ tipo dato+ nombre_variable
    private int id;
    private String nombre;
    private String apellido;
    private double notas;

    public Estudiante(int id, String nombre, String apellido, double notas) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.notas = notas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public double getNotas() {
        return notas;
    }

    public void setNotas(double notas) {
        this.notas = notas;
    }
    @Override
    public String toString() {
        return id + " - " + nombre + " - " + apellido + " - " + notas;
    }
}