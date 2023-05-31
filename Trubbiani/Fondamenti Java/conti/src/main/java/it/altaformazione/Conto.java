package it.altaformazione;

public class Conto<T extends Operazione> {

    private final String cc;
    private final Movimenti<T> movimenti;

    public Conto(String cc, Movimenti<T> movimenti) {
        this.cc = cc;
        this.movimenti = movimenti;
    }

    public String getCc() {
        return cc;
    }

    public Movimenti<T> getMovimenti() {
        return movimenti;
    }
}
