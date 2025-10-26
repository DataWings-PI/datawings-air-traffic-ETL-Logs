package school.sptech;

import java.time.LocalDateTime;

public class Rotas {
 private Integer id;
 private String siglaEmpresa;
 private Integer numeroVoo;
 private Integer codigoAutorizacao;
 private String codigoTipoLinha;
 private String icaoOrigem;
 private String icaoDestino;
 private LocalDateTime partidaPrevista;
 private LocalDateTime partidaReal;
 private LocalDateTime chegadaPrevista;
 private LocalDateTime chegadaReal;
 private String situacaoVoo;
 private String codigoJustificativa;


    public Rotas(String siglaEmpresa, Integer numeroVoo, Integer codigoAutorizacao, String codigoTipoLinha, String icaoOrigem, String icaoDestino, LocalDateTime partidaPrevista, LocalDateTime partidaReal, LocalDateTime chegadaPrevista, LocalDateTime chegadaReal, String situacaoVoo, String codigoJustificativa) {
        this.siglaEmpresa = siglaEmpresa;
        this.numeroVoo = numeroVoo;
        this.codigoAutorizacao = codigoAutorizacao;
        this.codigoTipoLinha = codigoTipoLinha;
        this.icaoOrigem = icaoOrigem;
        this.icaoDestino = icaoDestino;
        this.partidaPrevista = partidaPrevista;
        this.partidaReal = partidaReal;
        this.chegadaPrevista = chegadaPrevista;
        this.chegadaReal = chegadaReal;
        this.situacaoVoo = situacaoVoo;
        this.codigoJustificativa = codigoJustificativa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSiglaEmpresa() {
        return siglaEmpresa;
    }

    public void setSiglaEmpresa(String siglaEmpresa) {
        this.siglaEmpresa = siglaEmpresa;
    }

    public Integer getNumeroVoo() {
        return numeroVoo;
    }

    public void setNumeroVoo(Integer numeroVoo) {
        this.numeroVoo = numeroVoo;
    }

    public Integer getCodigoAutorizacao() {
        return codigoAutorizacao;
    }

    public void setCodigoAutorizacao(Integer codigoAutorizacao) {
        this.codigoAutorizacao = codigoAutorizacao;
    }

    public String getCodigoTipoLinha() {
        return codigoTipoLinha;
    }

    public void setCodigoTipoLinha(String codigoTipoLinha) {
        this.codigoTipoLinha = codigoTipoLinha;
    }

    public String getIcaoOrigem() {
        return icaoOrigem;
    }

    public void setIcaoOrigem(String icaoOrigem) {
        this.icaoOrigem = icaoOrigem;
    }

    public String getIcaoDestino() {
        return icaoDestino;
    }

    public void setIcaoDestino(String icaoDestino) {
        this.icaoDestino = icaoDestino;
    }

    public LocalDateTime getPartidaPrevista() {
        return partidaPrevista;
    }

    public void setPartidaPrevista(LocalDateTime partidaPrevista) {
        this.partidaPrevista = partidaPrevista;
    }

    public LocalDateTime getPartidaReal() {
        return partidaReal;
    }

    public void setPartidaReal(LocalDateTime partidaReal) {
        this.partidaReal = partidaReal;
    }

    public LocalDateTime getChegadaPrevista() {
        return chegadaPrevista;
    }

    public void setChegadaPrevista(LocalDateTime chegadaPrevista) {
        this.chegadaPrevista = chegadaPrevista;
    }

    public LocalDateTime getChegadaReal() {
        return chegadaReal;
    }

    public void setChegadaReal(LocalDateTime chegadaReal) {
        this.chegadaReal = chegadaReal;
    }

    public String getSituacaoVoo() {
        return situacaoVoo;
    }

    public void setSituacaoVoo(String situacaoVoo) {
        this.situacaoVoo = situacaoVoo;
    }

    public String getCodigoJustificativa() {
        return codigoJustificativa;
    }

    public void setCodigoJustificativa(String codigoJustificativa) {
        this.codigoJustificativa = codigoJustificativa;
    }
}