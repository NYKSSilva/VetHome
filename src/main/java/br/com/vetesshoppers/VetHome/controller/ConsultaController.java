package br.com.vetesshoppers.VetHome.controller;

import br.com.vetesshoppers.VetHome.consulta.Consulta;
import br.com.vetesshoppers.VetHome.consulta.ConsultaValidador;
import br.com.vetesshoppers.VetHome.consulta.DadosAtualizarConsulta;
import br.com.vetesshoppers.VetHome.consulta.DadosCriarConsulta;
import br.com.vetesshoppers.VetHome.consulta.DadosListagemConsulta;
import br.com.vetesshoppers.VetHome.consulta.statusConsulta.StatusConsulta;
import br.com.vetesshoppers.VetHome.infra.RegraDeNegocioException;
import br.com.vetesshoppers.VetHome.repositories.ConsultaRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/consulta")
@Tag(name="Consulta", description = "Gerenciamento das consultas ")
public class ConsultaController {

    @Autowired
    private ConsultaRepository repository;

    @Autowired
    private ConsultaValidador validador;

    @PostMapping
    @Transactional
    public void criarConsulta(@RequestBody @Valid DadosCriarConsulta dados) {
        validador.validarNovo(dados.dataConsulta(), dados.horarioConsulta());
        repository.save(new Consulta(dados));
    }

    @GetMapping
    public Page<DadosListagemConsulta> listarConsulta(
            @RequestParam String cpfCliente,
            @PageableDefault(size = 50, sort = {"dataConsulta"}) Pageable paginacao) {
        return repository.findAllByCpfClienteAndStatusConsulta(cpfCliente, StatusConsulta.pendente, paginacao)
                .map(DadosListagemConsulta::new);
    }

    // Horários livres de uma data (não revela quem reservou). Ex.: /consulta/horarios-disponiveis?data=2026-11-20
    @GetMapping("/horarios-disponiveis")
    public List<String> horariosDisponiveis(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data) {
        return validador.horariosDisponiveis(data);
    }

    @PutMapping
    @Transactional
    public void atualizarConsulta(@RequestBody @Valid DadosAtualizarConsulta dados) {
        var consulta = repository.findById(dados.id())
                .orElseThrow(() -> new RegraDeNegocioException(HttpStatus.NOT_FOUND, "Consulta não encontrada."));

        var novaData = dados.dataConsulta() != null ? dados.dataConsulta() : consulta.getDataConsulta();
        var novoHorario = dados.horarioConsulta() != null ? dados.horarioConsulta() : consulta.getHorarioConsulta();
        boolean remarcou = !novaData.equals(consulta.getDataConsulta())
                || !novoHorario.equals(consulta.getHorarioConsulta());
        if (remarcou) {
            validador.validarAlteracao(consulta.getId(), novaData, novoHorario);
        }

        consulta.atualizarConsulta(dados);
        repository.flush();
        // se alguém reservou no mesmo instante, o erro sai aqui e vira 409
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletarConsulta(@PathVariable Long id) {
        var consulta = repository.getReferenceById(id);
        consulta.excluirConsulta();
    }
}
