package br.com.vetesshoppers.VetHome.endereco;

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
    private String cpfCliente;
    private boolean ativo;
}
