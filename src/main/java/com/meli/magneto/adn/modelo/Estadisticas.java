package com.meli.magneto.adn.modelo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Estadisticas {


    private int cantidadADNsMutantes;

    private int cantidadADNsHumanos;

    private double proporcion;

    public Estadisticas(int cantidadADNsMutantes, int cantidadADNsHumanos, double proporcion) {
        this.cantidadADNsMutantes = cantidadADNsMutantes;
        this.cantidadADNsHumanos = cantidadADNsHumanos;
        this.proporcion = proporcion;
    }

    @JsonProperty("count_mutant_dna")
    public int getCantidadADNsMutantes() {
        return cantidadADNsMutantes;
    }

    public void setCantidadADNsMutantes(int cantidadADNsMutantes) {
        this.cantidadADNsMutantes = cantidadADNsMutantes;
    }

    @JsonProperty("count_human_dna")
    public int getCantidadADNsHumanos() {
        return cantidadADNsHumanos;
    }

    public void setCantidadADNsHumanos(int cantidadADNsHumanos) {
        this.cantidadADNsHumanos = cantidadADNsHumanos;
    }

    @JsonProperty("ratio")
    public double getProporcion() {
        return proporcion;
    }

    public void setProporcion(double proporcion) {
        this.proporcion = proporcion;
    }
}
