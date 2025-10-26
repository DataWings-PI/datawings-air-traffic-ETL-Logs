package school.sptech;

import org.springframework.jdbc.core.JdbcTemplate;


public class RotasDao {

    private final JdbcTemplate jdbcTemplate;

    public RotasDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    void save(Rotas rota){
        if(rota.getId() == null){
            jdbcTemplate.update("INSERT INTO dados_tratados (sigla_empresa, numero_voo, codigo_autorizacao, codigo_tipo_linha," +
                            " icao_origem, icao_destino, partida_prevista, partida_real, chegada_prevista, chegada_real," +
                            " situacao_voo, codigo_justificativa, fk_usuario) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 1)",
                    rota.getSiglaEmpresa(), rota.getNumeroVoo(), rota.getCodigoAutorizacao(), rota.getCodigoTipoLinha(),
                    rota.getIcaoOrigem(), rota.getIcaoDestino(), rota.getPartidaPrevista(), rota.getPartidaReal(),
                    rota.getChegadaPrevista(), rota.getChegadaReal(), rota.getSituacaoVoo(), rota.getCodigoJustificativa()
                    );

        }else {
            jdbcTemplate.update(
                    "UPDATE dados_tratados SET sigla_empresa = ?, numero_voo = ?, codigo_autorizacao = ?, codigo_tipo_linha = ?" +
                            " icao_origem = ?, icao_destino = ?, partida_prevista = ?, partida_real = ?, chegada_prevista = ?" +
                            " chegada_real = ?, situacao_voo = ?, codigo_justificativa = ? WHERE id = ?",
                   rota.getSiglaEmpresa(), rota.getNumeroVoo(), rota.getCodigoAutorizacao(), rota.getCodigoTipoLinha(),
                    rota.getIcaoOrigem(), rota.getIcaoDestino(), rota.getPartidaPrevista(), rota.getPartidaReal(),
                    rota.getChegadaPrevista(), rota.getChegadaReal(), rota.getSituacaoVoo(), rota.getCodigoJustificativa());
        }
    }


    void deleteById(Integer id){
        jdbcTemplate.update("DELETE FROM musica WHERE id = ?", id);
    }

}
