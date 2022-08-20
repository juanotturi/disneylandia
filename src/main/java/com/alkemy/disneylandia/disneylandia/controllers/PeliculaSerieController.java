package com.alkemy.disneylandia.disneylandia.controllers;

import com.alkemy.disneylandia.disneylandia.dto.PeliculaSerieDto;
import com.alkemy.disneylandia.disneylandia.service.PeliculaSerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("peliculasseries")
public class PeliculaSerieController {

    @Autowired
    private PeliculaSerieService peliculaSerieService;

    @GetMapping("/all")
    public ResponseEntity<List<PeliculaSerieDto>> getAll() {
        List<PeliculaSerieDto> peliculasSeries = peliculaSerieService.getAllPeliculasSeries();
        return ResponseEntity.ok().body(peliculasSeries);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PeliculaSerieDto> getDetailsById(@PathVariable Long id) {
        PeliculaSerieDto peliculaSerie = peliculaSerieService.getDetailsById(id);
        return ResponseEntity.ok(peliculaSerie);
    }

    @GetMapping
    public ResponseEntity<List<PeliculaSerieDto>> getDetailsByFilters(
            @RequestParam(required = false) String titulo,
            @RequestParam(required = false) Long generoId,
            @RequestParam(required = false, defaultValue = "ASC") String orden) {
        List<PeliculaSerieDto> peliculasSeries = peliculaSerieService.getByFilters(titulo, generoId, orden);
        return ResponseEntity.ok(peliculasSeries);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PeliculaSerieDto> update(@PathVariable Long id, @RequestBody PeliculaSerieDto peliculaSerie) {
        PeliculaSerieDto peliculaSerieUpdated = this.peliculaSerieService.update(id, peliculaSerie);
        return ResponseEntity.ok().body(peliculaSerieUpdated);
    }

    @PostMapping
    public ResponseEntity<PeliculaSerieDto> save(@RequestBody PeliculaSerieDto peliculaSerie) {
        PeliculaSerieDto peliculaSerieSaved = peliculaSerieService.save(peliculaSerie);
        return ResponseEntity.status(HttpStatus.CREATED).body(peliculaSerieSaved);
    }

    @PostMapping("/{idPeliculaSerie}/personajes/{idPersonaje}")
    public ResponseEntity<PeliculaSerieDto> addPersonaje(@PathVariable Long idPeliculaSerie, @PathVariable Long idPersonaje) {
        peliculaSerieService.addPersonaje(idPeliculaSerie, idPersonaje);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("{idPeliculaSerie}/personajes/{idPersonaje}")
    public ResponseEntity<PeliculaSerieDto> removePersonaje(@PathVariable Long idPeliculaSerie, @PathVariable Long idPersonaje) {
        peliculaSerieService.removePersonaje(idPeliculaSerie, idPersonaje);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}