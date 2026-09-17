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
    }//parte do usuario criar as consultas que deseja com os pets que deseja.

//    @GetMapping("/adm")
//    public Page<DadosListagemConsultaAdm> listarConsultasAdm(@PathVariable  Long id, @PageableDefault(size=6, sort= {"nome"}) Pageable paginacao){
//        return repository.findAllByIdAndStatusConsultaAtivaTrue(id, paginacao)
//                .map(DadosListagemConsulta::new);
//    }
    //listagem de consultas que irão mostrar apenas de acordo com o id do cliente.

    @GetMapping
    public Page<DadosListagemConsulta> listarConsultas(@PageableDefault(size=6, sort= {"nome"}) Pageable paginacao){
        return repository.findAllByStatusConsultaAtivaTrue(paginacao)
                .map(DadosListagemConsulta::new);
    }//listagem de consultas apenas para os adm's visto que essa vai aparecer todas as consultas existentes.


    @PutMapping
    @Transactional
    public void atualizarConsulta(@RequestBody @Valid DadosAtualizarConsulta dados) {
        var consulta = repository.getReferenceById(dados.id());
        consulta.atualizarConsulta(dados);
    }// atualizar consulta é para os clientes e adms

    @DeleteMapping("/{id}")
    @Transactional
    public void deletarConsulta(@PathVariable  Long id){
        var cliente = repository.getReferenceById(id);
        cliente.excluirConsulta();
    }//para clientes e adm's visto que os



}
