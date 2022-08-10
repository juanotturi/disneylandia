package com.alkemy.disneylandia.disneylandia.service.implement;

import com.alkemy.disneylandia.disneylandia.dto.GeneroDto;
import com.alkemy.disneylandia.disneylandia.entity.GeneroEntity;
import com.alkemy.disneylandia.disneylandia.mapper.GeneroMapper;
import com.alkemy.disneylandia.disneylandia.repository.GeneroRepository;
import com.alkemy.disneylandia.disneylandia.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroServiceImplement implements GeneroService {

    @Autowired
    private GeneroMapper generoMapper;
    @Autowired
    private GeneroRepository generoRepository;

    public GeneroDto save(GeneroDto dto){
        GeneroEntity entity = generoMapper.generoDto2Entity(dto);
        GeneroEntity entitySaved = generoRepository.save(entity);
        GeneroDto result = generoMapper.generoEntity2Dto(entitySaved);
        return result;
    }

    public List<GeneroDto> getAllGeneros() {
        List<GeneroEntity> entities = generoRepository.findAll();
        List<GeneroDto> result = generoMapper.generoEntityList2DtoList(entities);
        return result;
    }
}