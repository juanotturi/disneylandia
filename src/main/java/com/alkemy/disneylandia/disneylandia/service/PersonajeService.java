package com.alkemy.disneylandia.disneylandia.service;

import com.alkemy.disneylandia.disneylandia.dto.PersonajeBasicDto;
import com.alkemy.disneylandia.disneylandia.dto.PersonajeDto;

import java.util.List;
import java.util.Set;

public interface PersonajeService {

    PersonajeDto save(PersonajeDto dto);

    List<PersonajeDto> getAllPersonajes();

    void delete(Long id);

    PersonajeDto getDetailsById(Long id);

    List<PersonajeBasicDto> getByFilters(String nombre, Long edad, Long peso, Set<Long> peliculasSeries, String orden);

    PersonajeDto update(Long id, PersonajeDto personajeDto);
}