package com.alkemy.disneylandia.disneylandia.repository;

import com.alkemy.disneylandia.disneylandia.entity.PersonajeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonajeRepository extends JpaRepository<PersonajeEntity, Long> {
}