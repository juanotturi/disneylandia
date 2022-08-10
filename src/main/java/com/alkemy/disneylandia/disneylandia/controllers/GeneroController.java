package com.alkemy.disneylandia.disneylandia.controllers;

import com.alkemy.disneylandia.disneylandia.dto.GeneroDto;
import com.alkemy.disneylandia.disneylandia.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("generos")
public class GeneroController {

    @Autowired
    public GeneroService generoService;

    @GetMapping
    public ResponseEntity<List<GeneroDto>> getAll(){
        List<GeneroDto> generos = this.generoService.getAllGeneros();
        return ResponseEntity.ok().body(generos);
    }

    @PostMapping
    public ResponseEntity<GeneroDto> save(@RequestBody GeneroDto genero){
        //201 genero recibido x parametro ha sido creado y guardado
        GeneroDto generoSaved = generoService.save(genero);
        return ResponseEntity.status(HttpStatus.CREATED).body(generoSaved);
    }

}