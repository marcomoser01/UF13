package it.altaformazione;

import java.util.ArrayList;
import java.util.List;

public class MovimentiImpl<T extends Operazione> implements Movimenti<T> {

    private List<T> movimenti;
    private double saldo = 0;

    public double getSaldo() {
        return saldo;
    }

    public MovimentiImpl() {
        this.movimenti = new ArrayList<>();
    }

    @Override
    public List<T> getLista() {
        return this.movimenti;
    }

    @Override
    public void add(T op) {
        if (op.getClass().equals(Entrata.class)) {
            saldo += ((Entrata) op).getValue();
        }
        if (op.getClass().equals(Uscita.class)) {
            saldo -= ((Uscita) op).getValue();
        }
        this.movimenti.add(op);
    }

}
