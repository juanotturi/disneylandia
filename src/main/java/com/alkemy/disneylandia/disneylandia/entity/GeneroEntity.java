package com.alkemy.disneylandia.disneylandia.entity;

import lombok.Setter;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "genero")
@Getter
@Setter

public class GeneroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String imagen;
    private String nombre;

}