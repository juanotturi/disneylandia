package com.alkemy.disneylandia.disneylandia.service;

import com.alkemy.disneylandia.disneylandia.dto.GeneroDto;
import java.util.List;

public interface GeneroService {

    GeneroDto save(GeneroDto dto);

    List<GeneroDto> getAllGeneros();

}