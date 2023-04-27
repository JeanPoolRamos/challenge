package com.pfcti.sprint.challenge.dto;

import lombok.Data;

import java.util.List;

@Data
public class ClienteDto {

    private int id;
    private String identificacion;
    private String nombres;
    private String apellidos;
    private String paisRecidencia;
    private String paisNacimiento;
    private String telefono;
    private Boolean estado;



}
