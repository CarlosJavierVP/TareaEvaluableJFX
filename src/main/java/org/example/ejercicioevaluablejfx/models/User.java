package org.example.ejercicioevaluablejfx.models;

import lombok.Data;

import java.time.LocalDate;

@Data
public class User {
    private String correo;
    private String plataforma;
    private Integer versionSoftware;
    private String administrador;
    private LocalDate fechaRegistro;


}
