package com.alkemy.disneylandia.disneylandia.mapper;

import com.alkemy.disneylandia.disneylandia.dto.PersonajeDto;
import com.alkemy.disneylandia.disneylandia.entity.PersonajeEntity;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonajeMapper {

    public PersonajeEntity personajeDto2Entity(PersonajeDto dto){
        PersonajeEntity personajeEntity = new PersonajeEntity();
        personajeEntity.setNombre(dto.getNombre());
        personajeEntity.setImagen(dto.getImagen());
        personajeEntity.setEdad(dto.getEdad());
        personajeEntity.setPeso(dto.getPeso());
        personajeEntity.setHistoria(dto.getHistoria());
        return personajeEntity;
    }

    public PersonajeDto personajeEntity2Dto(PersonajeEntity entity){
        PersonajeDto dto = new PersonajeDto();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setImagen(entity.getImagen());
        dto.setEdad(entity.getEdad());
        dto.setPeso(entity.getPeso());
        dto.setHistoria(entity.getHistoria());
        return dto;
    }

    public List<PersonajeDto> personajeEntityList2DtoList(List<PersonajeEntity> entities){
        List<PersonajeDto> dtos = new ArrayList<>();
        for (PersonajeEntity entity : entities){
            dtos.add(personajeEntity2Dto(entity));
        }
        return dtos;
    }
}