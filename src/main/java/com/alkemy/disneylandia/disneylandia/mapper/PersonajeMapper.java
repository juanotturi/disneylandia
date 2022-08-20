package com.alkemy.disneylandia.disneylandia.mapper;

import com.alkemy.disneylandia.disneylandia.dto.PeliculaSerieDto;
import com.alkemy.disneylandia.disneylandia.dto.PersonajeBasicDto;
import com.alkemy.disneylandia.disneylandia.dto.PersonajeDto;
import com.alkemy.disneylandia.disneylandia.entity.PersonajeEntity;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class PersonajeMapper {

    private PeliculaSerieMapper peliculaSerieMapper = new PeliculaSerieMapper();

    public PersonajeEntity personajeDto2Entity(PersonajeDto dto) {
        PersonajeEntity personajeEntity = new PersonajeEntity();
        personajeEntity.setNombre(dto.getNombre());
        personajeEntity.setImagen(dto.getImagen());
        personajeEntity.setEdad(dto.getEdad());
        personajeEntity.setPeso(dto.getPeso());
        personajeEntity.setHistoria(dto.getHistoria());
        return personajeEntity;
    }

    public PersonajeDto personajeEntity2Dto(PersonajeEntity entity, boolean loadPeliculasSeries) {
        PersonajeDto dto = new PersonajeDto();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setImagen(entity.getImagen());
        dto.setEdad(entity.getEdad());
        dto.setPeso(entity.getPeso());
        dto.setHistoria(entity.getHistoria());
        if (loadPeliculasSeries) {
            List<PeliculaSerieDto> peliculasSeriesDtos = peliculaSerieMapper.peliculaSerieEntityList2DtoList(entity.getPeliculasSeries(), false);
            dto.setPeliculasSeries(peliculasSeriesDtos);
        }
        return dto;
    }

    public Set<PersonajeEntity> personajeDtoList2Entity(List<PersonajeDto> dtos) {
        Set<PersonajeEntity> entities = new HashSet<>();
        for (PersonajeDto dto : dtos) {
            entities.add(personajeDto2Entity(dto));
        }
        return entities;
    }

    public List<PersonajeDto> personajeEntitySet2DtoList(Collection<PersonajeEntity> entities, boolean loadPeliculasSeries) {
        List<PersonajeDto> dtos = new ArrayList<>();
        for (PersonajeEntity entity : entities) {
            dtos.add(personajeEntity2Dto(entity, loadPeliculasSeries));
        }
        return dtos;
    }

    public List<PersonajeBasicDto> personajeEntitySet2BasicDtoList(Collection<PersonajeEntity> entities) {
        List<PersonajeBasicDto> dtos = new ArrayList<>();
        PersonajeBasicDto basicDto;
        for (PersonajeEntity entity : entities) {
            basicDto = new PersonajeBasicDto();
            basicDto.setId(entity.getId());
            basicDto.setNombre(entity.getNombre());
            basicDto.setImagen(entity.getImagen());
            dtos.add(basicDto);
        }
        return dtos;
    }

    public PersonajeEntity update(PersonajeEntity entity, PersonajeDto dto) {
        entity.setId(entity.getId());
        entity.setNombre(dto.getNombre());
        entity.setImagen(dto.getImagen());
        entity.setEdad(dto.getEdad());
        entity.setPeso(dto.getPeso());
        entity.setHistoria(dto.getHistoria());
        entity.getPeliculasSeries();
        return entity;
    }
}