package com.proyecto.examproyecto.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "perfil")
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "imagen")
    private String imagen;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "pass")
    private String pass;
    @Column(name = "fecha_cr")
    private LocalDate fechaCr;
    @Column(name = "fecha_upd")
    private LocalDate fechaUpd;

    @OneToOne(targetEntity = Empleado.class, mappedBy = "perfil", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Empleado empleado;

    public Perfil(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public LocalDate getFechaCr() {
        return fechaCr;
    }

    public void setFechaCr(LocalDate fechaCr) {
        this.fechaCr = fechaCr;
    }

    public LocalDate getFechaUpd() {
        return fechaUpd;
    }

    public void setFechaUpd(LocalDate fechaUpd) {
        this.fechaUpd = fechaUpd;
    }

    @JsonManagedReference(value = "perfil-empleado")
    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @Override
    public String toString() {
        return "Perfil{" +
                "id=" + id +
                ", imagen='" + imagen + '\'' +
                ", telefono='" + telefono + '\'' +
                ", pass='" + pass + '\'' +
                ", fechaCr=" + fechaCr +
                ", fechaUpd=" + fechaUpd +
                ", empleado=" + empleado +
                '}';
    }
}
