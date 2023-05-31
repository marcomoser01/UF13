package it.altaformazione;

import java.util.List;

public interface Movimenti<T extends Operazione> {

    List<T> getLista();

    double getSaldo();

    void add(T op);

}
