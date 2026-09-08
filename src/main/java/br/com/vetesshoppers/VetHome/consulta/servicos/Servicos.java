package br.com.vetesshoppers.VetHome.consulta.servicos;

public enum Servicos {
    exameDog(ExameDogType.class),
    exameCat(ExameCatType.class),
    vacinaDog(VacinaDogType.class),
    VacinaCat(VacinaCatType.class),
    atestado(null),
    microtipagem(null);

    public enum ExameDogType{
        exame_sangue,
        exame_urina
    }

    public enum ExameCatType{
        exame_sangue,
        exame_urina
    }

    public enum VacinaDogType {
        antirrabica,
        gripe,
        polivalente,
        giardia
    }

    public enum VacinaCatType {
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
