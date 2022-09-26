package com.proyecto.examproyecto.controller;

import com.proyecto.examproyecto.entity.Empleado;
import com.proyecto.examproyecto.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class UsuarioController {
    UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }
    //controlador Get, retorna todos los campos(filas) de la tabla
    @GetMapping("/users")
    public List<Empleado> getUsuarios() {
        return this.service.getUsuarios();
    }
    //Controlador Get con id especifico, retorna solo un campo(fila) de la tabla
    @GetMapping("/users/{id}")
    public Empleado getUsuario(@PathVariable("id") long id) {
        return this.service.getUsuario(id);
    }
    //controlador Post, crea un campo(fila) en la tabla
    @PostMapping("/users")
    public Empleado createUsuario(@RequestBody Empleado empleado) {
        return this.service.createUsuario(empleado);
    }
    //controlador Delete, elimina un campo(fila) en la tabla
    @DeleteMapping("/users/{id}")
    public Boolean deleteUsuario(@PathVariable("id") Long id){
        return this.service.deleteUsuario(id);
    }

    //controlador Put, actualiza un campo(fila) en la tabla. Actualiza todos los atributos, si un atributo no es mencionado se declara como null
    @PutMapping("/users/{id}")
    public Empleado updateUsuario(@PathVariable("id") Long id, @RequestBody Empleado empleado){
        return this.service.updateUsuario(id, empleado);
    }

    //controlador Patch, actualiza parcialmente uno o varios de los datos de la fila. Actualiza solo los atributos mencionados, los no mencionados se dejan como estaban
    @PatchMapping("/users/{id}")
    public Empleado partialUpdateUsuario(@PathVariable("id") Long id, @RequestBody Map<Object, Object> fields){
        return this.service.partialUpdateUsuario(id, fields);
    }
}
