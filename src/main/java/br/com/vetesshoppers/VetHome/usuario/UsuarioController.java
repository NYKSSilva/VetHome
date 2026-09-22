package br.com.vetesshoppers.VetHome.usuario;

import br.com.vetesshoppers.VetHome.repositories.UsuarioRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cliente")
@Tag(name="Cliente", description = "Gerenciamento dos cliente.")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    @Transactional
    @Tag(name="Cadastro cliente", description = "Função de criação de cliente.")
    public void cadastrarCliente(@RequestBody @Valid DadosCadastroUsuario dados) {
        repository.save(new Usuario(dados));
    }//os dois podem

    @GetMapping
    @Tag(name="Listar clientes", description = "Acessar a lista de clientes existentes.")
    public Page<DadosListagemUsuario> listarClientes(@PageableDefault(size=6, sort= {"nome"}) Pageable paginacao){
        return repository.findAllByAtivoTrue(paginacao)
                .map(DadosListagemUsuario::new);
    }//Apenas para adm

    @PutMapping
    @Transactional
    @Tag(name="Atualizar Cliente", description = "Atualização de um usuario existente por id.")
    public void atualizaeCliente(@RequestBody @Valid DadosAtualizarUsuario dados) {
        var cliente = repository.getReferenceById(dados.id());
        cliente.atualizarusuario(dados);
    }//os dois podem

    @DeleteMapping("/{id}")
    @Transactional
    @Tag(name="Deletar cliente", description = "Deletando um cliente com o id na url.")
    public void deletarCliente(@PathVariable  Long id){
        var cliente = repository.getReferenceById(id);
        cliente.excluirUsuario();
    }//os dois podem
}
