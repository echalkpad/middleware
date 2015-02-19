package fr.unice.smart_campus.middleware.cep_engine;

import java.io.Serializable;

public class ParkingSensorEvent  extends CEPEvent implements Serializable{
    public final long serialVersionUID = 1234567891922321327L;

    private final String value;
    private final String name;
    private final String timeStamp;

    public ParkingSensorEvent(String value, String name, String timeStamp) {
        this.value = value;
        this.name = name;
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "{" +
                "\"v\":\"" + value + "\"" +
                ", \"n\"=\"" + name + "\"" +
                ", \"t\"=\"" + timeStamp + "\"" +
                '}';
    }

    public String getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public String getTimeStamp() {
        return timeStamp;
    }
}