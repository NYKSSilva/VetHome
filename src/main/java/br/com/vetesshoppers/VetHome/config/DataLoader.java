package br.com.vetesshoppers.VetHome.config;

import br.com.vetesshoppers.VetHome.usuario.Role;
import br.com.vetesshoppers.VetHome.usuario.Usuario;
import br.com.vetesshoppers.VetHome.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;


public class DataLoader  implements CommandLineRunner {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

        // Criar usuário ADMIN se não existir
        if (usuarioRepository.findByEmailAndAtivoTrue("admin").isEmpty()) {
            Usuario admin = new Usuario();
            admin.setEmail("admin");
            admin.setSenha(passwordEncoder.encode("admin"));
            admin.setRole(Role.ADMIN);
            admin.setAtivo(true);
            usuarioRepository.save(admin);
            System.out.println("Usuário ADMIN criado: admin / admin");
        }

        // Criar usuário USER se não existir
        if (usuarioRepository.findByEmailAndAtivoTrue("user").isEmpty()) {
            Usuario user = new Usuario();
            user.setEmail("user");
            user.setSenha(passwordEncoder.encode("user"));
            user.setRole(Role.USER);
            user.setAtivo(true);
            usuarioRepository.save(user);
            System.out.println("Usuário USER criado: user / user");
        }
    }

}
