package br.com.vetesshoppers.VetHome.usuario;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

public record DadosAtualizarUsuario(
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
