package br.com.vetesshoppers.VetHome.consulta;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

public record DadosCriarConsulta(

        @NotNull
        String cpfCliente,

        @NotNull
        Long idPet,

        @NotNull
        String servicos,

        @NotNull
        String convenio,

        @NotNull
        LocalDate
        dataConsulta,

        @NotNull
        LocalTime
        horarioConsulta,

        @NotNull
        String
        idEndereco
) {
}
