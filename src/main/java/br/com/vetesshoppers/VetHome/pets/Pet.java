package br.com.vetesshoppers.VetHome.pets;

import br.com.vetesshoppers.VetHome.cliente.Cliente;
import br.com.vetesshoppers.VetHome.pets.convenio.Convenio;
import br.com.vetesshoppers.VetHome.pets.especie.Especie;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Table(name = "pet")
@Entity(name = "pet")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private LocalDate data_nasc;

    @Enumerated(EnumType.STRING)
    private Especie especie;
    private String raca;
    private Double peso;

    @Enumerated(EnumType.STRING)
    private Convenio convenio;

    //   @ManyToOne
    //    @JoinColumn(name = "cpfCliente")
    //    private Cliente cliente;
    //    @ManyToOne
//    @JoinColumn(name = "cpfCliente")
//    private Cliente cliente;

    private String cpfCliente;

    private boolean ativo;

    public Pet(DadosCadastroPet dados){
        this.nome = dados.nome();
        this.data_nasc = dados.dataNasc();
        this.especie = dados.especie();
        this.raca = dados.raca();
        this.peso = dados.peso();
        this.convenio = dados.convenio();
        this.cpfCliente = dados.cpfCLiente();
//        this.cliente = cliente;
        this.ativo = true;
    }

    public void atualizarPet(DadosAtualizarPet dados){
        if(dados.nome() != null && !dados.nome().isBlank())
            this.nome = dados.nome();
        if(dados.dataNasc() !=null)
            this.data_nasc = dados.dataNasc();
        if(dados.especie() !=null)
            this.especie = dados.especie();
        if(dados.raca() !=null && !dados.raca().isBlank())
            this.raca = dados.raca();
        if(dados.peso() !=null )
            this.peso = dados.peso();
        if(dados.convenio() !=null)
            this.convenio = dados.convenio();

    }

    public void excluirPet(){
        this.ativo = false;
    }

}
