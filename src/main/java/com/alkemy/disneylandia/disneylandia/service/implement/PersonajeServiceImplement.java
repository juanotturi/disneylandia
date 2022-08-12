package com.alkemy.disneylandia.disneylandia.service.implement;

import com.alkemy.disneylandia.disneylandia.dto.PersonajeDto;
import com.alkemy.disneylandia.disneylandia.entity.PersonajeEntity;
import com.alkemy.disneylandia.disneylandia.mapper.PersonajeMapper;
import com.alkemy.disneylandia.disneylandia.repository.PersonajeRepository;
import com.alkemy.disneylandia.disneylandia.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PersonajeServiceImplement implements PersonajeService {

    @Autowired
    private PersonajeMapper personajeMapper;

    @Autowired
    private PersonajeRepository personajeRepository;

    public PersonajeDto save(PersonajeDto dto){
        PersonajeEntity entity = personajeMapper.personajeDto2Entity(dto);
        PersonajeEntity entitySaved = personajeRepository.save(entity);
        PersonajeDto result = personajeMapper.personajeEntity2Dto(entitySaved);
        return result;
    }

    public List<PersonajeDto> getAllPersonajes() {
        List<PersonajeEntity> entities = personajeRepository.findAll();
        List<PersonajeDto> result = personajeMapper.personajeEntityList2DtoList(entities);
        return result;
    }
}