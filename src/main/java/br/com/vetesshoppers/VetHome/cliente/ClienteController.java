package br.com.vetesshoppers.VetHome.cliente;

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
@Tag(name="Cliente", description = "Gerenciamento dos clientes ")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarCliente(@RequestBody @Valid DadosCadastroCliente dados) {
        repository.save(new Cliente(dados));
    }

    @GetMapping
    public Page<DadosListagemCliente> listarClientes(@PageableDefault(size=6, sort= {"nome"}) Pageable paginacao){
        return repository.findAllByAtivoTrue(paginacao)
                .map(DadosListagemCliente::new);
    }

    @PutMapping
    @Transactional
    public void atualizaeCliente(@RequestBody @Valid DadosAtualizarCliente dados) {}

    @DeleteMapping
    @Transactional
    public void deletarCliente(@PathVariable  Long id){
        var cliente = repository.getReferenceById(id);
        cliente.excluirCliente();
    }
}
