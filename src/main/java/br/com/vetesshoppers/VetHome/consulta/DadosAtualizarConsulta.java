package br.com.vetesshoppers.VetHome.consulta;

import br.com.vetesshoppers.VetHome.consulta.convenio.Convenio;
import br.com.vetesshoppers.VetHome.consulta.servicos.Servicos;
import br.com.vetesshoppers.VetHome.pets.especie.Especie;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record DadosAtualizarConsulta(

        Long id,

        Especie especie,

        Long idPet,

        LocalDateTime dataHora,

        Servicos servicos,

        Convenio convenio
) {
}
