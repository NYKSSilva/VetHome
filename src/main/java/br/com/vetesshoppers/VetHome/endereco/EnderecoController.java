package br.com.vetesshoppers.VetHome.endereco;

import br.com.vetesshoppers.VetHome.repositories.EnderecoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cliente/endereco")
//deixar com que o adm possa atualizar as iformações.
public class EnderecoController {
    @Autowired
    private EnderecoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarEndereco(@RequestBody DadosCadastroEndereco dados) {

        repository.save(new Endereco(dados));
    }

//    @GetMapping
//    public Page<DadosListagemPet> listarPet(@AuthenticationPrincipal Usuario usuarioLogado, @PageableDefault(size=6, sort= {"nome"}) Pageable paginacao){
//        return repository.findAllByIdClienteAndAtivoTrue(usuarioLogado.getId(), paginacao)
//                .map(DadosListagemPet::new);
//    }

    @GetMapping
    public Page<DadosListagemEndereco> listarEndereco(@RequestParam String cpfCliente, @PageableDefault(size=6, sort= {"cidade"}) Pageable paginacao){
        return repository.findAllByIdClienteAndAtivoTrue(cpfCliente, paginacao)
                .map(DadosListagemEndereco::new);
    }

    @PutMapping
    @Transactional
    public void atualizarEndereco(@RequestBody @Valid DadosAtualizarEndereco dados) {
        var endereco = repository.getReferenceById(dados.id());
        endereco.atualizarEndereco(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluirEndereco(@PathVariable Long id){
        var endereco = repository.getReferenceById(id);
        endereco.excluirEndereco();
    }
}
