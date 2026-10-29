package br.com.vetesshoppers.VetHome.pets;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record DadosCadastroPet(
        @NotBlank
        @Size(min= 3, max= 100)
        String nome,

        @NotBlank
        @JsonFormat(pattern = "yyyy-MM-dd")
        LocalDate dataNasc,

        @NotBlank
        String especie,

        @NotBlank
        String sexo,

        @NotBlank
        String raca,

        @NotBlank
        Double peso,

//        @NotBlank
//        String idCliente

        @NotBlank
        @Size(min = 11, max = 11)
        String cpfCliente

) {
}
