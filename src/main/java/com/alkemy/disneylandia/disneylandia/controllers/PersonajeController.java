package com.alkemy.disneylandia.disneylandia.controllers;

import com.alkemy.disneylandia.disneylandia.dto.PersonajeDto;
import com.alkemy.disneylandia.disneylandia.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("personajes")
public class PersonajeController {

    @Autowired
    private PersonajeService personajeService;

    @GetMapping
    public ResponseEntity<List<PersonajeDto>> getAll(){
        List<PersonajeDto> personajes = personajeService.getAllPersonajes();
        return ResponseEntity.ok().body(personajes);
    }

    @PostMapping
    public ResponseEntity<PersonajeDto> save(@RequestBody PersonajeDto personaje){
        PersonajeDto personajeSaved = personajeService.save(personaje);
        return ResponseEntity.status(HttpStatus.CREATED).body(personajeSaved);
    }

    @DeleteMapping("/{id}")
        public ResponseEntity<Void> delete(@PathVariable Long id){
            personajeService.delete(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
}