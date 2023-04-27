package com.pfcti.sprint.challenge.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name= "CLIENTE")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "identificacion")
    private  String identificacion;
    @Column(name = "nombres")
    private String nombres;
    @Column(columnDefinition = "varchar(15)")
    private String apellidos;
    @Column(name = "PAIS_RECIDENCIA")
    private String paisRecidencia;
    @Column(name = "PAIS_NACIMIENTO")
    private String paisNacimiento;
    @Column
    private String telefono;
    @Column
    private String direccion;
    @Column
    private Boolean estado;

}
