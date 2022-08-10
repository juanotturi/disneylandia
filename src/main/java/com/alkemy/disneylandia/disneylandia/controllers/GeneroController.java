package com.alkemy.disneylandia.disneylandia.controllers;

import com.alkemy.disneylandia.disneylandia.dto.GeneroDto;
import com.alkemy.disneylandia.disneylandia.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("generos")
public class GeneroController {

    @Autowired
    public GeneroService generoService;

    @PostMapping
    public ResponseEntity<GeneroDto> save(@RequestBody GeneroDto genero){
        //201 genero recibido x parametro ha sido creado y guardado
        GeneroDto generoSaved = generoService.save(genero);
        return ResponseEntity.status(HttpStatus.CREATED).body(generoSaved);
    }

}