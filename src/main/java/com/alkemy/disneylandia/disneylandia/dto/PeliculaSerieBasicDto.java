package com.alkemy.disneylandia.disneylandia.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class PeliculaSerieBasicDto {
    private String titulo;
    private String imagen;
    private LocalDate fechaCreacion;
}