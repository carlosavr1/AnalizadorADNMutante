package com.meli.magneto.adn.db.modelo;

public class EstadisticasRegistro {

    int cantidadMutantes;
    int cantidadHumanos;

    public EstadisticasRegistro() {
        this.cantidadMutantes = 0;
        this.cantidadHumanos = 0;
    }

    public int getCantidadMutantes() {
        return cantidadMutantes;
    }

    public int getCantidadHumanos() {
        return cantidadHumanos;
    }

    public void setCantidadMutantes(int cantidadMutantes) {
        this.cantidadMutantes = cantidadMutantes;
    }

    public void setCantidadHumanos(int cantidadHumanos) {
        this.cantidadHumanos = cantidadHumanos;
    }
}
