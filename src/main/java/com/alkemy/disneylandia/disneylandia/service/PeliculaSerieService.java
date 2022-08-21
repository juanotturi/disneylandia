package com.alkemy.disneylandia.disneylandia.service;

import com.alkemy.disneylandia.disneylandia.dto.PeliculaSerieBasicDto;
import com.alkemy.disneylandia.disneylandia.dto.PeliculaSerieDto;

import java.util.List;

public interface PeliculaSerieService {
    PeliculaSerieDto save(PeliculaSerieDto dto);

    List<PeliculaSerieDto> getAllPeliculasSeries();

    List<PeliculaSerieBasicDto> getByFilters(String titulo, Long generoId, String orden);

    PeliculaSerieDto getDetailsById(Long id);

    PeliculaSerieDto addPersonaje(Long idPeliculaSerie, Long idPersonaje);

    PeliculaSerieDto removePersonaje(Long idPeliculaSerie, Long idPersonaje);

    PeliculaSerieDto update(Long id, PeliculaSerieDto peliculaSerie);
//    void delete(Long id);
}