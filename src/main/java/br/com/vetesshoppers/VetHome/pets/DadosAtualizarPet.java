package br.com.vetesshoppers.VetHome.pets;

import br.com.vetesshoppers.VetHome.pets.especie.Especie;
import br.com.vetesshoppers.VetHome.pets.sexo.Sexo;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;


public record DadosAtualizarPet(
        Long id,
        String nome,
        @JsonFormat(pattern = "dd/MM/yyyy", locale = "pt-BR")
        LocalDate dataNasc,
        Especie especie,
        Sexo sexo,
        String raca,
        Double peso
) {
}
