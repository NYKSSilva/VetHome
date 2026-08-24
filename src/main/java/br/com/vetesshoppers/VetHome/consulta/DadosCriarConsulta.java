package br.com.vetesshoppers.VetHome.consulta;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;


public record DadosCriarConsulta(

        @NotBlank
        @CPF
        String cpfCliente,

        @NotBlank
        Long idPet,

        @NotBlank
        String servicos

) {
}
