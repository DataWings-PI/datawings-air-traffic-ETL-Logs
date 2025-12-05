package school.sptech;

import org.apache.poi.ss.usermodel.Row;
import school.sptech.dto.VooCompleto;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class VooImportador {

    public static VooCompleto extrairVoo(Row row) throws IllegalArgumentException {


        String siglaEmpresa = row.getCell(0).getStringCellValue();
        Integer numeroVoo = (int) row.getCell(1).getNumericCellValue();
        Integer codigoAutorizacao = (int) row.getCell(2).getNumericCellValue();
        String codigoTipoLinha = row.getCell(3).getStringCellValue();
        String icaoOrigem = row.getCell(4).getStringCellValue();
        String icaoDestino = row.getCell(5).getStringCellValue();

        LocalDateTime partidaPrevista = row.getCell(6).getLocalDateTimeCellValue();
        LocalDateTime partidaReal = row.getCell(7).getLocalDateTimeCellValue();
        LocalDateTime chegadaPrevista = row.getCell(8).getLocalDateTimeCellValue();
        LocalDateTime chegadaReal = row.getCell(9).getLocalDateTimeCellValue();
        String situacaoVoo = row.getCell(10).getStringCellValue();
        String codigoJustificativa = row.getCell(11).getStringCellValue();

        if(situacaoVoo.contains("CANCELADO")){
            if (siglaEmpresa == null || siglaEmpresa.trim().isEmpty() ||
                    codigoTipoLinha == null || codigoTipoLinha.trim().isEmpty() ||
                    icaoOrigem == null || icaoOrigem.trim().isEmpty() ||
                    icaoDestino == null || icaoDestino.trim().isEmpty() ||
                    situacaoVoo == null || situacaoVoo.trim().isEmpty() ||
                    codigoJustificativa == null || codigoJustificativa.trim().isEmpty() ||
                    numeroVoo == null || numeroVoo <= 0 ||
                    codigoAutorizacao == null ||
                    partidaPrevista == null || partidaReal == null ||
                    chegadaPrevista == null || chegadaReal == null) {

                partidaReal = partidaPrevista;
                chegadaReal = chegadaPrevista;
            }
        }else{
            if (siglaEmpresa == null || siglaEmpresa.trim().isEmpty() ||
                    codigoTipoLinha == null || codigoTipoLinha.trim().isEmpty() ||
                    icaoOrigem == null || icaoOrigem.trim().isEmpty() ||
                    icaoDestino == null || icaoDestino.trim().isEmpty() ||
                    situacaoVoo == null || situacaoVoo.trim().isEmpty() ||
                    codigoJustificativa == null || codigoJustificativa.trim().isEmpty() ||
                    numeroVoo == null || numeroVoo <= 0 ||
                    codigoAutorizacao == null ||
                    partidaPrevista == null || partidaReal == null ||
                    chegadaPrevista == null || chegadaReal == null) {

                throw new IllegalArgumentException("Dados críticos nulos/vazios detectados.");
            }
        }

        return new VooCompleto(
                siglaEmpresa, numeroVoo, codigoAutorizacao, codigoTipoLinha,
                icaoOrigem, icaoDestino,
                partidaPrevista, partidaReal,
                chegadaPrevista, chegadaReal,
                situacaoVoo, codigoJustificativa
        );
    }

    public static void setStatementParameters(PreparedStatement stmt, VooCompleto vooCompleto) throws SQLException {


        stmt.setString(1, vooCompleto.getVoo().getSigla());
        stmt.setInt(2, vooCompleto.getVoo().getNumeroVoo());
        stmt.setInt(3, vooCompleto.getVoo().getCodigoAutorizacao());
        stmt.setString(4, vooCompleto.getVoo().getCodigoTipoLinha());
        stmt.setString(5, vooCompleto.getRota().getIcaoOrigem());
        stmt.setString(6, vooCompleto.getRota().getIcaoDestino());
        stmt.setObject(7, vooCompleto.getLegVoosAtrasados().getPartidaPrevista());
        stmt.setObject(8, vooCompleto.getLegVoosAtrasados().getPartidaReal());
        stmt.setObject(9, vooCompleto.getLegVoosAtrasados().getChegadaPrevista());
        stmt.setObject(10, vooCompleto.getLegVoosAtrasados().getChegadaReal());
        stmt.setString(11, vooCompleto.getSituacaoVoo().toUpperCase());
        stmt.setString(12, vooCompleto.getLegVoosAtrasados().getCodigoJustificativa());
        stmt.setString(13, vooCompleto.getJustificativaCompleta());
        stmt.setInt(14, vooCompleto.getTempoAtraso());

    }
}