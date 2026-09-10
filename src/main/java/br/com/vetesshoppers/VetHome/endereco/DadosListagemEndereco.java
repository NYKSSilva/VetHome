package br.com.vetesshoppers.VetHome.endereco;


public record DadosListagemEndereco(
        String cep,
        String logradouro,
        String complemento,
        String cidade,
        String numero
) {
    public  DadosListagemEndereco(Endereco endereco){
        this(endereco.getCep(), endereco.getLogradouro(), endereco.getComplemento(), endereco.getCidade(), endereco.getNumero());
    }
}

