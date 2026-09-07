package br.com.vetesshoppers.VetHome.consulta;

import br.com.vetesshoppers.VetHome.consulta.StatusConsulta.StatusConsulta;
import br.com.vetesshoppers.VetHome.consulta.servicos.Servicos;
import br.com.vetesshoppers.VetHome.pets.especie.Especie;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record DadosAtualizarConsulta(
        Long id,

        @NotBlank
        Especie especie,

        @NotBlank
        Long idPet,

        @NotBlank
        LocalDateTime dataHora,

        @NotBlank
        Servicos servicos

) {
}
