package br.com.vetesshoppers.VetHome.consulta;

import br.com.vetesshoppers.VetHome.repositories.ConsultaRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("consulta")
@Tag(name="Consulta", description = "Gerenciamento das consultas ")
public class ConsultaController {

    @Autowired
    private ConsultaRepository repository;

    @PostMapping
    @Transactional
    public void criarConsulta(@RequestBody DadosCriarConsulta dados) {
        repository.save(new Consulta(dados));
    }

    @GetMapping
    public Page<DadosListagemConsulta> listarClientes(@PageableDefault(size=6, sort= {"nome"}) Pageable paginacao){
        return repository.findAllByStatusConsultaAtivaTrue(paginacao)
                .map(DadosListagemConsulta::new);
    }

    @PutMapping
    @Transactional
    public void atualizarConsulta(@RequestBody @Valid DadosAtualizarConsulta dados) {
        var consulta = repository.getReferenceById(dados.id());
        consulta.atualizarConsulta(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletarCliente(@PathVariable  Long id){
        var cliente = repository.getReferenceById(id);
        cliente.excluirConsulta();
    }



}
