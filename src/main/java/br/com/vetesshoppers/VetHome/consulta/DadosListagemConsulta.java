package br.com.vetesshoppers.VetHome.consulta;

import br.com.vetesshoppers.VetHome.cliente.Cliente;
import br.com.vetesshoppers.VetHome.consulta.StatusConsulta.StatusConsulta;
import br.com.vetesshoppers.VetHome.consulta.servicos.Servicos;
import br.com.vetesshoppers.VetHome.pets.especie.Especie;

import java.time.LocalDateTime;

public record DadosListagemConsulta(
        Especie especie;
        String cpfCLiente;
        Long idPet;
        LocalDateTime dataHora;
        Servicos servicos;
        StatusConsulta statusConsulta;
) {
//    public  DadosListagemConsulta(Consulta consulta){
//        this(consulta.getId(), consulta.getCpfCliente(), consulta.getEmail(), cliente.getTelefone(), cliente.getCpf(), cliente.getDataNascimento());
//    }
}


