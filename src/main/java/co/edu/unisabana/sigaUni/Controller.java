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


}
