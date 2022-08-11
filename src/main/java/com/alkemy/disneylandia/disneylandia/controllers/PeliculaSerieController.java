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
    public ResponseEntity<List<PeliculaSerieDto>> getAll(){
        List<PeliculaSerieDto> peliculasSeries = peliculaSerieService.getAllPeliculasSeries();
        return ResponseEntity.ok().body(peliculasSeries);
    }

    @PostMapping
    public ResponseEntity<PeliculaSerieDto> save(@RequestBody PeliculaSerieDto peliculaSerie){
        PeliculaSerieDto peliculaSerieSaved = peliculaSerieService.save(peliculaSerie);
        return ResponseEntity.status(HttpStatus.CREATED).body(peliculaSerieSaved);
    }
}