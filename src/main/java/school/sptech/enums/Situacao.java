package school.sptech.enums;

public enum Situacao {
    CANCELADO("CANCELADO"),
    REALIZADO("REALIZADO");

    private final String situacao;

    Situacao(String situacao) {
        this.situacao = situacao;
    }

    public String getSituacao() {
        return situacao;
    }
}
