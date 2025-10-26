package school.sptech;

public class ConversorJustificativa {
    public static String getJustificativaCompleta(String codigo) {

        if (codigo == null || codigo.trim().isEmpty()) {
            return "JUSTIFICATIVA DESCONHECIDA - CÓDIGO VAZIO/NULO";
        }

        String sigla = codigo.trim().toUpperCase();

        return switch (sigla) {

            //ATRASOS DE VÔOS
            case "AA" -> "ATRASO AEROPORTO DE ALTERNATIVA – ORDEM TÉCNICA";
            case "AF" -> "FACILIDADES DO AEROPORTO - RESTRIÇÕES DE APOIO";
            case "AG" -> "MIGRAÇÃO/ALFÂNDEGA/SAÚDE";
            case "AI" -> "AEROPORTO DE ORIGEM INTERDITADO";
            case "AJ" -> "AEROPORTO DE DESTINO INTERDITADO";
            case "AM" -> "ATRASO AEROPORTO DE ALTERNATIVA – CONDIÇÕES METEOROLÓGICAS";
            case "AS" -> "SEGURANÇA/PAX/CARGA/ALARME";
            case "AR" -> "AEROPORTO COM RESTRIÇÕES OPERACIONAIS";
            case "AT" -> "LIBERAÇÃO SERV. TRAFEGO AÉREO/ANTECIPAÇÃO";
            case "DF" -> "AVARIA DURANTE OPERAÇÕES EM VÔO";
            case "DG" -> "AVARIA DURANTE OPERAÇÕES EM SOLO";
            case "FP" -> "PLANO DE VÔO - APROVAÇÃO";
            case "GF" -> "ABASTECIMENTO/DESTANQUEIO";
            case "MA" -> "FALHA EQUIPO AUTOMOTIVO E DE ATENDIMENTO DE PAX";
            case "MX" -> "ATRASOS NÃO ESPECÍFICOS – OUTROS";
            case "OA" -> "AUTORIZADO";
            case "RA" -> "CONEXÃO DE AERONAVE";
            case "RI" -> "CONEXÃO AERONAVE/VOLTA – VÔO DE IDA NÃO PENALIZADO - AEROPORTO INTERDITADO";
            case "RM" -> "CONEXÃO AERONAVE/VOLTA – VÔO DE IDA NÃO PENALIZADO - CONDIÇÕES METEOROLÓGICAS";
            case "TC" -> "TROCA DE AERONAVE";
            case "TD" -> "DEFEITOS DA AERONAVE";
            case "WA" -> "ALTERNATIVA ABAIXO DOS LIMITES";
            case "WI" -> "DEGELO E REMOÇÃO DE NEVE E/OU LAMA EM AERONAVE";
            case "WR" -> "ATRASO DEVIDO RETORNO – CONDIÇÕES METEOROLÓGICAS";
            case "WO" -> "AEROPORTO ORIGEM ABAIXO DOS LIMITES";
            case "WP" -> "ATRASO DEVIDO RETORNO – ORDEM TÉCNICA";
            case "WT" -> "AEROPORTO DESTINO ABAIXO DOS LIMITES";
            case "WS" -> "REMOÇÃO GELO/ÁGUA/LAMA/AREIA-EM AEROPORTO";

            //CANCELAMENTOS DE VÔOS OU ESCALAS
            case "XA" -> "PROGRAMADO – FERIADO NACIONAL";
            case "XB" -> "AUTORIZADO (CANCELAMENTO)";
            case "XI" -> "DEVIDO AEROPORTO DE ORIGEM INTERDITADO (CANCELAMENTO)";
            case "XJ" -> "DEVIDO AEROPORTO DE DESTINO INTERDITADO (CANCELAMENTO)";
            case "XL" -> "FALTA PAX COM PASSAGEM MARCADA – ( APENAS PARA AS LINHAS AÉREAS DOMÉSTICAS REGIONAIS)";
            case "XM" -> "CANCELAMENTO – CONEXÃO AERONAVE/VOLTA – VÔO DE IDA CANCELADO – AEROPORTO INTERDITADO";
            case "XN" -> "CANCELAMENTO POR MOTIVOS TÉCNICOS – OPERACIONAIS";
            case "XO" -> "CANCELAMENTO – AEROPORTO ORIGEM ABAIXO LIMITES";
            case "XT" -> "CANCELAMENTO – AEROPORTO DESTINO ABAIXO LIMITES";
            case "XR" -> "CANCELAMENTO DE VÔOS OPERADOS EM “CODE SHARING”";
            case "XS" -> "CANCELAMENTO – CONEXÃO AERONAVE/VOLTA – VÔO DE IDA CANCELADO – CONDIÇÕES METEOROLÓGICAS";

            //ALTERAÇÕES DE VÔOS/ESCALAS
            case "ST" -> "INCLUSÃO DE ETAPA DEVIDO CANCELAMENTO DE ESCALAS PREVISTAS – ( EXCLUSIVO PARA LINHAS SUPLEMENTADAS)";
            case "IR" -> "INCLUSÃO DE ETAPA (AEROPORTO DE ALTERNATIVA) DEVIDO A UM VÔO ESPECIAL RETORNO";
            case "VR" -> "VÔO ESPECIAL DE RETORNO (EXCLUSIVO PARA RETORNO AO AEROPORTO DE ORIGEM)";
            case "VE" -> "ESPECÍFICO PARA VÔO ESPECIAL DE EXPERIÊNCIA";
            case "VI" -> "ESPECÍFICO PARA VÔO ESPECIAL DE INSTRUÇÃO";

            //ALTERAÇÕES DE HORÁRIOS
            case "HA" -> "AUTORIZADA (ALTERAÇÃO DE HORÁRIO)";
            case "HB" -> "OPERAÇÃO DE VÔO COM MAIS DE 04 HORAS DE ATRASO - PANE AERONAVE";
            case "HC" -> "OPERAÇÃO DE VÔO COM MAIS DE 04 HORAS DE ATRASO - AEROPORTO INTERDITADO";
            case "HD" -> "ANTECIPAÇÃO DE HORÁRIO AUTORIZADA";
            case "HI" -> "ANTECIPAÇÃO DE HORÁRIO AUTORIZADA – ESPECÍFICO VÔOS INTERNACIONAIS";


            default -> "JUSTIFICATIVA DESCONHECIDA";
        };
    }
}
