package br.com.vetesshoppers.VetHome.repositories;

import br.com.vetesshoppers.VetHome.pets.Pet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PetRepository extends JpaRepository<Pet, Long> {
    Page<Pet> findAllByIdClienteAndAtivo(Pageable paginacao);
    Optional<Pet> findByIdAndAtivoTrue(Long id);
}
