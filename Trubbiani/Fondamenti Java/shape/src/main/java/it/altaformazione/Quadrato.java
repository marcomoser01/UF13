package it.altaformazione;

public class Quadrato implements Shape {

    private final double lato;

    public Quadrato(double lato) {
        this.lato = lato;
    }

    @Override
    public double calcolaArea() {
        return Math.pow(lato, 2);
    }

    @Override
    public double calcolaPerimetro() {
        return lato * 4;
    }

}
