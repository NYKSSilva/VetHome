package br.com.vetesshoppers.VetHome.security;

import br.com.vetesshoppers.VetHome.autenticacao.AutenticacaoService;
import br.com.vetesshoppers.VetHome.usuario.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true) // Habilita anotações como @PreAuthorize nos controllers
public class SecurityConfigurations {



    @Autowired
    private AutenticacaoService autenticacaoService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(Customizer.withDefaults())
                .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED))
                .authorizeHttpRequests(req -> {
                    // Endpoint público de email e cadastro
                    req.requestMatchers("/login","/cadastro" ).permitAll();

                    // Rotas de usuarios
                    req.requestMatchers(HttpMethod.GET, "/usuario", "/usuario/*").hasAnyRole("USER", "ADMIN");
                    req.requestMatchers(HttpMethod.POST, "/usuario").hasAnyRole("USER", "ADMIN");
                    req.requestMatchers(HttpMethod.PUT, "/usuario").hasAnyRole("USER", "ADMIN");
                    req.requestMatchers(HttpMethod.DELETE, "/usuario/*").hasAnyRole("USER", "ADMIN");

                    // Rotas de gerenciamento de usuários (apenas ADMIN)
                    req.requestMatchers("/usuarios/**").hasRole(Role.ADMIN.name());

                    // Qualquer outra requisição precisa estar autenticada
                    req.anyRequest().authenticated();
                })
                .userDetailsService(autenticacaoService)
                .formLogin(Customizer.withDefaults())
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
