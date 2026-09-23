package br.com.vetesshoppers.VetHome.repositories;

import br.com.vetesshoppers.VetHome.usuario.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmailAndAtivoTrue(String email);
    boolean existsByEmailAndAtivoTrue(String email);
    Page<Usuario> findAllByAtivoTrue(Pageable paginacao);
    Optional<Usuario> findByIdAndAtivoTrue(Long id);
}
