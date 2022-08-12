package com.alkemy.disneylandia.disneylandia.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonajeDto {
    private Long id;
    private String nombre;
    private String imagen;
    private Long edad;
    private Long peso;
    private String historia;
}