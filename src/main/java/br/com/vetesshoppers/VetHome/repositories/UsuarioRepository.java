package br.com.vetesshoppers.VetHome.repositories;

import br.com.vetesshoppers.VetHome.usuario.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByLoginAndAtivoTrue(String login);
    Page<Usuario> findAllByAtivoTrue(Pageable paginacao);
    Optional<Usuario> findByIdAndAtivoTrue(Long id);
    Optional<Usuario> findByCpf(String cpf);
}
