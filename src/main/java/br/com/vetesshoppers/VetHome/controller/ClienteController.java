package br.com.vetesshoppers.VetHome.controller;

import br.com.vetesshoppers.VetHome.repositories.ClienteRepository;
import br.com.vetesshoppers.VetHome.cliente.*;
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
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @PostMapping
    @Transactional
    @Tag(name="Cadastro cliente", description = "Função de criação de cliente.")
    public void cadastrarCliente(@RequestBody @Valid DadosCadastroCliente dados) {
        repository.save(new Cliente(dados));

    }

    @GetMapping
    @Tag(name="Listar clientes", description = "Acessar a lista de clientes existentes.")
    public Page<DadosListagemCliente> listarClientes(@PageableDefault(size=6, sort= {"nome"}) Pageable paginacao){
        return repository.findAllByAtivoTrue(paginacao)
                .map(DadosListagemCliente::new);
    }

    @PutMapping
    @Transactional
    @Tag(name="Atualizar Cliente", description = "Atualização de um usuario existente por id.")
    public void atualizaeCliente(@RequestBody @Valid DadosAtualizarCliente dados) {
        var cliente = repository.getReferenceById(dados.id());
        cliente.atualizarCliente(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    @Tag(name="Deletar cliente", description = "Deletando um cliente com o id na url.")
    public void deletarCliente(@PathVariable  Long id){
        var cliente = repository.getReferenceById(id);
        cliente.excluirCliente();
    }
}
