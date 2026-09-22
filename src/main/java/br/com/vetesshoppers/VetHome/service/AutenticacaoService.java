package br.com.vetesshoppers.VetHome.service;

import br.com.vetesshoppers.VetHome.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class AutenticacaoService implements UserDetailsService {
    @Autowired
    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return repository.findByLoginAndAtivoTrue(login)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
    }
}
