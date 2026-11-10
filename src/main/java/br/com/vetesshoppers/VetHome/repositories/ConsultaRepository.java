package br.com.vetesshoppers.VetHome.repositories;

import br.com.vetesshoppers.VetHome.consulta.Consulta;
import br.com.vetesshoppers.VetHome.consulta.statusConsulta.StatusConsulta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    Page<Consulta> findAllByStatusConsulta(StatusConsulta status, Pageable paginacao);
    Page<Consulta> findAllByCpfClienteAndStatusConsulta(String cpfCliente, StatusConsulta status, Pageable paginacao);
    Optional<Consulta> findByIdAndStatusConsulta(Long id, StatusConsulta status);
}
