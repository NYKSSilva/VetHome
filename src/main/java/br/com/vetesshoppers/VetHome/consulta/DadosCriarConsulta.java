package br.com.vetesshoppers.VetHome.consulta;

import br.com.vetesshoppers.VetHome.consulta.servicos.Servicos;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;


public record DadosCriarConsulta(

        @NotBlank
        @CPF
        String cpfCliente,

        @NotBlank
        Long idPet,

        @NotBlank
        Servicos servicos

) {
}
