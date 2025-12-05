package school.sptech;

public class Rota {

    private final String icaoOrigem;
    private final String icaoDestino;

    public Rota(String icaoOrigem, String icaoDestino) {
        this.icaoOrigem = icaoOrigem;
        this.icaoDestino = icaoDestino;
    }

    public String getIcaoOrigem() {
        return icaoOrigem;
    }
    public String getIcaoDestino() {
        return icaoDestino;
    }
}