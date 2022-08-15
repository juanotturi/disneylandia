package com.alkemy.disneylandia.disneylandia.repository.specification;

import com.alkemy.disneylandia.disneylandia.dto.PeliculaSerieFiltersDto;
import com.alkemy.disneylandia.disneylandia.entity.PeliculaSerieEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Component
public class PeliculaSerieSpecification {
    public Specification<PeliculaSerieEntity> getByFilters(PeliculaSerieFiltersDto filtersDto) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (StringUtils.hasLength(filtersDto.getTitulo())) {
                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("titulo")), "%" + filtersDto.getTitulo().toLowerCase() + "%"
                        )
                );
            }
            if (StringUtils.hasLength(String.valueOf(filtersDto.getGeneroId()))) {
                predicates.add(criteriaBuilder.equal(root.get("generoId"), Long.toString(filtersDto.getGeneroId())));
            }
            query.distinct(true);
            String orderByField = "fecha_creacion";
            query.orderBy(
                    filtersDto.isAsc() ?
                            criteriaBuilder.asc(root.get((orderByField))) : criteriaBuilder.desc(root.get(orderByField))
            );
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}