package br.com.vetesshoppers.VetHome.repositories;

import br.com.vetesshoppers.VetHome.consulta.Consulta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    Page<Consulta>findAllByStatusConsultaAtivaTrue(Pageable paginacao);
    Optional<Consulta>findByIdAndStatusConsultaAtivaTrue(Long id);
}
