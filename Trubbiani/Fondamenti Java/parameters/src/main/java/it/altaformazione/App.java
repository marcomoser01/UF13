package it.altaformazione;

/**
 * Parametri
 *
 */
public class App {
    public static void main(String[] args) {
        for (String i : args) {
            System.out.println("We receive the follow parameter : " + i);
        }

        double percentualeInteresse = 2.5; // Percentual di interesse
        double sommaDepositata = 1000; // in euro

        sommaDepositata = sommaDepositata + (1 + percentualeInteresse / 100);

        System.out.println("Dopo un anno avrai : " + sommaDepositata + " euro");

        // Setto nuovamente la mia somma depositata
        sommaDepositata = 1000;

        // Prendo la percentuale di interessi passata come parametro al programma
        double nuovaPercentualeDiInteresse = Double.parseDouble(args[0]);

        sommaDepositata = sommaDepositata + (1 + nuovaPercentualeDiInteresse / 100);

        System.out.println("Dopo un anno, con una percentual di interessi apari al (" + nuovaPercentualeDiInteresse
                + ") avrai : " + sommaDepositata + " euro");

    }
}
