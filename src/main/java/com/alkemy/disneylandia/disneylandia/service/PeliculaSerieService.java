package com.alkemy.disneylandia.disneylandia.service;

import com.alkemy.disneylandia.disneylandia.dto.PeliculaSerieDto;

import java.util.List;

public interface PeliculaSerieService {
    PeliculaSerieDto save(PeliculaSerieDto dto);
    List<PeliculaSerieDto> getAllPeliculasSeries();
}