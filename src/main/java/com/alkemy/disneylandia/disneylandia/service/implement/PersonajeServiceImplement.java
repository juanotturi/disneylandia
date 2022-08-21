package com.alkemy.disneylandia.disneylandia.service.implement;

import com.alkemy.disneylandia.disneylandia.dto.PersonajeBasicDto;
import com.alkemy.disneylandia.disneylandia.dto.PersonajeDto;
import com.alkemy.disneylandia.disneylandia.dto.PersonajeFiltersDto;
import com.alkemy.disneylandia.disneylandia.entity.PersonajeEntity;
import com.alkemy.disneylandia.disneylandia.exception.ParamNotFound;
import com.alkemy.disneylandia.disneylandia.mapper.PersonajeMapper;
import com.alkemy.disneylandia.disneylandia.repository.PersonajeRepository;
import com.alkemy.disneylandia.disneylandia.repository.specification.PersonajeSpecification;
import com.alkemy.disneylandia.disneylandia.service.PeliculaSerieService;
import com.alkemy.disneylandia.disneylandia.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PersonajeServiceImplement implements PersonajeService {

    private PersonajeMapper personajeMapper;
    private PersonajeSpecification personajeSpecification;
    private PersonajeRepository personajeRepository;
    private PeliculaSerieService peliculaSerieService;

    @Autowired
    public PersonajeServiceImplement(PersonajeMapper personajeMapper, PersonajeSpecification personajeSpecification, PersonajeRepository personajeRepository, PeliculaSerieService peliculaSerieService) {
        this.personajeMapper = personajeMapper;
        this.personajeSpecification = personajeSpecification;
        this.personajeRepository = personajeRepository;
        this.peliculaSerieService = peliculaSerieService;
    }

    public PersonajeDto getDetailsById(Long id) {
        Optional<PersonajeEntity> entity = personajeRepository.findById(id);
        if (!entity.isPresent()) {
            throw new ParamNotFound("ID personaje no válido");
        }
        PersonajeDto personajeDto = personajeMapper.personajeEntity2Dto(entity.get(), true);
        return personajeDto;
    }

    public PersonajeDto save(PersonajeDto dto) {
        PersonajeEntity entity = personajeMapper.personajeDto2Entity(dto);
        PersonajeEntity entitySaved = personajeRepository.save(entity);
        PersonajeDto result = personajeMapper.personajeEntity2Dto(entitySaved, false);
        return result;
    }

    public List<PersonajeBasicDto> getAll() {
        List<PersonajeEntity> entities = personajeRepository.findAll();
        List<PersonajeBasicDto> personajeBasicDtos = personajeMapper.personajeEntitySet2BasicDtoList(entities);
        return personajeBasicDtos;
    }

    public List<PersonajeDto> getAllPersonajes() {
        List<PersonajeEntity> entities = personajeRepository.findAll();
        List<PersonajeDto> result = personajeMapper.personajeEntitySet2DtoList(entities, false);
        return result;
    }

    public void delete(Long id) {
        personajeRepository.deleteById(id);
    }

    public List<PersonajeBasicDto> getByFilters(String nombre, Long edad, Long peso, Set<Long> peliculasSeries, String orden) {
        PersonajeFiltersDto filtersDto = new PersonajeFiltersDto(nombre, edad, peso, peliculasSeries, orden);
        List<PersonajeEntity> entities = personajeRepository.findAll(personajeSpecification.getByFilters(filtersDto));
        List<PersonajeBasicDto> dtos = personajeMapper.personajeEntitySet2BasicDtoList(entities);
        return dtos;
    }

    @Override
    public PersonajeDto update(Long id, PersonajeDto personajeDto) {
        if (!personajeRepository.existsById(id)) {
            throw new ParamNotFound("Invalid id");
        }
        PersonajeEntity personajeOld = personajeRepository.getReferenceById(id);
        PersonajeEntity entity = personajeMapper.update(personajeOld, personajeDto);
        PersonajeEntity entityUpdated = personajeRepository.save(entity);
        PersonajeDto result = personajeMapper.personajeEntity2Dto(entityUpdated, true);
        return result;
    }
}