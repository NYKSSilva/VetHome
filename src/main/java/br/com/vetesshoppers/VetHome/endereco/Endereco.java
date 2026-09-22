package br.com.vetesshoppers.VetHome.endereco;

import br.com.vetesshoppers.VetHome.pets.DadosAtualizarPet;
import br.com.vetesshoppers.VetHome.pets.DadosCadastroPet;
import jakarta.persistence.*;
import lombok.*;
@Table(name = "endereco")
@Entity(name = "endereco")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
    private Long id;
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String cidade;
    private String numero;
    private String idCliente;
    private boolean ativo;


    public Endereco(DadosCadastroEndereco dados){
        this.cep = dados.cep();
        this.logradouro = dados.logradouro();
        this.complemento = dados.complemento();
        this.bairro = dados.bairro();
        this.cidade = dados.cidade();
        this.numero = dados.numero();
        this.idCliente = dados.idCliente();
//        this.cliente = cliente;
        this.ativo = true;
    }

    public void atualizarEndereco(DadosAtualizarEndereco dados){
        if(dados.cep() != null && !dados.cep().isBlank())
            this.cep = dados.cep();
        if(dados.logradouro() !=null  && !dados.logradouro().isBlank())
            this.logradouro = dados.logradouro();
        if(dados.complemento() !=null  && !dados.complemento().isBlank())
            this.complemento = dados.complemento();
        if(dados.bairro() !=null  && !dados.bairro().isBlank())
            this.bairro = dados.bairro();
        if(dados.cidade() !=null  && !dados.cidade().isBlank())
            this.cidade = dados.cidade();
        if(dados.numero() !=null  && !dados.numero().isBlank())
            this.numero = dados.numero();

    }

    public void excluirEndereco(){this.ativo = false;}
}
