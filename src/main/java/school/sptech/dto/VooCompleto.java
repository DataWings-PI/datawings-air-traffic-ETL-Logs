package school.sptech.dto;

import school.sptech.Leg_voosAtrasados;
import school.sptech.Voo;
import school.sptech.Rota;

import java.time.LocalDateTime;

public class VooCompleto {

    private final Voo voo;
    private final Rota rota;
    private final Leg_voosAtrasados legVoosAtrasados;
    private final String situacaoVoo;
    private final String justificativaCompleta;
    private final int tempoAtraso;
    private final int fkEmpresa = 1;
    private final String ufOrigem;
    private final String ufDestino;

    public VooCompleto(String siglaEmpresa, int numeroVoo, int codigoAutorizacao, String codigoTipoLinha,
                       String icaoOrigem, String icaoDestino,
                       LocalDateTime partidaPrevista, LocalDateTime partidaReal,
                       LocalDateTime chegadaPrevista, LocalDateTime chegadaReal,
                       String situacaoVoo, String codigoJustificativa) {

        this.voo = new Voo(siglaEmpresa, numeroVoo, codigoAutorizacao, codigoTipoLinha);
        this.rota = new Rota(icaoOrigem, icaoDestino);

        this.ufOrigem = this.rota.getUfOrigem();
        this.ufDestino = this.rota.getUfDestino();

        this.legVoosAtrasados = new Leg_voosAtrasados(partidaPrevista, partidaReal, chegadaPrevista, chegadaReal, codigoJustificativa);

        this.situacaoVoo = situacaoVoo;
        this.justificativaCompleta = Leg_voosAtrasados.getJustificativaCompleta(codigoJustificativa);
        this.tempoAtraso = Leg_voosAtrasados.calcularTempoAtraso(partidaPrevista, partidaReal, chegadaPrevista, chegadaReal);
    }


    public Voo getVoo() { return voo; }
    public Rota getRota() { return rota; }
    public Leg_voosAtrasados getLegVoosAtrasados() { return legVoosAtrasados; }
    public String getSituacaoVoo() { return situacaoVoo; }
    public String getJustificativaCompleta() { return justificativaCompleta; }
    public int getTempoAtraso() { return tempoAtraso; }
    public int getFkEmpresa() { return fkEmpresa; }
    public String getUfOrigem() {return ufOrigem;}
    public String getUfDestino() {return ufDestino;}
}