package br.com.vetesshoppers.VetHome.consulta;

import br.com.vetesshoppers.VetHome.consulta.StatusConsulta.StatusConsulta;
import br.com.vetesshoppers.VetHome.consulta.servicos.Servicos;
import br.com.vetesshoppers.VetHome.pets.especie.Especie;

import java.time.LocalDateTime;

public record DadosListagemConsultaAdm(
        Especie especie,
        String nomeCliente,
        Long nomePet,
        LocalDateTime dataHora,
        Servicos servicos,
        StatusConsulta statusConsulta
) {
//    public  DadosListagemConsultaAdm(Consulta consulta){
//        this(consulta.getEspecie(), consulta.getNomeCliente(), consulta.getNomePet(), consulta.getData_hora(), consulta.getServicos(), consulta.getStatusConsulta());
//    }
}
