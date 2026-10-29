package br.com.vetesshoppers.VetHome.consulta;

import java.time.LocalDate;
import java.time.LocalTime;

public record DadosAtualizarConsulta(

        Long id,

        String cpfCliente,

        Long idPet,

        String servicos,

        String convenio,

        LocalDate dataConsulta,

        LocalTime horarioConsulta,

        String idEndereco
) {
}
