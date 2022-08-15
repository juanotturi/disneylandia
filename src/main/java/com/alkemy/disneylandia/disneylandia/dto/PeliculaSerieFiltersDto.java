package com.alkemy.disneylandia.disneylandia.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PeliculaSerieFiltersDto {
    private String titulo;
    private Long generoId;
    private String orden;

    public PeliculaSerieFiltersDto(String titulo, Long generoId, String orden) {
        this.titulo = titulo;
        this.generoId = generoId;
        this.orden = orden;
    }

    public boolean isAsc() {
        return this.orden.compareToIgnoreCase("ASC") == 0;
    }

    public boolean isDesc() {
        return this.orden.compareToIgnoreCase("DESC") == 0;
    }
}