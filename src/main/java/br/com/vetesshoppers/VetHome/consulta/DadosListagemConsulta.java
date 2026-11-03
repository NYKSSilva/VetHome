package br.com.vetesshoppers.VetHome.consulta;


import br.com.vetesshoppers.VetHome.consulta.statusConsulta.StatusConsulta;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public record DadosListagemConsulta(
        String cpfCliente,
        Long idPet,
        String convenio,
        String servicos,
        LocalDate dataConsulta,
        LocalTime horarioConsulta,
        String descricao_consulta,
        StatusConsulta statusConsulta
) {
    public  DadosListagemConsulta(Consulta consulta){
        this( consulta.getCpfCliente(),consulta.getIdPet(),consulta.getConvenio(), consulta.getServicos(), consulta.getDataConsulta(), consulta.getHorarioConsulta(), consulta.getDescricao_consulta(), consulta.getStatusConsulta());
    }
}


