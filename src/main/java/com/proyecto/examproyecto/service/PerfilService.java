package com.proyecto.examproyecto.service;

import com.proyecto.examproyecto.entity.Perfil;
import com.proyecto.examproyecto.repository.PerfilRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PerfilService {
    private PerfilRepository repository;

    public PerfilService(PerfilRepository perfilRepository){
        this.repository = perfilRepository;
    }

    //Servicio para el controlador Get, retorna todos los campos(filas) de la tabla
    public List<Perfil> getPerfiles(){
        return this.repository.findAll();}
    //Servicio para el controlador Get con id especifico, retorna solo un campo(fila) de la tabla
    public Perfil getPerfil(long id){
        Optional<Perfil> perfil = this.repository.findById(id);
        return perfil.orElse(null);
    }

    //Servicio para el controlador Post, crea un campo(fila) en la tabla
    public Perfil createPerfil(Perfil perfil){
        return this.repository.save(perfil);
    }

    //servicio para el controlador Delete, elimina un campo(fila) en la tabla
    public Boolean deletePerfil(Long id){
        try{
            this.repository.deleteById(id);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    //servicio para el controlador Put, actualiza un campo(fila) en la tabla. Actualiza todos los valores.
    public Perfil updatePerfil(Long id, Perfil perfil){
        Optional<Perfil> dbData = this.repository.findById(id);

        if(dbData.isPresent()){
            Perfil e = dbData.get();
            e.setImagen(perfil.getImagen());
            e.setFechaCr(perfil.getFechaCr());
            e.setFechaUpd(perfil.getFechaUpd());
            e.setPass(perfil.getPass());
            e.setTelefono(perfil.getTelefono());
            this.repository.save(e);
            return e;
        }

        return null;
    }

    //servicio para controlador Patch
    public Perfil partialUpdatePerfil(Long id, Map<Object, Object> fields){
        Optional<Perfil> dbData = this.repository.findById(id);

        if(dbData.isPresent()){
            fields.forEach((key,value) ->{
                Field field = ReflectionUtils.findField(Perfil.class, (String) key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, dbData.get(), value);
            });
            Perfil e = dbData.get();
            this.repository.save(e);
            return e;

        }
        return null;

    }
}
