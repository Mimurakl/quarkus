package com.study.quarkus.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ALUNOS")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aluno_id")
    private Integer id;

    @NotBlank(message = "Name must be not empty or null")
    @Column(name = "aluno_name", nullable = false)
    private String name;

    @Column(name="data_atualizacao", nullable = false)
    private LocalDateTime dateTime;

    @PrePersist
    public void prePersist(){
        setDateTime(LocalDateTime.now());
    }
}
