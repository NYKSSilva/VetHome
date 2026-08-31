package br.com.vetesshoppers.VetHome.consulta.servicos;

public enum Servicos {
    exame(ExameType.class),
    vacina(VacinaType.class),
    atestado(null),
    microtipagem(null);

    public enum ExameType{
        exame_sangue,
        exame_urina
    }

    public enum VacinaType {
        antirrabica,
        gripe,
        polivalente,
        giardia
    }

    private final Class<?> tipoDetalhamento;

    Servicos(Class<?> tipoDetalhamento) {
        this.tipoDetalhamento = tipoDetalhamento;
    }

    public boolean temSubTipo() {
        return this.tipoDetalhamento != null;
    }

    public Class<?> getTipoDetalhamento() {
        return tipoDetalhamento;
    }
}
