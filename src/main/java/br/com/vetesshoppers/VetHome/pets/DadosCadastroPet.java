package br.com.vetesshoppers.VetHome.pets;

import br.com.vetesshoppers.VetHome.pets.convenio.Convenio;
import br.com.vetesshoppers.VetHome.pets.especie.Especie;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record DadosCadastroPet(
        @NotBlank
        @Size(min= 3, max= 100)
        String nome,

        @NotBlank
        @JsonFormat(pattern = "dd/MM/yyyy", locale = "pt-BR")
        LocalDate dataNasc,

        @NotBlank
        Especie especie,

        @NotBlank
        String raca,

        @NotBlank
        Double peso,

        @NotBlank
        Convenio convenio,

//        @NotBlank
//        String idCliente

        @NotBlank
        @Size(min = 11, max = 11)
        String cpfCLiente

) {
}
