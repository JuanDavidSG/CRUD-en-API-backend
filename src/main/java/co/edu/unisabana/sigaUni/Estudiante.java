package co.edu.unisabana.sigaUni;

import java.util.Objects;

public class Estudiante {

    private int id;
    private String nombre;
    private int semestre;
    private String facultad;
    private String programa;

    public Estudiante(int id, String nombre, int semestre, String facultad, String programa) {
        this.id = id;
        this.nombre = nombre;
        this.semestre = semestre;
        this.facultad = facultad;
        this.programa = programa;
    }

    public Estudiante() {
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

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estudiante that = (Estudiante) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
