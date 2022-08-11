package com.alkemy.disneylandia.disneylandia.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
public class PeliculaSerieDto {
    private Long id;
    private String titulo;
    private String imagen;
    private DateTimeFormat fechaCreacion;
    private int calificacion;
}