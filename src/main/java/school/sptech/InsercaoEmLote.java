package school.sptech;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class InsercaoEmLote {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/DataWings";
        String usuario = "root";
        String senha = "Ta22828931";

        String caminhoArquivo = "src/main/resources/Dados.xlsx";

        String sql = "INSERT INTO dados_tratados (sigla_empresa, numero_voo, codigo_autorizacao, codigo_tipo_linha," +
                " icao_origem, icao_destino, partida_prevista, partida_real, chegada_prevista, chegada_real," +
                " situacao_voo, codigo_justificativa, fk_usuario) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 1)";

        int batchSize = 1000;
        int count = 0;

        try (Connection conexao = DriverManager.getConnection(url, usuario, senha);
             PreparedStatement stmt = conexao.prepareStatement(sql);

             FileInputStream arquivo = new FileInputStream(new File(caminhoArquivo));
             Workbook workbook = new XSSFWorkbook(arquivo)) {

            conexao.setAutoCommit(false);

            Sheet sheet = workbook.getSheetAt(0);

            for (int i = 3; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);

                if (row == null) {
                    continue;
                }

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

                try {
                    siglaEmpresa = row.getCell(0).getStringCellValue();
                    numeroVoo = (int) row.getCell(1).getNumericCellValue();
                    codigoAutorizacao = (int) row.getCell(2).getNumericCellValue();
                    codigoTipoLinha = row.getCell(3).getStringCellValue();
                    icaoOrigem = row.getCell(4).getStringCellValue();
                    icaoDestino = row.getCell(5).getStringCellValue();

                    partidaPrevista = row.getCell(6).getLocalDateTimeCellValue();
                    partidaReal = row.getCell(7).getLocalDateTimeCellValue();
                    chegadaPrevista = row.getCell(8).getLocalDateTimeCellValue();
                    chegadaReal = row.getCell(9).getLocalDateTimeCellValue();

                    situacaoVoo = row.getCell(10).getStringCellValue();
                    codigoJustificativa = row.getCell(11).getStringCellValue();


                    stmt.setString(1, siglaEmpresa);

                    stmt.setInt(2, numeroVoo);

                    stmt.setInt(3, codigoAutorizacao);

                    stmt.setString(4, codigoTipoLinha);

                    stmt.setString(5, icaoOrigem);

                    stmt.setString(6, icaoDestino);


                    stmt.setObject(7, partidaPrevista);

                    stmt.setObject(8, partidaReal);

                    stmt.setObject(9, chegadaPrevista);

                    stmt.setObject(10, chegadaReal);

                    stmt.setString(11, situacaoVoo);

                    stmt.setString(12, codigoJustificativa);

                    stmt.addBatch();
                    count++;

                } catch (Exception e) {
                    System.err.printf("ERRO de tipo de célula na linha Excel %d: %s. Linha ignorada.%n", i + 1, e.getMessage());
                    continue;
                }

                if (count % batchSize == 0) {
                    stmt.executeBatch();
                    conexao.commit();
                    System.out.println("Lote de " + batchSize + " inserções executado. Total: " + count);
                }
            }


            if (count % batchSize != 0 && count > 0) {
                stmt.executeBatch();
            }

            conexao.commit();
            System.out.println("Total de " + count + " inserções concluídas!");

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Erro de SQL: " + e.getMessage());

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Erro ao ler o arquivo Excel: " + e.getMessage());
        }
    }
}
