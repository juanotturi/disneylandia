package com.alkemy.disneylandia.disneylandia.service.implement;

import com.alkemy.disneylandia.disneylandia.dto.PeliculaSerieDto;
import com.alkemy.disneylandia.disneylandia.dto.PeliculaSerieFiltersDto;
import com.alkemy.disneylandia.disneylandia.entity.PeliculaSerieEntity;
import com.alkemy.disneylandia.disneylandia.exception.ParamNotFound;
import com.alkemy.disneylandia.disneylandia.mapper.PeliculaSerieMapper;
import com.alkemy.disneylandia.disneylandia.repository.PeliculaSerieRepository;
import com.alkemy.disneylandia.disneylandia.repository.specification.PeliculaSerieSpecification;
import com.alkemy.disneylandia.disneylandia.service.PeliculaSerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        return result;
    }

    public List<PeliculaSerieDto> getAllPeliculasSeries() {
        List<PeliculaSerieEntity> entities = peliculaSerieRepository.findAll();
        List<PeliculaSerieDto> result = peliculaSerieMapper.peliculaSerieEntityList2DtoList(entities, false);
        return result;
    }

    @Override
    public List<PeliculaSerieDto> getByFilters(String titulo, Long generoId, String orden) {
        PeliculaSerieFiltersDto filtersDto = new PeliculaSerieFiltersDto(titulo, generoId, orden);
        List<PeliculaSerieEntity> entities = peliculaSerieRepository.findAll(peliculaSerieSpecification.getByFilters(filtersDto));
        List<PeliculaSerieDto> dtos = peliculaSerieMapper.peliculaSerieEntityList2DtoList(entities, true);
        return dtos;
    }

    public PeliculaSerieDto getDetailsById(Long id) {
        Optional<PeliculaSerieEntity> entity = peliculaSerieRepository.findById(id);
        if (!entity.isPresent()) {
            throw new ParamNotFound("ID película/serie no válido");
        }
        PeliculaSerieDto peliculaSerieDto = peliculaSerieMapper.peliculaSerieEntity2Dto(entity.get(), true);
        return peliculaSerieDto;
    }

//    @Override
//    public void addPersonaje(Long id, Long idPersonaje) {
//
//    }
}