package com.meli.magneto.adn.modelo;


import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE, setterVisibility=JsonAutoDetect.Visibility.NONE)
public class Estadisticas {

    @JsonProperty("count_mutant_dna")
    private int cantidadADNsMutantes;
    @JsonProperty("count_human_dna")
    private int cantidadADNsHumanos;
    @JsonProperty("ratio")
    private double proporcion;

    public Estadisticas(int cantidadADNsMutantes, int cantidadADNsHumanos, double proporcion) {
        this.cantidadADNsMutantes = cantidadADNsMutantes;
        this.cantidadADNsHumanos = cantidadADNsHumanos;
        this.proporcion = proporcion;
    }

    public int getCantidadADNsMutantes() {
        return cantidadADNsMutantes;
    }

    public void setCantidadADNsMutantes(int cantidadADNsMutantes) {
        this.cantidadADNsMutantes = cantidadADNsMutantes;
    }

    public int getCantidadADNsHumanos() {
        return cantidadADNsHumanos;
    }

    public void setCantidadADNsHumanos(int cantidadADNsHumanos) {
        this.cantidadADNsHumanos = cantidadADNsHumanos;
    }

    public double getProporcion() {
        return proporcion;
    }

    public void setProporcion(double proporcion) {
        this.proporcion = proporcion;
    }
}
