package br.com.vetesshoppers.VetHome.controller;

import br.com.vetesshoppers.VetHome.login.DadosLogin;
import br.com.vetesshoppers.VetHome.login.DadosRespostaLogin;
import br.com.vetesshoppers.VetHome.repositories.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private ClienteRepository repository;

    // TEMPORÁRIO: as senhas hoje estão salvas em texto puro no banco, então a comparação é direta.
    // Próximo passo: BCrypt (cadastro grava o hash, login usa matches()).
    @PostMapping
    public ResponseEntity<DadosRespostaLogin> login(@RequestBody @Valid DadosLogin dados) {
        var cliente = repository.findByEmailAndAtivoTrue(dados.email().trim());
        if (cliente.isEmpty() || !cliente.get().getSenha().equals(dados.senha())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok(new DadosRespostaLogin(cliente.get()));
    }
}
