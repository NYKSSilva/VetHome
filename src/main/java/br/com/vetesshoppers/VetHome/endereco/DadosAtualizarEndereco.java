package br.com.vetesshoppers.VetHome.endereco;

import jakarta.validation.constraints.Size;

public record DadosAtualizarEndereco(

        Long id,
        @Size(min= 8, max= 8)
        String cep,
        String logradouro,
        String complemento,
        String bairro,
        String cidade,
        String numero
) {
}
