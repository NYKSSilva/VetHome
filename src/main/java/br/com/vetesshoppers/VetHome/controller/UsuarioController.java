package br.com.vetesshoppers.VetHome.controller;

import br.com.vetesshoppers.VetHome.repositories.UsuarioRepository;
import br.com.vetesshoppers.VetHome.usuario.DadosAtualizarUsuario;
import br.com.vetesshoppers.VetHome.usuario.DadosCadastroUsuario;
import br.com.vetesshoppers.VetHome.usuario.DadosListagemUsuario;
import br.com.vetesshoppers.VetHome.usuario.Usuario;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("usuario")
@Tag(name="usuario", description = "Gerenciamento dos usuario.")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    @Transactional
    @Tag(name="Cadastro usuario", description = "Função de criação de usuario.")
    public void cadastrarUsuario(@RequestBody @Valid DadosCadastroUsuario dados) {
        repository.save(new Usuario(dados));
    }//os dois podem

    @GetMapping
    @Tag(name="Listar usuarios", description = "Acessar a lista de usuarios existentes.")
    public Page<DadosListagemUsuario> listarUsuario(@PageableDefault(size=6, sort= {"nome"}) Pageable paginacao){
        return repository.findAllByAtivoTrue(paginacao)
                .map(DadosListagemUsuario::new);
    }//Apenas para adm

    @PutMapping
    @Transactional
    @Tag(name="Atualizar Usuario", description = "Atualização de um usuario existente por id.")
    public void atualizarUsuario(@RequestBody @Valid DadosAtualizarUsuario dados) {
        var usuario = repository.getReferenceById(dados.id());
        usuario.atualizarusuario(dados);
    }//os dois podem

    @DeleteMapping("/{id}")
    @Transactional
    @Tag(name="Deletar usuario", description = "Deletando um usuario com o id na url.")
    public void deletarUsuario(@PathVariable  Long id){
        var usuario = repository.getReferenceById(id);
        usuario.excluirUsuario();
    }// os dois podem
}
