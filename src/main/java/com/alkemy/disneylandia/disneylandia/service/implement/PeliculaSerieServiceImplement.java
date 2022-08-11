package com.alkemy.disneylandia.disneylandia.service.implement;

import com.alkemy.disneylandia.disneylandia.dto.PeliculaSerieDto;
import com.alkemy.disneylandia.disneylandia.entity.PeliculaSerieEntity;
import com.alkemy.disneylandia.disneylandia.mapper.PeliculaSerieMapper;
import com.alkemy.disneylandia.disneylandia.repository.PeliculaSerieRepository;
import com.alkemy.disneylandia.disneylandia.service.PeliculaSerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PeliculaSerieServiceImplement implements PeliculaSerieService {

    @Autowired
    private PeliculaSerieMapper peliculaSerieMapper;
    @Autowired
    private PeliculaSerieRepository peliculaSerieRepository;

    public PeliculaSerieDto save(PeliculaSerieDto dto){
        PeliculaSerieEntity entity = peliculaSerieMapper.peliculaSerieDto2Entity(dto);
        PeliculaSerieEntity entitySaved = peliculaSerieRepository.save(entity);
        PeliculaSerieDto result = peliculaSerieMapper.peliculaSerieEntity2Dto(entitySaved);
        return dto;
    }

    public List<PeliculaSerieDto> getAllPeliculasSeries() {
        List<PeliculaSerieEntity> entities = peliculaSerieRepository.findAll();
        List<PeliculaSerieDto> result = peliculaSerieMapper.peliculaSerieEntityList2DtoList(entities);
        return result;
    }
}