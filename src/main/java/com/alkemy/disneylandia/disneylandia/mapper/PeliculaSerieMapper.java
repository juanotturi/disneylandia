package com.alkemy.disneylandia.disneylandia.mapper;

import com.alkemy.disneylandia.disneylandia.dto.GeneroDto;
import com.alkemy.disneylandia.disneylandia.dto.PeliculaSerieDto;
import com.alkemy.disneylandia.disneylandia.entity.GeneroEntity;
import com.alkemy.disneylandia.disneylandia.entity.PeliculaSerieEntity;
import com.alkemy.disneylandia.disneylandia.service.PeliculaSerieService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PeliculaSerieMapper {

    public PeliculaSerieEntity peliculaSerieDto2Entity(PeliculaSerieDto dto){
        PeliculaSerieEntity peliculaSerieEntity = new PeliculaSerieEntity();
        peliculaSerieEntity.setTitulo(dto.getTitulo());
        peliculaSerieEntity.setImagen(dto.getImagen());
        peliculaSerieEntity.setCalificacion((long) dto.getCalificacion());
        return peliculaSerieEntity;
    }

    public PeliculaSerieDto peliculaSerieEntity2Dto(PeliculaSerieEntity entity){
        PeliculaSerieDto dto = new PeliculaSerieDto();
        dto.setId(entity.getId());
        dto.setTitulo(entity.getTitulo());
        dto.setImagen(entity.getImagen());
        dto.setCalificacion(Math.toIntExact(entity.getCalificacion()));
        return dto;
    }

    public List<PeliculaSerieDto> peliculaSerieEntityList2DtoList(List<PeliculaSerieEntity> entities){
        List<PeliculaSerieDto> dtos = new ArrayList<>();
        for (PeliculaSerieEntity entity : entities){
            dtos.add(peliculaSerieEntity2Dto(entity));
        }
        return dtos;
    }
}