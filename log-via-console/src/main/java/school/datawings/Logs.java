package school.datawings;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Logs {
    public static void main(String[] args) throws InterruptedException {

          final String VERMELHO = "\u001B[31m";
          final String VERDE = "\u001B[32m";
          final String AZUL = "\u001B[34m";
          final String RESET = "\u001B[0m";

        LocalDateTime dataHora = LocalDateTime.now();
        DateTimeFormatter formatacao = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataHoraFormatada;

        List<String> lista = new ArrayList<>();
        List<String> listaNomes = new ArrayList<>();

        listaNomes.add("Gabriel");
        listaNomes.add("Gustavo");
        listaNomes.add("Otavio");
        listaNomes.add("Thalita");
        listaNomes.add("Vinicius");
        listaNomes.add("Caramico");
        listaNomes.add("Paulo");
        listaNomes.add("Guilherme");
        listaNomes.add("Pedro");
        listaNomes.add("Thiago");
        listaNomes.add("Kaline");

        lista.add("Cadastro realizado com sucesso");
        lista.add("Login realizado com sucesso");
        lista.add("Conta de %s excluida");



        Integer minutos = 0;

        System.out.println("  _____        _     __          ___                 \n" +
                " |  __ \\      | |    \\ \\        / (_)                \n" +
                " | |  | | __ _| |_ __ \\ \\  /\\  / / _ _ __   __ _ ___ \n" +
                " | |  | |/ _` | __/ _` \\ \\/  \\/ / | | '_ \\ / _` / __|\n" +
                " | |__| | (_| | || (_| |\\  /\\  /  | | | | | (_| \\__ \\\n" +
                " |_____/ \\__,_|\\__\\__,_| \\/  \\/   |_|_| |_|\\__, |___/\n" +
                "                                            __/ |    \n" +
                "                                           |___/     ");
        
        while (true){
            Integer nomeAletorio = ThreadLocalRandom.current().nextInt(0, 9);
            Integer logAleatorio = ThreadLocalRandom.current().nextInt(0, 99);
            String nomeAtual;
            String logAtual;
            String cor;
            dataHoraFormatada = dataHora.plusMinutes(minutos++).format(formatacao);

            if(nomeAletorio == 1){
                nomeAtual = listaNomes.get(nomeAletorio);
            }else if(nomeAletorio == 2){
                nomeAtual = listaNomes.get(nomeAletorio);
            } else if (nomeAletorio == 3) {
                nomeAtual = listaNomes.get(nomeAletorio);
            }else if(nomeAletorio == 4){
                nomeAtual = listaNomes.get(nomeAletorio);
            } else if (nomeAletorio == 5) {
                nomeAtual = listaNomes.get(nomeAletorio);
            } else if (nomeAletorio == 6) {
                nomeAtual = listaNomes.get(nomeAletorio);
            } else if (nomeAletorio == 7) {
                nomeAtual = listaNomes.get(nomeAletorio);
            } else if (nomeAletorio == 8) {
                nomeAtual = listaNomes.get(nomeAletorio);
            } else if (nomeAletorio == 9) {
                nomeAtual = listaNomes.get(nomeAletorio);
            }else{
                nomeAtual = listaNomes.get(nomeAletorio);
            };


            if (logAleatorio <= 60) {
                logAtual = lista.get(0);
                cor = VERDE;
            } else if (logAleatorio <= 90) {
                logAtual = lista.get(1);
                cor = AZUL;
            }else{
                logAtual = lista.get(2);
                cor = VERMELHO;
            }

            System.out.printf(dataHoraFormatada+" ");
            System.out.printf(cor+logAtual+RESET+"\n", nomeAtual);
            Thread.sleep(800);
        }


    }
}
