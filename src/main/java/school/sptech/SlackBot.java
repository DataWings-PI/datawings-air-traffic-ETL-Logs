package school.sptech;

import com.slack.api.Slack;
import com.slack.api.methods.SlackApiException;
import org.springframework.jdbc.core.JdbcTemplate;


import java.io.IOException;
import java.util.List;

import static com.slack.api.model.block.Blocks.*;
import static com.slack.api.model.block.composition.BlockCompositions.markdownText;


public class SlackBot {

    private final Slack slackClient = Slack.getInstance();

    private static final String BOT_TOKEN = "";

        Conexao conexao = new Conexao();
        private final JdbcTemplate jdbcTemplate = new JdbcTemplate(conexao.getConexao());



    public void processarNotificacoes() {
        Integer status = obterStatusNotificacao(1);

        if (status == null || status == 0) {
            System.out.println("Notificações desativadas. Nada a enviar.");
            return;
        }

        int totalAtrasos = obterTotalAtrasos();
        int totalCancelados = obterTotalCancelamentos();

        String mensagemAtraso = gerarMensagemAtrasos(totalAtrasos);
        String mensagemCancelamento = gerarMensagemCancelamentos(totalCancelados);



        System.out.println("Mensagens enviadas com sucesso.");
    }

    public Integer obterStatusNotificacao(int usuarioId) {
        try {
            return jdbcTemplate.queryForObject(
                    "SELECT status_notificacao FROM slack WHERE fk_usuario = ? LIMIT 1",
                    Integer.class,
                    usuarioId
            );
        } catch (Exception e) {
            System.err.println("Erro ao buscar status de notificação: " + e.getMessage());
            return 0;
        }
    }


    public Integer obterStatusAtrasos(int usuarioId) {
        try {
            return jdbcTemplate.queryForObject(
                    "SELECT status_atraso FROM slack WHERE fk_usuario = ? LIMIT 1",
                    Integer.class,
                    usuarioId
            );
        } catch (Exception e) {
            System.err.println("Erro ao buscar status de atrasos: " + e.getMessage());
            return 0;
        }
    }


    public Integer obterStatusCancelamento(int usuarioId) {
        try {
            return jdbcTemplate.queryForObject(
                    "SELECT status_cancelamento FROM slack WHERE fk_usuario = ? LIMIT 1",
                    Integer.class,
                    usuarioId
            );
        } catch (Exception e) {
            System.err.println("Erro ao buscar status de cancelamentos: " + e.getMessage());
            return 0;
        }
    }

    public int obterTotalAtrasos() {
        return jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM voo WHERE tempo_atraso > 0 AND fk_empresa = 1",
                Integer.class
        );
    }

    public int obterTotalCancelamentos() {
        return jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM voo WHERE situacao_voo = 'CANCELADO' AND fk_empresa = 1",
                Integer.class
        );
    }

    public String gerarMensagemLogsErro(int total) {
        if (total == 0) return "Nenhum log do tipo ERRO registrado!";
        if (total == 1) return "Foi encontrado 1 log do tipo ERRO .\nAtenção recomendada.";
        if (total == 2) return "Foram encontrados 2 logs do tipo ERRO .\nAtenção necessária!";
        return "Muitos logs do tipo ERRO  detectados! (" + total + " no total)\nAlta atenção necessária!";
    }

    public String gerarMensagemLogsCarga(int total) {
        return "Quantidade de linhas inseridas (" + total + " no total)";
    }

    public String gerarMensagemAtrasos(int total) {
        if (total == 0) return "😄 Nenhum atraso registrado!";
        if (total == 1) return "🤔 Foi encontrado 1 atraso.\nAtenção recomendada.";
        if (total == 2) return "😥 Foram encontrados 2 atrasos.\nAtenção necessária!";
        return "😨😨 Muitos atrasos detectados! (" + total + " no total)\nAlta atenção necessária!";
    }

    public String gerarMensagemCancelamentos(int total) {
        if (total == 0) return "😄 Nenhum cancelamento registrado!";
        if (total == 1) return "🤔 Foi encontrado 1 cancelamento.\nAtenção recomendada.";
        if (total == 2) return "😥 Foram encontrados 2 cancelamentos.\nAtenção necessária!";
        return "😨😨 Múltiplos cancelamentos! (" + total + " no total)\nAlta atenção necessária!";
    }

    public void enviarMensagem(String texto, String canal, String titulo, String dataHora) {
        try {
            slackClient.methods(BOT_TOKEN)
                    .chatPostMessage(req -> req
                                    .channel(canal)
                                    .blocks(asBlocks(
                                            divider(),

                                            section(section -> section.fields(List.of(
                                                    markdownText(dataHora+""),
                                                    markdownText(titulo)
                                            ))),

                                            section(section -> section.text(markdownText(texto)))
                                    )
                            ));

            System.out.println("Mensagem enviada para o canal " + canal);

        } catch (SlackApiException | IOException e) {
            System.err.println("Erro ao enviar mensagem ao Slack: " + e.getMessage());
        }
    }
}

