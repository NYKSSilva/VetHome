package br.com.vetesshoppers.VetHome.cliente;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Table(name = "cliente")
@Entity(name = "cliente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String telefone;
    private String email;
    private String senha;
    private boolean ativo;


    public Cliente(DadosCadastroCliente dados){
        this.nome = dados.nome();
        this.cpf = dados.cpf();
        this.dataNascimento = dados.dataNascimento();
        this.telefone = dados.telefone();
        this.email = dados.email();
        this.senha = dados.senha();
        this.ativo = true;
    }
    public void excluirCliente(){
        this.ativo = false;
    }
}

