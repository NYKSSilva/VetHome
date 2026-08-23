package br.com.vetesshoppers.VetHome.cliente;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public record DadosCadastroCliente(
        @NotBlank
        @Size(min= 3, max= 100)
        String nome,

        @NotBlank
        @Column(unique = true)
        @Size(min= 11, max=11)
        @CPF
        String cpf,

        @NotBlank
        LocalDate dataNascimento,

        @Size(max=20)
        String telefone,

        @NotBlank
        @Column(unique = true)
        @Email
        String email,

        @NotBlank
        String senha

) {
}
