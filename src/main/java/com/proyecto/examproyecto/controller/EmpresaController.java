package com.proyecto.examproyecto.controller;

import com.proyecto.examproyecto.entity.Empresa;
import com.proyecto.examproyecto.service.EmpresaService;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

@RestController
public class EmpresaController {

    EmpresaService service;

    public EmpresaController(EmpresaService service) {
        this.service = service;
    }
    //controlador Get, retorna todos los campos(filas) de la tabla
    @GetMapping("/enterprises")
    public List<Empresa> getEmpresas() {
        return this.service.getEmpresas();
    }
    //Controlador Get con id especifico, retorna solo un campo(fila) de la tabla
    @GetMapping("/enterprises/{id}")
    public Empresa getEmpresa(@PathVariable("id") long id) {
        return this.service.getEmpresa(id);
    }
    //controlador Post, crea un campo(fila) en la tabla
    @PostMapping("/enterprises")
    public Empresa createEmpresa(@RequestBody Empresa empresa) {
        return this.service.createEmpresa(empresa);
    }
    //controlador Delete, elimina un campo(fila) en la tabla
    @DeleteMapping("/enterprises/{id}")
    public Boolean deleteEmpresa(@PathVariable("id") Long id){
        return this.service.deleteEmpresa(id);
    }

    //controlador Put, actualiza un campo(fila) en la tabla. Actualiza todos los atributos, si un atributo no es mencionado se declara como null
    @PutMapping("/enterprises/{id}")
    public Empresa updateEmpresa(@PathVariable("id") Long id, @RequestBody Empresa empresa){
        return this.service.updateEmpresa(id, empresa);
    }

    //controlador Patch, actualiza parcialmente uno o varios de los datos de la fila. Actualiza solo los atributos mencionados, los no mencionados se dejan como estaban
    @PatchMapping("/enterprises/{id}")
    public Empresa partialUpdateEmpresa(@PathVariable("id") Long id, @RequestBody Map<Object, Object> fields){
        return this.service.partialUpdateEmpresa(id, fields);
    }


}
