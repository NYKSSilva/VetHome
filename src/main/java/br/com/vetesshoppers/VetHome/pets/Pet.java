package br.com.vetesshoppers.VetHome.pets;

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
    private String name;
    private LocalDate dataNascimento;
    private Especie especie;
    private String raca;
    private String peso;
    private String convenio;
    private String cpfCliente;
    private boolean ativo;
}
