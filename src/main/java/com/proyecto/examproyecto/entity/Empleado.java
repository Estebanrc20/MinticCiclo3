package com.proyecto.examproyecto.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

//en el modelo entidad-relacion user es la identificacion de tabla empleado
@Entity
@Table(name = "empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "nombre_empleado")
    private String nombreEmpleado;
    @Column(name = "documento")
    private int documento;
    @Column(name = "correo_empleado", unique = true)
    private String correoEmpleado;
    @Column(name = "rol")
    private String rol;

    @Column(name = "fecha_cr")
    private LocalDate fechaCr;
    @Column(name = "fecha_upd")
    private LocalDate fechaUpd;

    @Column(name = "estado")
    private boolean estado;

    @ManyToOne
    @JoinColumn(name = "empresa_id", referencedColumnName = "id")
    private Empresa empresa;

    @OneToOne
    @JoinColumn(name = "perfil_id", referencedColumnName = "id" )
    private Perfil perfil;

    @OneToMany(targetEntity = MovimientoDinero.class, mappedBy = "empleado", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<MovimientoDinero> movimientos;

    public Empleado(){
    }
    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public int getDocumento() { return documento; }

    public String getCorreoEmpleado() {
        return correoEmpleado;
    }

    public String getRol() {
        return rol;
    }

    public LocalDate getFechaCr() { return fechaCr; }

    public LocalDate getFechaUpd() { return fechaUpd; }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
            }

    public void setDocumento(int documento) {
        this.documento = documento;
        }

    public void setCorreoEmpleado(String correoEmpleado) {
        this.correoEmpleado = correoEmpleado;
            }

    public void setRol(String rol) {
        this.rol = rol;
            }

    public void setFechaCr(LocalDate fechaCr) {
        this.fechaCr = fechaCr;
    }

    public void setFechaUpd(LocalDate fechaUpd) {
        this.fechaUpd = fechaUpd;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @JsonBackReference
    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @JsonBackReference(value = "perfil-empleado")
    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public List<MovimientoDinero> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<MovimientoDinero> movimientos) {
        this.movimientos = movimientos;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", nombreEmpleado='" + nombreEmpleado + '\'' +
                ", documento=" + documento +
                ", correoEmpleado='" + correoEmpleado + '\'' +
                ", rol=" + rol +
                ", fechaCr=" + fechaCr +
                ", fechaUpd=" + fechaUpd +
                ", estado=" + estado +
                //", empresa=" + empresa.getId() +
                //", perfil=" + perfil +
                ", movimientos=" + movimientos +
                '}';
    }
}
