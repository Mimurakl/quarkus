package com.study.quarkus.mapper;

import com.study.quarkus.dto.ProfessorResponse;
import com.study.quarkus.model.Professor;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@ApplicationScoped
public class ProfessorMapper {
    public List<ProfessorResponse> toResponse(List<Professor> listOfProfessors) {

        if (Objects.isNull(listOfProfessors)) return new ArrayList<>();

        return listOfProfessors.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public ProfessorResponse toResponse(Professor entity) {

        Objects.requireNonNull(entity, "Entity must be not null");

        return  ProfessorResponse.builder()
                    .id(entity.getId())
                    .name(entity.getName())
                    .build();
    }
}
