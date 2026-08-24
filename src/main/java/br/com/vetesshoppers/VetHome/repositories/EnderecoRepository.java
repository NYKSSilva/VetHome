package br.com.vetesshoppers.VetHome.repositories;

import br.com.vetesshoppers.VetHome.endereco.Endereco;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    Page<Endereco> findAllByAtivoTrue(Pageable paginacao);
    Optional<Endereco> findByIdAndAtivoTrue(Long id);
}
