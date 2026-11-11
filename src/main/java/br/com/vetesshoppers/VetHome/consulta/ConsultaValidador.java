package br.com.vetesshoppers.VetHome.consulta;

import br.com.vetesshoppers.VetHome.consulta.statusConsulta.StatusConsulta;
import br.com.vetesshoppers.VetHome.infra.RegraDeNegocioException;
import br.com.vetesshoppers.VetHome.repositories.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Regras de horário da agenda: a clínica atende em horários fixos, de 1 hora cada,
 * e só existe uma consulta ativa (pendente) por data/horário, não importa o cliente.
 * Como os horários são fixos, "mesmo horário" é o mesmo que "horários que se sobrepõem".
 */
@Component
public class ConsultaValidador {

    // Mesmos horários que o app oferece hoje (12h às 16h). Para mudar o expediente, altere só aqui.
    public static final List<LocalTime> HORARIOS = List.of(
            LocalTime.of(12, 0), LocalTime.of(13, 0), LocalTime.of(14, 0),
            LocalTime.of(15, 0), LocalTime.of(16, 0));

    @Autowired
    private ConsultaRepository repository;

    /** Nova consulta. */
    public void validarNovo(LocalDate data, LocalTime horario) {
        validarSlot(data, horario);
        if (repository.existsByDataConsultaAndHorarioConsultaAndStatusConsulta(
                data, horario, StatusConsulta.pendente)) {
            throw conflito();
        }
    }

    /** Remarcação: ignora a própria consulta na checagem. */
    public void validarAlteracao(Long idConsulta, LocalDate data, LocalTime horario) {
        validarSlot(data, horario);
        if (repository.existsByDataConsultaAndHorarioConsultaAndStatusConsultaAndIdNot(
                data, horario, StatusConsulta.pendente, idConsulta)) {
            throw conflito();
        }
    }

    /** Horários livres da data (já sem os que passaram, se for hoje), no formato "HH:mm". */
    public List<String> horariosDisponiveis(LocalDate data) {
        Set<LocalTime> ocupados = repository
                .findAllByDataConsultaAndStatusConsulta(data, StatusConsulta.pendente).stream()
                .map(Consulta::getHorarioConsulta)
                .collect(Collectors.toSet());
        LocalDateTime agora = LocalDateTime.now();
        return HORARIOS.stream()
                .filter(h -> !ocupados.contains(h))
                .filter(h -> LocalDateTime.of(data, h).isAfter(agora))
                .map(LocalTime::toString)
                .toList();
    }

    private void validarSlot(LocalDate data, LocalTime horario) {
        if (data == null || horario == null) {
            throw new RegraDeNegocioException(HttpStatus.BAD_REQUEST, "Informe a data e o horário da consulta.");
        }
        if (!HORARIOS.contains(horario)) {
            String validos = HORARIOS.stream().map(LocalTime::toString).collect(Collectors.joining(", "));
            throw new RegraDeNegocioException(HttpStatus.BAD_REQUEST,
                    "Horário inválido. Horários de atendimento: " + validos + ".");
        }
        if (!LocalDateTime.of(data, horario).isAfter(LocalDateTime.now())) {
            throw new RegraDeNegocioException(HttpStatus.BAD_REQUEST, "Escolha uma data e horário futuros.");
        }
    }

    private RegraDeNegocioException conflito() {
        return new RegraDeNegocioException(HttpStatus.CONFLICT,
                "Esse horário já está reservado. Escolha outro horário.");
    }
}
