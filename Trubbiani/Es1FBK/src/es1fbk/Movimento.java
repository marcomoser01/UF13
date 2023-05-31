package es1fbk;


import java.time.LocalDateTime;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alexi
 */
public class Movimento {
    private double valore;
    private String desc;
    private LocalDateTime dataOra;

    public Movimento(double valore, String desc) {
        this.valore = valore;
        this.desc = desc;
        this.dataOra = LocalDateTime.now();
    }

    
    // set e get
    public double getValore() {
        return valore;
    }

    public String getDesc() {
        return desc;
    }

    public void setValore(double valore) {
        this.valore = valore;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    public LocalDateTime getDataOra() {
        return dataOra;
    }

    // Metodo che stampa tutte le variabili
    @Override
    public String toString() {
        return "Movimento{" + "valore=" + valore + ", desc=" + desc + ", dataOra=" + dataOra + '}';
    }

    
    


    
}
