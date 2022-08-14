package com.alkemy.disneylandia.disneylandia.mapper;

import com.alkemy.disneylandia.disneylandia.dto.PeliculaSerieBasicDto;
import com.alkemy.disneylandia.disneylandia.dto.PeliculaSerieDto;
import com.alkemy.disneylandia.disneylandia.dto.PersonajeDto;
import com.alkemy.disneylandia.disneylandia.entity.PeliculaSerieEntity;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class PeliculaSerieMapper {

    private PersonajeMapper personajeMapper;

    public PeliculaSerieEntity peliculaSerieDto2Entity(PeliculaSerieDto dto){
        PeliculaSerieEntity peliculaSerieEntity = new PeliculaSerieEntity();
        peliculaSerieEntity.setTitulo(dto.getTitulo());
        peliculaSerieEntity.setImagen(dto.getImagen());
        peliculaSerieEntity.setCalificacion((long) dto.getCalificacion());
        return peliculaSerieEntity;
    }

    public PeliculaSerieDto peliculaSerieEntity2Dto(PeliculaSerieEntity entity, boolean loadPersonajes){
        PeliculaSerieDto dto = new PeliculaSerieDto();
        dto.setId(entity.getId());
        dto.setTitulo(entity.getTitulo());
        dto.setImagen(entity.getImagen());
        dto.setCalificacion(Math.toIntExact(entity.getCalificacion()));
        if(loadPersonajes){
            List<PersonajeDto> personajesDtos = personajeMapper.personajeEntitySet2DtoList(entity.getPersonajes(), false);
            dto.setPersonajes(personajesDtos);
        }
        return dto;
    }

    public List<PeliculaSerieDto> peliculaSerieEntityList2DtoList(List<PeliculaSerieEntity> entities, boolean loadPersonajes){
        List<PeliculaSerieDto> dtos = new ArrayList<>();
        for (PeliculaSerieEntity entity : entities){
            dtos.add(peliculaSerieEntity2Dto(entity, loadPersonajes));
        }
        return dtos;
    }

    public List<PeliculaSerieEntity> peliculaSerieDtoList2Entity(List<PeliculaSerieDto> dtos){
        List<PeliculaSerieEntity> entities = new ArrayList<>();
        for(PeliculaSerieDto dto : dtos){
            entities.add(peliculaSerieDto2Entity(dto));
        }
        return entities;
    }

    public List<PeliculaSerieBasicDto> peliculaSerieEntitySet2BasicDtoList(Collection<PeliculaSerieEntity> entities){
        List<PeliculaSerieBasicDto> dtos = new ArrayList<>();
        PeliculaSerieBasicDto basicDto;
        for (PeliculaSerieEntity entity : entities){
            basicDto = new PeliculaSerieBasicDto();
            basicDto.setId(entity.getId());
            basicDto.setTitulo(entity.getTitulo());
            basicDto.setImagen(entity.getImagen());
            basicDto.setFechaCreacion(entity.getFechaCreacion());
        }
        return dtos;
    }
}