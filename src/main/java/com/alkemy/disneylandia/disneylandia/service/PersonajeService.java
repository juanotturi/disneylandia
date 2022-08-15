package com.alkemy.disneylandia.disneylandia.service;

import com.alkemy.disneylandia.disneylandia.dto.PersonajeDto;

import java.util.List;
import java.util.Set;

public interface PersonajeService {

    PersonajeDto save(PersonajeDto dto);

    List<PersonajeDto> getAllPersonajes();

    void delete(Long id);

    PersonajeDto getDetailsById(Long id);

    List<PersonajeDto> getByFilters(String nombre, Long edad, Long peso, Set<Long> peliculasSeries, String orden);
}