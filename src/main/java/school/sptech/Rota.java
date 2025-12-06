package school.sptech;

public class Rota {

    private final String icaoOrigem;
    private final String icaoDestino;
    private final String ufOrigem;
    private final String ufDestino;

    public Rota(String icaoOrigem, String icaoDestino) {
        this.icaoOrigem = icaoOrigem;
        this.icaoDestino = icaoDestino;
        this.ufOrigem = getLocalizacao(icaoOrigem);
        this.ufDestino = getLocalizacao(icaoDestino);
    }

    public String getIcaoOrigem() {
        return icaoOrigem;
    }

    public String getIcaoDestino() {
        return icaoDestino;
    }

    public String getUfOrigem() {
        return ufOrigem;
    }

    public String getUfDestino() {
        return ufDestino;
    }

    public static String getLocalizacao(String codigo) {

        if (codigo == null || codigo.trim().isEmpty()) {
            return "LOCALIZAÇÃO DESCONHECIDA - CÓDIGO VAZIO/NULO";
        }

        String sigla = codigo.trim().toUpperCase();

        return switch (sigla) {

            case "SBPA" -> "RS";
            case "SBGV" -> "MG";
            case "SBZM" -> "MG";
            case "SBME" -> "PA";
            case "SBSM" -> "RS";
            case "SWLC" -> "MT";
            case "SBCX" -> "RS";
            case "SBFL" -> "SC";
            case "SBNF" -> "SC";
            case "SBIL" -> "BA";
            case "SBSG" -> "RN";
            case "SBJV" -> "SC";
            case "SBVC" -> "BA";
            case "SBIP" -> "MG";
            case "SBPF" -> "RS";
            case "SBCB" -> "RJ";
            case "SWSI" -> "MT";
            case "SBMK" -> "MG";
            case "SBVH" -> "RO";
            case "SBRP" -> "SP";
            case "SBCP" -> "RJ";
            case "SBOV" -> "MG";
            case "SBHT" -> "PA";
            case "SBTE" -> "PI";
            case "SBIH" -> "PA";
            case "SBUR" -> "MG";
            case "SBAQ" -> "MG";
            case "SBDN" -> "SP";
            case "SBAU" -> "SP";
            case "SBML" -> "PE";
            case "SBAE" -> "RS";
            case "SBJI" -> "MT";
            case "SBTB" -> "AM";
            case "SBCH" -> "SC";
            case "SBCT" -> "PR";
            case "SBCA" -> "PR";
            case "SBLO" -> "PR";
            case "SBMG" -> "PR";
            case "SBFI" -> "PR";
            case "SBGR" -> "SP";
            case "SBSP" -> "SP";
            case "SBKP" -> "SP";
            case "SBSR" -> "SP";
            case "SBMT" -> "SP";
            case "SBGL" -> "RJ";
            case "SWRD" -> "RO";
            case "SBPJ" -> "PA";
            case "SBPK" -> "SP";
            case "SBTG" -> "PA";
            case "SBCR" -> "MS";
            case "SBRJ" -> "RJ";
            case "SBCF" -> "MG";
            case "SBBH" -> "MG";
            case "SBUL" -> "MG";
            case "SBVT" -> "ES";
            case "SBBR" -> "DF";
            case "SBGO" -> "GO";
            case "SBLE" -> "SC";
            case "SWLB" -> "AM";
            case "SWCA" -> "PA";
            case "SBUF" -> "BA";
            case "SNPD" -> "AL";
            case "SNVB" -> "MT";
            case "SNTF" -> "SP";
            case "SBTT" -> "PR";
            case "SBIZ" -> "MA";
            case "SBAX" -> "BA";
            case "SBFN" -> "PE";
            case "SBTU" -> "SC";
            case "SBPB" -> "PR";
            case "SBCM" -> "SC";
            case "SNJD" -> "BA";
            case "SNBR" -> "BA";
            case "SWKO" -> "RO";
            case "SWPI" -> "PA";
            case "SDOW" -> "SP";
            case "SBQV" -> "BA";
            case "SBCG" -> "MS";
            case "SBDO" -> "MS";
            case "SBCY" -> "MT";
            case "SBSV" -> "BA";
            case "SBPS" -> "BA";
            case "SBRF" -> "PE";
            case "SBPL" -> "PE";
            case "SBFZ" -> "CE";
            case "SBMA" -> "PA";
            case "SNDC" -> "CE";
            case "SBTF" -> "AM";
            case "SWEI" -> "AM";
            case "SWGN" -> "RO";
            case "SBUA" -> "MT";
            case "SBCJ" -> "PA";
            case "SBNT" -> "RN";
            case "SBJP" -> "PB";
            case "SBKG" -> "PB";
            case "SBMO" -> "AL";
            case "SBJU" -> "CE";
            case "SBRD" -> "MT";
            case "SWHT" -> "GO";
            case "SBUB" -> "MG";
            case "SBBQ" -> "MG";
            case "SBBW" -> "SP";
            case "SBAC" -> "SC";
            case "SBAR" -> "SE";
            case "SBSL" -> "MA";
            case "SBAT" -> "SP";
            case "SBCN" -> "RO";
            case "SSKW" -> "MT";
            case "SBEG" -> "AM";
            case "SBBE" -> "PA";
            case "SBMD" -> "RS";
            case "SBSN" -> "PA";
            case "SBCZ" -> "AC";
            case "SBRB" -> "AC";
            case "SBPV" -> "RO";
            case "SBBV" -> "RR";
            case "SSPS" -> "TO";
            case "SBMQ" -> "AP";
            case "GVNP" -> "Guiné-Bissau (Bissau)";
            case "SELT" -> "Equador (Latacunga)";
            case "TBPB" -> "Barbados (Bridgetown)";
            case "SVVA" -> "Venezuela (Porlamar)";
            case "KEWR" -> "EUA (Newark)";
            case "KIAH" -> "EUA (Houston)";
            case "KORD" -> "EUA (Chicago)";
            case "KIAD" -> "EUA (Washington D.C.)";
            case "LPPR" -> "Portugal (Porto)";
            case "TNCC" -> "Curaçao (Willemstad)";
            case "ZBAA" -> "China (Beijing)";
            case "TJSJ" -> "Porto Rico (San Juan)";
            case "KJFK" -> "EUA (New York)";
            case "CYYZ" -> "Canadá (Toronto)";
            case "LIMC" -> "Itália (Milão)";
            case "LIRF" -> "Itália (Roma)";
            case "SABE" -> "Argentina (Bs As Aeroparque)";
            case "KFLL" -> "EUA (Fort Lauderdale)";
            case "EGLL" -> "Reino Unido (Londres)";
            case "SLCB" -> "Bolívia (Santa Cruz)";
            case "ELLX" -> "Luxemburgo";
            case "KDTW" -> "EUA (Detroit)";
            case "OMAA" -> "EAU (Abu Dhabi)";
            case "MDPC" -> "Rep. Dominicana (Punta Cana)";
            case "RKSI" -> "Coreia do Sul (Seul)";
            case "OTBD" -> "Catar (Doha Antigo)";
            case "SANT" -> "Argentina (Santa Ana)";
            case "DXXX" -> "Inválido";
            case "GOOY" -> "Inválido";
            case "SEQU" -> "Equador (Antigo Quito)";
            case "MMGL" -> "México (Guadalajara)";
            case "FAJS" -> "África do Sul (Joanesburgo)";
            case "LEBL" -> "Espanha (Barcelona)";
            case "SKRG" -> "Colômbia (Bucaramanga)";
            case "OMDW" -> "EAU (Dubai)";
            case "TJBQ" -> "Porto Rico (Aguadilla)";
            case "EHBK" -> "Países Baixos (Maastricht)";
            case "SGES" -> "Paraguai (Ciudad del Este)";
            case "SEGU" -> "Equador (Guayaquil)";
            case "WSSS" -> "Singapura";
            case "SMJP" -> "Suriname (Paramaribo)";
            case "SOCA" -> "Panamá (Puerto Armuelles)";
            case "SUMU" -> "Uruguai (Montevidéu)";
            case "LEMD" -> "Espanha (Madrid)";
            case "SPIM" -> "Peru (Lima)";
            case "SACO" -> "Argentina (Córdoba)";
            case "MPTO" -> "Panamá (Cidade do Panamá)";
            case "SGAS" -> "Paraguai (Assunção)";
            case "SVMI" -> "Venezuela (Caracas)";
            case "TNCA" -> "Aruba (Oranjestad)";
            case "KMCO" -> "EUA (Orlando)";
            case "MDSD" -> "Rep. Dominicana (Sto. Domingo)";
            case "SCEL" -> "Chile (Santiago)";
            case "EHAM" -> "Países Baixos (Amsterdã)";
            case "SKBO" -> "Colômbia (Bogotá)";
            case "KCLT" -> "EUA (Charlotte)";
            case "SCDA" -> "Chile (Iquique)";
            case "MMMD" -> "México (Mérida)";
            case "GCTS" -> "Espanha (Tenerife)";
            case "LSZH" -> "Suíça (Zurique)";
            case "SAAR" -> "Argentina (Rosário)";
            case "LPPT" -> "Portugal (Lisboa)";
            case "LTBA" -> "Turquia (Istambul Antigo)";
            case "SKCL" -> "Colômbia (Cali)";
            case "OMDB" -> "EAU (Dubai)";
            case "SEQM" -> "Equador (Quito)";
            case "MMMX" -> "México (Cidade do México)";
            case "MROC" -> "Costa Rica (San José)";
            case "KMIA" -> "EUA (Miami)";
            case "KLAX" -> "EUA (Los Angeles)";
            case "KDFW" -> "EUA (Dallas/Fort Worth)";
            case "LFPG" -> "França (Paris)";
            case "SAEZ" -> "Argentina (Buenos Aires)";
            case "SLLP" -> "Bolívia (La Paz)";
            case "SLVR" -> "Bolívia (Santa Cruz)";
            case "HAAB" -> "Etiópia (Addis Ababa)";
            case "KATL" -> "EUA (Atlanta)";
            case "EDDM" -> "Alemanha (Munique)";
            case "EDDF" -> "Alemanha (Frankfurt)";
            case "MUHA" -> "Cuba (Havana)";
            case "FNLU" -> "Angola (Luanda)";
            case "KMEM" -> "EUA (Memphis)";


            default -> "LOCALIZAÇÃO DESCONHECIDA";
        };
    }
}