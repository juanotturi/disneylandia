package com.alkemy.disneylandia.disneylandia.repository;

import com.alkemy.disneylandia.disneylandia.entity.PeliculaSerieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculaSerieRepository extends JpaRepository<PeliculaSerieEntity, Long> {
}