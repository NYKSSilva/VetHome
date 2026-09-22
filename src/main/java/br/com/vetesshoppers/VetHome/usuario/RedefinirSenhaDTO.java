package br.com.vetesshoppers.VetHome.usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RedefinirSenhaDTO(
        @NotBlank
        @Size(min = 6)
        String novaSenha
) {
}
