package br.com.vetesshoppers.VetHome.infra;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

/** Todas as respostas de erro tratadas aqui têm o formato {"mensagem": "..."}. */
@RestControllerAdvice
public class TratadorDeErros {

    public record Erro(String mensagem) {
    }

    @ExceptionHandler(RegraDeNegocioException.class)
    public ResponseEntity<Erro> regraDeNegocio(RegraDeNegocioException ex) {
        return ResponseEntity.status(ex.getStatus()).body(new Erro(ex.getMessage()));
    }

    // Rede de segurança: duas pessoas reservando o mesmo horário no mesmo instante.
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Erro> integridade(DataIntegrityViolationException ex) {
        String causa = String.valueOf(ex.getMostSpecificCause().getMessage());
        if (causa.contains("uk_consulta_slot_ativo")) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(new Erro("Esse horário acabou de ser reservado por outro cliente. Escolha outro horário."));
        }
        throw ex; // outros erros de integridade continuam como antes
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Erro> validacao(MethodArgumentNotValidException ex) {
        String mensagem = ex.getBindingResult().getFieldErrors().stream()
                .map(e -> e.getField() + ": " + e.getDefaultMessage())
                .collect(Collectors.joining("; "));
        return ResponseEntity.badRequest().body(new Erro(mensagem));
    }
}
