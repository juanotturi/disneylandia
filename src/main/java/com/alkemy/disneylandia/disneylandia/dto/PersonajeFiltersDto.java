package com.alkemy.disneylandia.disneylandia.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class PersonajeFiltersDto {
    private String nombre;
    private Long edad;
    private Long peso;
    private Set<Long> peliculasSeries;
    private String orden;

    public PersonajeFiltersDto(String nombre, Long edad, Long peso, Set<Long> peliculasSeries, String orden) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.peliculasSeries = peliculasSeries;
        this.orden = orden;
    }

    public boolean isAsc() {
        return orden.compareToIgnoreCase("ASC") == 0;
    }

    public boolean isDesc() {
        return orden.compareToIgnoreCase("DESC") == 0;
    }
}