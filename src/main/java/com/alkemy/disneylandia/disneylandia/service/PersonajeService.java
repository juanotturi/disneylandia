package com.alkemy.disneylandia.disneylandia.service;

import com.alkemy.disneylandia.disneylandia.dto.PersonajeDto;

import java.util.List;

public interface PersonajeService {

    PersonajeDto save(PersonajeDto dto);

    List<PersonajeDto> getAllPersonajes();
}