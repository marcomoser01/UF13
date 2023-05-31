package es1fbk;


import java.util.ArrayList; 

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alexi
 */

public class ContoCorrente {
    private final int cc;
    private double saldo;
    private ArrayList<Movimento> lista = new ArrayList<Movimento>();
    private int nMovimenti;

    public ContoCorrente(int cc) {
        this.cc = cc;
        this.saldo = 0;
        this.nMovimenti = 0;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setLista(ArrayList<Movimento> lista) {
        this.lista = lista;
    }

    public void setnMovimenti(int nMovimenti) {
        this.nMovimenti = nMovimenti;
    }

    public int getCc() {
        return cc;
    }

    public double getSaldo() {
        return saldo;
    }

    public ArrayList<Movimento> getLista() {
        return lista;
    }

    public int getnMovimenti() {
        return nMovimenti;
    }
    
    
    // Stampa della lista dei movimenti
    public String listaMov(){
        String result = "";
        
        for(Movimento mov: lista){
            result += mov.toString() + "\n";
        }                
        return result;
    }
      
    
    // Prelievo di una certo valore
    public String prelievo(double valore, String desc){
        setSaldo(this.saldo - valore);
        
        // Aggiunta di un movimento alla lista
        lista.add(new Movimento(valore, desc));
        setnMovimenti(this.nMovimenti + 1);
        
        return "Prelievo effettuato";
    }
    
    // Versamento di un valore
    public String versamento(double valore, String desc){
        setSaldo(this.saldo + valore);
        
        // Aggiunta di un movimento alla lista
        lista.add(new Movimento(valore, desc));
        
        setnMovimenti(this.nMovimenti + 1);
        
        return "Versamento effettuato";
    }

    
    // Metodo che stampa tutte le variabili
    @Override
    public String toString() {
        return "ContoCorrente{" + "lista=" + lista + '}';
    }
    
}
