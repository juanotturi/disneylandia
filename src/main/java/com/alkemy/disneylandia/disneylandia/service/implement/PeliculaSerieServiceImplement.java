package com.alkemy.disneylandia.disneylandia.service.implement;

import com.alkemy.disneylandia.disneylandia.dto.PeliculaSerieDto;
import com.alkemy.disneylandia.disneylandia.dto.PeliculaSerieFiltersDto;
import com.alkemy.disneylandia.disneylandia.entity.PeliculaSerieEntity;
import com.alkemy.disneylandia.disneylandia.mapper.PeliculaSerieMapper;
import com.alkemy.disneylandia.disneylandia.repository.PeliculaSerieRepository;
import com.alkemy.disneylandia.disneylandia.repository.specification.PeliculaSerieSpecification;
import com.alkemy.disneylandia.disneylandia.service.PeliculaSerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaSerieServiceImplement implements PeliculaSerieService {

    private PeliculaSerieRepository peliculaSerieRepository;
    private PeliculaSerieSpecification peliculaSerieSpecification;
    private PeliculaSerieMapper peliculaSerieMapper;

    @Autowired
    public PeliculaSerieServiceImplement(PeliculaSerieRepository peliculaSerieRepository, PeliculaSerieSpecification peliculaSerieSpecification, PeliculaSerieMapper peliculaSerieMapper) {
        this.peliculaSerieRepository = peliculaSerieRepository;
        this.peliculaSerieSpecification = peliculaSerieSpecification;
        this.peliculaSerieMapper = peliculaSerieMapper;
    }

    public PeliculaSerieDto save(PeliculaSerieDto dto) {
        PeliculaSerieEntity entity = peliculaSerieMapper.peliculaSerieDto2Entity(dto);
        PeliculaSerieEntity entitySaved = peliculaSerieRepository.save(entity);
        PeliculaSerieDto result = peliculaSerieMapper.peliculaSerieEntity2Dto(entitySaved, false);
        return dto;
    }

    public List<PeliculaSerieDto> getAllPeliculasSeries() {
        List<PeliculaSerieEntity> entities = peliculaSerieRepository.findAll();
        List<PeliculaSerieDto> result = peliculaSerieMapper.peliculaSerieEntityList2DtoList(entities, false);
        return result;
    }

    @Override
    public List<PeliculaSerieDto> getByFilters(String titulo, Long genero_id, String orden) {
        PeliculaSerieFiltersDto filtersDto = new PeliculaSerieFiltersDto(titulo, genero_id, orden);
        List<PeliculaSerieEntity> entities = peliculaSerieRepository.findAll(peliculaSerieSpecification.getByFilters(filtersDto));
        List<PeliculaSerieDto> dtos = peliculaSerieMapper.peliculaSerieEntityList2DtoList(entities, true);
        return dtos;
    }
}