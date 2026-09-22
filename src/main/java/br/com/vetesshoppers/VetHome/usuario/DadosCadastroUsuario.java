package br.com.vetesshoppers.VetHome.usuario;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public record DadosCadastroUsuario(
        @NotBlank
        @Size(min= 3, max= 100)
        String nome,

        @NotBlank
        @Column(unique = true)
        @Size(min= 11, max=11)
        @CPF
        String cpf,

        @JsonFormat(pattern = "dd/MM/yyyy", locale = "pt-BR")
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
