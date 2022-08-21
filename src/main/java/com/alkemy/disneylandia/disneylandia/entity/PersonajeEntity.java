package com.alkemy.disneylandia.disneylandia.entity;

import lombok.Setter;
import lombok.Getter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "personaje")
@Getter
@Setter
@SQLDelete(sql = "UPDATE personaje SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class PersonajeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String imagen;
    private String nombre;
    private Long edad;
    private Long peso;
    private String historia;
    private boolean deleted = Boolean.FALSE;

    @ManyToMany(mappedBy = "personajes", cascade = CascadeType.ALL)
    private List<PeliculaSerieEntity> peliculasSeries = new ArrayList<>();

    public void addPeliculaSerie(PeliculaSerieEntity peliculaSerie) {
        this.peliculasSeries.add(peliculaSerie);
    }

    public void removePeliculaSerie(PeliculaSerieEntity peliculaSerie) {
        this.peliculasSeries.remove(peliculaSerie);
    }

}