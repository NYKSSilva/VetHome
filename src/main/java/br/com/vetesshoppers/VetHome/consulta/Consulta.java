package br.com.vetesshoppers.VetHome.consulta;

import br.com.vetesshoppers.VetHome.consulta.StatusConsulta.StatusConsulta;
import br.com.vetesshoppers.VetHome.consulta.servicos.Servicos;
import br.com.vetesshoppers.VetHome.pets.especie.Especie;
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
    private Especie especie;
    private String cpf_cliente;
    private Long idPet;
    //OffsetDateTIme/ Instant (melhores escolhas para tratativa de horario, talvez eu mude no futuro)
    private LocalDateTime data_hora;
    private Servicos servicos;
    private StatusConsulta statusConsulta;

    public Consulta(DadosCriarConsulta dados){
        this.cpf_cliente = dados.cpfCliente();
        this.idPet = dados.idPet();
        this.data_hora = LocalDateTime.now();
        this.servicos = dados.servicos();
        this.statusConsulta = StatusConsulta.ativo;

    }

    public void atualizarConsulta(DadosAtualizarConsulta dados){
        if(dados.especie() != null)
            this.especie = dados.especie();
        if(dados.idPet() !=null)
            this.idPet = dados.idPet();
        if(dados.dataHora() !=null)
            this.data_hora = dados.dataHora();
        if(dados.servicos() !=null)
            this.servicos = dados.servicos();
    }

    public void excluirConsulta(){
        this.statusConsulta = StatusConsulta.cancelada;
    }
}
