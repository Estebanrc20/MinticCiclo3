package com.proyecto.examproyecto.controller;

import com.proyecto.examproyecto.entity.MovimientoDinero;
import com.proyecto.examproyecto.service.MovimientoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class MovimientoController {

    MovimientoService service;

    public MovimientoController(MovimientoService service) { this.service = service; }
    //controlador Get, retorna todos los campos(filas) de la tabla
    @GetMapping("/enterprises/movements")
    public List<MovimientoDinero> getMovimientos() { return this.service.getMovimientos(); }
    //Controlador Get con id especifico, retorna solo un campo(fila) de la tabla
    @GetMapping("enterprises/{id}/movements")
    public MovimientoDinero getMovimiento(@PathVariable("id") long id) { return this.service.getMovimiento(id); }
    //controlador Post, crea un campo(fila) en la tabla
    @PostMapping("enterprises/movements")
    public MovimientoDinero createMovimiento(@RequestBody MovimientoDinero movimientoDinero) { return this.service.createMovimiento(movimientoDinero); }
    //controlador Delete, elimina un campo(fila) en la tabla
    @DeleteMapping("enterprises/{id}/movements")
    public Boolean deleteMovimiento(@PathVariable("id") Long id) {
        return this.service.deleteMovimiento(id); }
    //controlador Put, actualiza un campo(fila) en la tabla. Actualiza todos los atributos, si un atributo no es mencionado se declara como null
    @PutMapping("enterprises/{id}/movements")
    public MovimientoDinero updateMovimientoDinero(@PathVariable("id") Long id, @RequestBody MovimientoDinero movimientoDinero) {
        return this.service.updateMovimiento(id,  movimientoDinero);
    }
    //controlador Patch, actualiza parcialmente uno o varios de los datos de la fila. Actualiza solo los atributos mencionados, los no mencionados se dejan como estaban
    @PatchMapping("enterprises/{id}/movements")
    public MovimientoDinero partialUpdateMovimiento(@PathVariable("id") Long id, @RequestBody Map<Object, Object> fields){
        return this.service.partialUpdateMovimiento(id, fields);
    }
}