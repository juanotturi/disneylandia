package com.alkemy.disneylandia.disneylandia.mapper;

import com.alkemy.disneylandia.disneylandia.dto.GeneroDto;
import com.alkemy.disneylandia.disneylandia.entity.GeneroEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GeneroMapper {

    public GeneroEntity generoDto2Entity(GeneroDto dto){
        GeneroEntity generoEntity = new GeneroEntity();
        generoEntity.setImagen(dto.getImagen());
        generoEntity.setNombre(dto.getNombre());
        return generoEntity;
    }

    public GeneroDto generoEntity2Dto(GeneroEntity entity){
        GeneroDto dto = new GeneroDto();
        dto.setId(entity.getId());
        dto.setImagen(entity.getImagen());
        dto.setNombre(entity.getNombre());
        return dto;
    }

    public List<GeneroDto> generoEntityList2DtoList(List<GeneroEntity> entities){
        List<GeneroDto> dtos = new ArrayList<>();
        for (GeneroEntity entity : entities){
            dtos.add(generoEntity2Dto(entity));
        }
        return dtos;
    }
}