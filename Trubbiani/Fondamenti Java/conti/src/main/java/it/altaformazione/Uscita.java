package it.altaformazione;

import java.util.Date;

public class Uscita implements Operazione {
    private final double value;
    private final Date date;
    private final String type = "USCITA";

    public Uscita(double value, Date date) {
        this.value = value;
        this.date = date;
    }

    public double getValue() {
        return value;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String getType() {
        return type;
    }
}
