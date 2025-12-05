package school.sptech;

public class Voo {
    private final String sigla;
    private final int numeroVoo;
    private final int codigoAutorizacao;
    private final String codigoTipoLinha;

    public Voo(String sigla, int numeroVoo, int codigoAutorizacao, String codigoTipoLinha) {
        this.sigla = sigla;
        this.numeroVoo = numeroVoo;
        this.codigoAutorizacao = codigoAutorizacao;
        this.codigoTipoLinha = codigoTipoLinha;
    }

    public String getSigla() {
        return sigla;
    }
    public int getNumeroVoo() {
        return numeroVoo;
    }
    public int getCodigoAutorizacao() {
        return codigoAutorizacao;
    }
    public String getCodigoTipoLinha() {
        return codigoTipoLinha;
    }
}