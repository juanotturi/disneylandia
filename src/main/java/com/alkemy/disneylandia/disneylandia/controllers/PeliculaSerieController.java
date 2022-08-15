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

    @GetMapping
    public ResponseEntity<List<PeliculaSerieDto>> getAll() {
        List<PeliculaSerieDto> peliculasSeries = peliculaSerieService.getAllPeliculasSeries();
        return ResponseEntity.ok().body(peliculasSeries);
    }

    @GetMapping
    public ResponseEntity<List<PeliculaSerieDto>> getDetailsByFilters(@RequestParam(required = false) String titulo, @RequestParam(required = false) Long genero_id, @RequestParam(required = false, defaultValue = "ASC") String orden) {
        List<PeliculaSerieDto> peliculasSeries = peliculaSerieService.getByFilters(titulo, genero_id, orden);
        return ResponseEntity.ok(peliculasSeries);
    }

    @PostMapping
    public ResponseEntity<PeliculaSerieDto> save(@RequestBody PeliculaSerieDto peliculaSerie) {
        PeliculaSerieDto peliculaSerieSaved = peliculaSerieService.save(peliculaSerie);
        return ResponseEntity.status(HttpStatus.CREATED).body(peliculaSerieSaved);
    }
}