package br.com.vetesshoppers.VetHome.login;

import br.com.vetesshoppers.VetHome.cliente.Cliente;

import java.time.LocalDate;

/** Nunca devolve a senha. */
public record DadosRespostaLogin(
        Long id,
        String nome,
        String cpf,
        String email,
        String telefone,
        LocalDate dataNascimento
) {
    public DadosRespostaLogin(Cliente c) {
        this(c.getId(), c.getNome(), c.getCpf(), c.getEmail(), c.getTelefone(), c.getData_nasc());
    }
}
