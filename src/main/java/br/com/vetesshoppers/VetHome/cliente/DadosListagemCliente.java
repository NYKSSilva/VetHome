package br.com.vetesshoppers.VetHome.cliente;

import java.time.LocalDate;

public record DadosListagemCliente(
        Long id,
        String nome,
        String email,
        String telefone,
        String cpf,
        LocalDate dataNascimento
) {
    public  DadosListagemCliente(Cliente cliente){
        this(cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getTelefone(), cliente.getCpf(), cliente.getData_nasc());
    }
}
