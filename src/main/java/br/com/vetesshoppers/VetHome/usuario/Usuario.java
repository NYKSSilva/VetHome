package br.com.vetesshoppers.VetHome.usuario;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Table(name = "usuarios")
@Entity(name = "usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private LocalDate data_nasc;
    private String telefone;
    @Enumerated(EnumType.STRING)
    private Role role;
    private String email;
    private String senha;
    private boolean ativo;


    public Usuario(DadosCadastroUsuario dados){
        this.nome = dados.nome();
        this.cpf = dados.cpf();
        this.data_nasc = dados.dataNascimento();
        this.telefone = dados.telefone();
        this.email = dados.email();
        this.senha = dados.senha();
        this.role = Role.USER;
        this.ativo = true;
    }

    public void atualizarusuario(DadosAtualizarUsuario dados){
        if(dados.nome() != null && !dados.nome().isBlank())
            this.nome = dados.nome();
        if(dados.telefone() !=null && dados.telefone().isBlank())
            this.telefone = dados.telefone();
        if(dados.email() !=null && dados.email().isBlank())
            this.email = dados.email();
    }

    public void excluirUsuario(){
        this.ativo = false;
    }
}

