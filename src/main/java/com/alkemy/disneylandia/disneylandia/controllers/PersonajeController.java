package com.alkemy.disneylandia.disneylandia.controllers;

import com.alkemy.disneylandia.disneylandia.dto.PersonajeDto;
import com.alkemy.disneylandia.disneylandia.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("personajes")
public class PersonajeController {

    @Autowired
    private PersonajeService personajeService;

    @GetMapping("/all")
    public ResponseEntity<List<PersonajeDto>> getAll() {
        List<PersonajeDto> personajes = personajeService.getAllPersonajes();
        return ResponseEntity.ok().body(personajes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonajeDto> getDetailsById(@PathVariable Long id) {
        PersonajeDto personaje = personajeService.getDetailsById(id);
        return ResponseEntity.ok(personaje);
    }

    @GetMapping
    public ResponseEntity<List<PersonajeDto>> getDetailsByFilters(
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) Long edad,
            @RequestParam(required = false) Long peso,
            @RequestParam(required = false) Set<Long> peliculasSeries,
            @RequestParam(required = false, defaultValue = "ASC") String orden) {
        List<PersonajeDto> personajes = personajeService.getByFilters(nombre, edad, peso, peliculasSeries, orden);
        return ResponseEntity.ok(personajes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonajeDto> update(@PathVariable Long id, @RequestBody PersonajeDto personajeDto) {
        PersonajeDto personajeUpdated = personajeService.update(id, personajeDto);
        return ResponseEntity.ok().body(personajeUpdated);
    }

    @PostMapping
    public ResponseEntity<PersonajeDto> save(@RequestBody PersonajeDto personaje) {
        PersonajeDto personajeSaved = personajeService.save(personaje);
        return ResponseEntity.status(HttpStatus.CREATED).body(personajeSaved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        personajeService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}