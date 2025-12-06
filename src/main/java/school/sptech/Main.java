package school.sptech;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import school.sptech.client.S3Provider;
import school.sptech.dto.VooCompleto;
import software.amazon.awssdk.core.sync.ResponseTransformer;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;


import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) throws Exception {

        String bucket = "s3-raw-datawings-otavio";
        String keyVoos = "Dados.xlsx";


        String url = "jdbc:mysql://localhost:3306/datawings";
        String usuario = "root";
        String senha = "";

        String sql = "INSERT INTO voo (sigla_empresa, numero_voo, codigo_autorizacao, codigo_tipo_linha," +
                " icao_origem, icao_destino,uf_origem, uf_destino, partida_prevista, partida_real, chegada_prevista, chegada_real," +
                " situacao_voo, codigo_justificativa, justificativa, tempo_atraso, fk_empresa) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 1)";

        String sqlLog = "INSERT INTO log_java(categoria, data_hora_registro, mensagem) VALUES(?, ?, ?)";
        String sqlLogException = sqlLog;

        int batchSize = 1000;
        int count = 0;

        Connection conexao1 = DriverManager.getConnection(url, usuario, senha);
        conexao1.setAutoCommit(false);
        PreparedStatement stmt3 = conexao1.prepareStatement(sqlLogException);

        int countLog = 0;
        DateTimeFormatter formatacao = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


        try (Connection conexao = DriverManager.getConnection(url, usuario, senha);
             PreparedStatement stmt = conexao.prepareStatement(sql);
             PreparedStatement stmt2 = conexao.prepareStatement(sqlLog);

             S3Client s3Client = new S3Provider().getS3Client();
             InputStream voos = s3Client.getObject(
                     GetObjectRequest.builder().bucket(bucket).key(keyVoos).build(),
                     ResponseTransformer.toInputStream());
             Workbook workbook = new XSSFWorkbook(voos);) {

            System.out.printf("  _____        _     __          ___                 \n" +
                    " |  __ \\      | |    \\ \\        / (_)                \n" +
                    " | |  | | __ _| |_ __ \\ \\  /\\  / / _ _ __   __ _ ___ \n" +
                    " | |  | |/ _` | __/ _` \\ \\/  \\/ / | | '_ \\ / _` / __|\n" +
                    " | |__| | (_| | || (_| |\\  /\\  /  | | | | | (_| \\__ \\\n" +
                    " |_____/ \\__,_|\\__\\__,_| \\/  \\/   |_|_| |_|\\__, |___/\n" +
                    "                                            __/ |    \n" +
                    "                                           |___/     ");


            Thread.sleep(3000);
            conexao.setAutoCommit(false);

            Sheet sheet = workbook.getSheetAt(0);

            for (int i = 3; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);

                if (row == null) {
                    continue;
                }
                try {
                    VooCompleto voo = VooImportador.extrairVoo(row);

                    VooImportador.setStatementParameters(stmt, voo);

                    stmt.addBatch();
                    count++;

                } catch (IllegalArgumentException e) {
                    System.err.printf("Linha %d IGNORADA: %s\n", i + 1, e.getMessage());

                    String categoria = "ERRO";
                    LocalDateTime dataHora = LocalDateTime.now();
                    String dataHoraFormatada = dataHora.format(formatacao);
                    String mensagem = String.format("LINHA IGNORADA (Excel %d): %s", i + 1, e.getMessage());

                    stmt2.setObject(1, categoria);
                    stmt2.setObject(2, dataHoraFormatada);
                    stmt2.setObject(3, mensagem);

                    stmt2.addBatch();
                    countLog++;
                    continue;

                } catch (Exception e) {
                    System.err.printf("ERRO de tipo de célula na linha Excel %d: %s. Linha ignorada.%n", i + 1, e.getMessage());

                    String categoria = "ERRO";
                    LocalDateTime dataHora = LocalDateTime.now();
                    String dataHoraFormatada = dataHora.format(formatacao);

                    String mensagem = String.format("%s DE TIPO (Excel %d): %s. Linha ignorada.", categoria, i + 1, e.getMessage());

                    stmt2.setObject(1, categoria);
                    stmt2.setObject(2, dataHoraFormatada);
                    stmt2.setObject(3, mensagem);

                    stmt2.addBatch();
                    countLog++;
                    continue;
                }

                if (count % batchSize == 0) {
                    System.out.println("Lote de " + batchSize + " inserções executado. Total: " + count);
                    String categoria = "CARGA";
                    LocalDateTime dataHora = LocalDateTime.now();
                    String dataHoraFormatada = dataHora.format(formatacao);

                    String mensagem = "Lote de " + batchSize + " inserções executado. Total: " + count;

                    stmt2.setObject(1, categoria);
                    stmt2.setObject(2, dataHoraFormatada);
                    stmt2.setObject(3, mensagem);

                    stmt2.addBatch();
                    countLog++;

                    stmt.executeBatch();
                    stmt2.executeBatch();
                    conexao.commit();
                }
            }


            if (count % batchSize != 0 && count > 0) {
                stmt.executeBatch();
            }

            String categoria = "CARGA";
            LocalDateTime dataHora = LocalDateTime.now();
            String dataHoraFormatada = dataHora.format(formatacao);

            System.out.println("Total de " + count + " inserções concluídas!\n");
            String mensagem = "Total de " + count + " inserções concluídas!";

            stmt2.setObject(1, categoria);
            stmt2.setObject(2, dataHoraFormatada);
            stmt2.setObject(3, mensagem);

            stmt2.addBatch();
            countLog++;

            if (countLog > 0) {
                stmt2.executeBatch();
            }
            conexao.commit();


        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Erro de SQL: " + e.getMessage());

            String categoria = "ERRO";
            LocalDateTime dataHora = LocalDateTime.now();
            String dataHoraFormatada = dataHora.format(formatacao);
            String mensagem = String.format("%s de SQL fatal: %s", categoria, e.getMessage());

            stmt3.setObject(1, categoria);
            stmt3.setObject(2, dataHoraFormatada);
            stmt3.setObject(3, mensagem);
            stmt3.addBatch();
            countLog++;

            if (countLog > 0) {
                try {
                    stmt3.executeBatch();
                    conexao1.commit();
                } catch (SQLException logEx) {
                    System.err.println("ERRO fatal: Não foi possível salvar os logs no banco de dados: " + logEx.getMessage());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Erro ao ler o arquivo Excel: " + e.getMessage());

            if (countLog > 0) {
                try {
                    stmt3.executeBatch();
                    conexao1.commit();
                } catch (SQLException logEx) {
                    System.err.println("ERRO fatal: Não foi possível salvar os logs no banco de dados após IOException: " + logEx.getMessage());
                }
            }

        } finally {
            if (stmt3 != null) stmt3.close();
            if (conexao1 != null) conexao1.close();
        }
    }
}
