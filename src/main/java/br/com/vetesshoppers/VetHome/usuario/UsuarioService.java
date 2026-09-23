package br.com.vetesshoppers.VetHome.usuario;

import br.com.vetesshoppers.VetHome.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario criarUsuario(DadosCadastroUsuario dados) {
        if (repository.existsByEmailAndAtivoTrue(dados.email())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Usuario já existe!");
        }
        Usuario usuario = new Usuario(dados);
        usuario.setSenha(passwordEncoder.encode(dados.senha()));
        return repository.save(usuario);
    }

    public Page<DadosListagemUsuario> listarUsuarios(Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemUsuario::new);
    }

    public Usuario buscarPorId(Long id) {
        return repository.findByIdAndAtivoTrue(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));
    }

    public Usuario atualizarUsuario(DadosAtualizarUsuario dados) {
        Usuario usuario = buscarPorId(dados.id());
        if (dados.email() != null && !dados.email().isBlank()) {
            // verifica se novo email já existe em outro usuário ativo
            if (repository.existsByEmailAndAtivoTrue(dados.email())) {
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Login já está em uso");
            }
            usuario.setEmail(dados.email());
        }
        return repository.save(usuario);
    }

    public void atualizarSenha(Long id, String novaSenha) {
        Usuario usuario = buscarPorId(id);
        usuario.setSenha(passwordEncoder.encode(novaSenha));
        repository.save(usuario);
    }

    public void desativarUsuario(Long id) {
        Usuario usuario = buscarPorId(id);
        usuario.setAtivo(false);
        repository.save(usuario);
    }
}

