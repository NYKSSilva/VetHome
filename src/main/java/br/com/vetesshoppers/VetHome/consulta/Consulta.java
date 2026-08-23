package br.com.vetesshoppers.VetHome.consulta;

import br.com.vetesshoppers.VetHome.consulta.StatusConsulta.StatusConsulta;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "consulta")
@Entity(name = "consulta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
    private int id;
    private String cpfCliente;
    private Long idPet;
    private Data dataHora;
    private String servicos;
    private StatusConsulta statusConsulta;
}
