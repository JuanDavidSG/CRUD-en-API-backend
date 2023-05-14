package co.edu.unisabana.sigaUni;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    List<Estudiante> estudianteList;

    public Controller() {
        this.estudianteList = new ArrayList<>();
        estudianteList.add(new Estudiante(2525, "Daniel", 3, "Ingenieria", "Ingenieria Informática"));
        estudianteList.add(new Estudiante(3030, "Samuel", 5, "Medicina", "Enfermería"));
        estudianteList.add(new Estudiante(1234, "Andrea", 4, "Ingenieria", "Ingenieria Informática"));
        estudianteList.add(new Estudiante(4321, "Jaime", 3, "Comunicación", "Comunicación Social"));
        estudianteList.add(new Estudiante(9876, "Fulanita", 7, "Derecho", "Filosofía"));
    }

    @GetMapping(path = "/estudiantes")
    public List<Estudiante> obtenerEstudiantesPorFacultad(@RequestParam String facultad) {
        List<Estudiante> busqueda = new ArrayList<>();
        for (Estudiante estudiante : estudianteList) {
            if (estudiante.getFacultad().equals(facultad)) {
                busqueda.add(estudiante);
            }
        }
        return busqueda;
    }

    @GetMapping(path = "/estudiantes/todos")
    public List<Estudiante> obtenerEstudiantes() {
        return estudianteList;
    }


    @PostMapping(path = "/estudiante/crear")
    public Respuesta crearEstudiante(@RequestBody Estudiante estudiante) {
        estudiante.setId((int) (Math.random() * 1000));
        estudianteList.add(estudiante);
        return new Respuesta("Estudiante ingresado correctamente");
    }

    @DeleteMapping(path = "/estudiante/eliminar/{id}")
    public Respuesta eliminarEstudiante(@PathVariable int id) {
        boolean eliminado = estudianteList.removeIf(estudiante -> estudiante.getId() == id);
        if (eliminado) {
            return new Respuesta("Estudiante eliminado correctamente");
        } else {
            return new Respuesta("No se encontró ningún estudiante con el ID proporcionado, intente nuevamente");
        }
    }

    @PutMapping(path = "estudiante/editar/{id}")
    public Respuesta editarEstudiante(@PathVariable int id, @RequestBody Estudiante estudianteActualizado) {
        for (Estudiante estudiante : estudianteList) {
            if (estudiante.getId() == id) {
                estudiante.setNombre(estudianteActualizado.getNombre());
                estudiante.setSemestre(estudianteActualizado.getSemestre());
                estudiante.setFacultad(estudianteActualizado.getFacultad());
                estudiante.setPrograma(estudianteActualizado.getPrograma());
                return new Respuesta("El estudiante se ha editado :) ");
            }
        }
        return new Respuesta("No se encontró ningún estudiante con el ID proporcionado, intente nuevamente ");
    }


}
