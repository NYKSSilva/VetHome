package br.com.vetesshoppers.VetHome.consulta;

import br.com.vetesshoppers.VetHome.consulta.convenio.Convenio;
import br.com.vetesshoppers.VetHome.consulta.servicos.Servicos;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

public record DadosCriarConsulta(

        @NotNull
        String cpfCliente,

        @NotNull
        Long idPet,

        @NotNull
        Servicos servicos,

        @NotNull
        String tipoDetalhamento,

        @NotNull
        Convenio convenio
) {
}
