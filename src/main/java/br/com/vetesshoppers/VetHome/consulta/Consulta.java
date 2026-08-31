package br.com.vetesshoppers.VetHome.consulta;

import br.com.vetesshoppers.VetHome.consulta.StatusConsulta.StatusConsulta;
import br.com.vetesshoppers.VetHome.consulta.servicos.Servicos;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

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
    private LocalDateTime dataHora;
    private Servicos servicos;
    private StatusConsulta statusConsulta;

    public Consulta(DadosCriarConsulta dados){
        this.cpfCliente = dados.cpfCliente();
        this.idPet = dados.idPet();
        this.dataHora = LocalDateTime.now();
        this.servicos = dados.servicos();
        this.statusConsulta = StatusConsulta.ativo;

    }
}
