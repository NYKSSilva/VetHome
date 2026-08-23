package br.com.vetesshoppers.VetHome.pets;

import jakarta.persistence.*;
import lombok.*;
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
    private String name;
    private String dataNascimento;
    private String especie;
    private String raca;
    private String peso;
    private String convenio;
    private String cpfCliente;
    private boolean ativo;
}
