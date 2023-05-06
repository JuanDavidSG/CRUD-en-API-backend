package co.edu.unisabana.sigaUni;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    List<Estudiante> estudianteList;

    public Controller() {
        this.estudianteList = new ArrayList<>();
        estudianteList.add(new Estudiante(2525, "Daniel", 3, "Ingenieria"));
        estudianteList.add(new Estudiante(3030, "Samuel", 5, "Medicina"));
        estudianteList.add(new Estudiante(1234, "Andrea", 4, "Ingenieria"));
        estudianteList.add(new Estudiante(4321, "Jaime", 3, "Arquitectura"));
        estudianteList.add(new Estudiante(9876, "Fulanita", 7, "Medicina"));
    }

    @GetMapping(path = "/estudiantes")
    public List<Estudiante> obtenerEstudiantesPorFacultad (@RequestParam String facultad, @RequestParam(required = false) Integer cantidad) {
        List<Estudiante> busqueda = new ArrayList<>();
        int contador = 0;
        for (Estudiante estudiante : estudianteList) {
            if (estudiante.getFacultad().equals(facultad)) {
                busqueda.add(estudiante);
                contador++;
                if (cantidad != null && contador >= cantidad) {
                    break;
                }
            }
        }
        return busqueda;
    }


    @GetMapping(path = "/estudiantes/todos")
    public List<Estudiante> obtenerEstudiantes() {
        return estudianteList;
    }


    @PostMapping(path = "/estudiante/crear")
    public String crearEstudiante(@RequestBody Estudiante estudiante) {
        estudiante.setId((int) (Math.random() * 1000));
        estudianteList.add(estudiante);
        return "Estudiante ingresado correctamente";
    }

    @DeleteMapping(path = "/estudiante/eliminar/{id}")
    public String eliminarEstudiante(@PathVariable int id) {
        boolean eliminado = estudianteList.removeIf(estudiante -> estudiante.getId() == id);
        if (eliminado) {
            return "El estudiante se ha eliminado";
        } else {
            return "No se encontró ningún estudiante con el ID proporcionado, intente nuevamente";
        }
    }

    @PutMapping(path = "estudiante/editar/{id}")
    public String editarEstudiante(@PathVariable int id, @RequestBody Estudiante estudianteActualizado) {
        for (Estudiante estudiante : estudianteList) {
            if (estudiante.getId() == id) {
                estudiante.setNombre(estudianteActualizado.getNombre());
                estudiante.setSemestre(estudianteActualizado.getSemestre());
                estudiante.setFacultad(estudianteActualizado.getFacultad());
                return "El estudiante se ha editado :) ";
            }
        }
        return "No se encontró ningún estudiante con el ID proporcionado, intente nuevamente ";
    }




}
