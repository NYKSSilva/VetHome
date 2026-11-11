package br.com.vetesshoppers.VetHome.repositories;

import br.com.vetesshoppers.VetHome.consulta.Consulta;
import br.com.vetesshoppers.VetHome.consulta.statusConsulta.StatusConsulta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    Page<Consulta> findAllByStatusConsulta(StatusConsulta status, Pageable paginacao);
    Page<Consulta> findAllByCpfClienteAndStatusConsulta(String cpfCliente, StatusConsulta status, Pageable paginacao);
    Optional<Consulta> findByIdAndStatusConsulta(Long id, StatusConsulta status);

    // Verificação de horário (qualquer cliente)
    boolean existsByDataConsultaAndHorarioConsultaAndStatusConsulta(LocalDate data, LocalTime horario, StatusConsulta status);
    boolean existsByDataConsultaAndHorarioConsultaAndStatusConsultaAndIdNot(LocalDate data, LocalTime horario, StatusConsulta status, Long id);
    List<Consulta> findAllByDataConsultaAndStatusConsulta(LocalDate data, StatusConsulta status);
}
