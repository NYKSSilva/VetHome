package br.com.vetesshoppers.VetHome.pets;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;


public record DadosAtualizarPet(
        Long id,
        String nome,
        @JsonFormat(pattern = "dd/MM/yyyy", locale = "pt-BR")
        LocalDate dataNasc,
        String especie,
        String sexo,
        String raca,
        Double peso
) {
}
