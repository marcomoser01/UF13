package it.altaformazione;

import java.util.Date;
import java.util.UUID;

public class Entrata implements Operazione {

    private final double value;
    private final Date date;
    private final String type = "ENTRATA";
    private String uuid;

    public Entrata(double value, Date date) {
        this.value = value;
        this.date = date;
        this.uuid = UUID.randomUUID().toString();
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
