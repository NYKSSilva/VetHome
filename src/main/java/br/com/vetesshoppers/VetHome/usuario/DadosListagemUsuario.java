package br.com.vetesshoppers.VetHome.usuario;

import java.time.LocalDate;

public record DadosListagemUsuario(
        Long id,
        String nome,
        String email,
        String telefone,
        String cpf,
        LocalDate dataNascimento
) {
    public DadosListagemUsuario(Usuario usuario){
        this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getTelefone(), usuario.getCpf(), usuario.getData_nasc());
    }

}
