package school.sptech;

import java.time.LocalDateTime;

public class Leg_voos {
    private final LocalDateTime partidaPrevista;
    private final LocalDateTime partidaReal;
    private final LocalDateTime chegadaPrevista;
    private final LocalDateTime chegadaReal;

    public Leg_voos(LocalDateTime partidaPrevista, LocalDateTime partidaReal, LocalDateTime chegadaPrevista, LocalDateTime chegadaReal) {
        this.partidaPrevista = partidaPrevista;
        this.partidaReal = partidaReal;
        this.chegadaPrevista = chegadaPrevista;
        this.chegadaReal = chegadaReal;
    }

    public LocalDateTime getPartidaPrevista() {
        return partidaPrevista;
    }
    public LocalDateTime getPartidaReal() {
        return partidaReal;
    }
    public LocalDateTime getChegadaPrevista() {
        return chegadaPrevista;
    }
    public LocalDateTime getChegadaReal() {
        return chegadaReal;
    }
}