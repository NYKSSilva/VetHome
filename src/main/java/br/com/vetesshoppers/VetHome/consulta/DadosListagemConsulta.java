package br.com.vetesshoppers.VetHome.consulta;

import br.com.vetesshoppers.VetHome.consulta.StatusConsulta.StatusConsulta;
import br.com.vetesshoppers.VetHome.consulta.servicos.Servicos;
import br.com.vetesshoppers.VetHome.pets.especie.Especie;

import java.time.LocalDateTime;

public record DadosListagemConsulta(
        Especie especie,
        String cpfCliente,
        Long idPet,
        LocalDateTime dataHora,
        Servicos servicos,
        StatusConsulta statusConsulta
) {
    public  DadosListagemConsulta(Consulta consulta){
        this(consulta.getEspecie(), consulta.getCpf_cliente(), consulta.getIdPet(), consulta.getData_hora(), consulta.getServicos(), consulta.getStatusConsulta());
    }
}


