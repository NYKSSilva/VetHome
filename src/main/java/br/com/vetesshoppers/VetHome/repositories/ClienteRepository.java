package br.com.vetesshoppers.VetHome.repositories;

import br.com.vetesshoppers.VetHome.cliente.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Page<Cliente> findAllByAtivoTrue(Pageable paginacao);
    Optional<Cliente> findByIdAndAtivoTrue(Long id);
    Optional<Cliente> findByCpf(String cpf);
}
