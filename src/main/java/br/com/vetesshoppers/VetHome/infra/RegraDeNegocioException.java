package br.com.vetesshoppers.VetHome.infra;

import org.springframework.http.HttpStatus;

/** Erro de regra de negócio com o status HTTP que deve ser devolvido. */
public class RegraDeNegocioException extends RuntimeException {

    private final HttpStatus status;

    public RegraDeNegocioException(HttpStatus status, String mensagem) {
        super(mensagem);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
