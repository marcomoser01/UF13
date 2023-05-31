package it.altaformazione;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Shape shape = new Quadrato(9.0);
        System.out.println(shape.calcolaArea());
        System.out.println(shape.calcolaPerimetro());
    }
}
