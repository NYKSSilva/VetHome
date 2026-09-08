package br.com.vetesshoppers.VetHome.pets;

import br.com.vetesshoppers.VetHome.pets.convenio.Convenio;
import br.com.vetesshoppers.VetHome.pets.especie.Especie;

import java.time.LocalDate;


public record DadosAtualizarPet(
        Long id,
        String nome,
        LocalDate dataNasc,
        Especie especie,
        String raca,
        Double peso,
        Convenio convenio
) {
}
