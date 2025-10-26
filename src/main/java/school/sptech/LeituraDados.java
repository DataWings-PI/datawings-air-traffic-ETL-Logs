package school.sptech;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LeituraDados {



    public LeituraDados() {
    }

    public List<Rotas> lerRotas(String caminhoArquivo, RotasDao rotasDao) throws IOException {

        Workbook workbook = new XSSFWorkbook(caminhoArquivo);

        Sheet sheet = workbook.getSheetAt(0);
        List<Rotas> rotas = new ArrayList<>();
        Integer id;
        String siglaEmpresa;
        Integer numeroVoo;
        Integer codigoAutorizacao;
        String codigoTipoLinha;
        String icaoOrigem;
        String icaoDestino;
        LocalDateTime partidaPrevista;
        LocalDateTime partidaReal;
        LocalDateTime chegadaPrevista;
        LocalDateTime chegadaReal;
        String situacaoVoo;
        String codigoJustificativa;

        for (int i = 3; i <= sheet.getLastRowNum(); i++) {
            // Acessando a primeira linha da planilha
            Row row = sheet.getRow(i);

            // Acessando a primeira célula da linha

            Cell cellSigla = row.getCell(0);
            siglaEmpresa = cellSigla.getStringCellValue();

            Cell cellNumeroVoo = row.getCell(1);
            numeroVoo = (int) cellNumeroVoo.getNumericCellValue();

            Cell cellCodigoAutorizacao = row.getCell(2);
            codigoAutorizacao = (int) cellCodigoAutorizacao.getNumericCellValue();

            Cell cellTipoLinha = row.getCell(3);
            codigoTipoLinha = cellTipoLinha.getStringCellValue();


            Cell cellIcaoOrigem = row.getCell(4);
            icaoOrigem = cellIcaoOrigem.getStringCellValue();

            Cell cellIcaoDestino = row.getCell(5);
            icaoDestino = cellIcaoDestino.getStringCellValue();

            Cell cellPartidaPrevista = row.getCell(6);
            partidaPrevista = cellPartidaPrevista.getLocalDateTimeCellValue();

            Cell cellPartidaReal = row.getCell(7);
            partidaReal = cellPartidaReal.getLocalDateTimeCellValue();

            Cell cellChegadaPrevista = row.getCell(8);
            chegadaPrevista = cellChegadaPrevista.getLocalDateTimeCellValue();

            Cell cellChegadaReal = row.getCell(9);
            chegadaReal = cellChegadaReal.getLocalDateTimeCellValue();

            Cell cellSitucaoVoo = row.getCell(10);
            situacaoVoo = cellSitucaoVoo.getStringCellValue();

            Cell cellCodigoJustificativa = row.getCell(11);
            codigoJustificativa = cellCodigoJustificativa.getStringCellValue();

        Rotas novaRota = new Rotas(siglaEmpresa, numeroVoo, codigoAutorizacao, codigoTipoLinha, icaoOrigem, icaoDestino, partidaPrevista, partidaReal, chegadaPrevista, chegadaReal, situacaoVoo, codigoJustificativa);

        rotasDao.save(novaRota);

        }

        return rotas;
    }
}

