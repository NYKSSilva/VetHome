package br.com.vetesshoppers.VetHome.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public record DadosCadastroEndereco(
        @NotBlank
        @Size(min= 8, max= 8)
        String cep,

        @NotBlank
        String logradouro,

        String complemento,

        @NotBlank
        String bairro,

        @NotBlank
        String cidade,

        @NotBlank
        String numero,

//        @NotBlank
//        String idCliente

        @NotBlank
        @Size(min = 11, max = 11)
        String cpfCliente
) {
}
