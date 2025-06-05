package com.unasp.Integrador.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @NotNull(message = "A data é obrigatória")
    private LocalDate data;

    private String descricao;
}

