package br.com.vetesshoppers.VetHome.cliente;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public record DadosAtualizarCliente(
        Long id,

        @NotBlank
        @Size(min= 3, max= 100)
        String nome,

        @Size(max=20)
        String telefone,

        @NotBlank
        @Column(unique = true)
        @Email
        String email
) {
}
