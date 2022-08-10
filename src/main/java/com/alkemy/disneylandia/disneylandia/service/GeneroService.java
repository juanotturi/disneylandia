package com.alkemy.disneylandia.disneylandia.service;

import com.alkemy.disneylandia.disneylandia.dto.GeneroDto;
import org.springframework.stereotype.Service;

@Service
public class GeneroService {

    public GeneroDto save(GeneroDto dto){
        // TODO: guardar
        System.out.println("GUARDAR GENERO");
        return dto;
    }
}