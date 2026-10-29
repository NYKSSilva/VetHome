package br.com.vetesshoppers.VetHome.consulta;

import br.com.vetesshoppers.VetHome.consulta.statusConsulta.StatusConsulta;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

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
    private int id;
    private String cpfCliente;
    private Long idPet;
    private String convenio;
    private String servicos;
    private LocalDate dataConsulta;
    private LocalTime horarioConsulta;
    private String idEndereco;
    @Enumerated(EnumType.STRING)
    private StatusConsulta statusConsulta;

    public Consulta(DadosCriarConsulta dados){
        this.cpfCliente = dados.cpfCliente();
        this.idPet = dados.idPet();
        this.convenio = dados.convenio();
        this.servicos = dados.servicos();
        this.dataConsulta = dados.dataConsulta();
        this.horarioConsulta = dados.horarioConsulta();
        this.idEndereco = dados.idEndereco();
        this.statusConsulta = StatusConsulta.pendente;
    }

    public void atualizarConsulta(DadosAtualizarConsulta dados){
        if(dados.convenio() !=null)
            this.convenio = dados.convenio();
        if(dados.idPet() !=null)
            this.idPet = dados.idPet();
        if(dados.dataConsulta() !=null)
            this.dataConsulta = dados.dataConsulta();
        if(dados.horarioConsulta() !=null)
            this.horarioConsulta = dados.horarioConsulta();
        if(dados.idEndereco() !=null)
            this.idEndereco = dados.idEndereco();
        if(dados.servicos() !=null)
            this.servicos = dados.servicos();
    }

    public void excluirConsulta(){
        this.statusConsulta = StatusConsulta.cancelada;
    }
}
