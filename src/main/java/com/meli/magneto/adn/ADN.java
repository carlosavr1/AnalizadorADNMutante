package com.meli.magneto.adn;

import com.meli.magneto.util.OperadorColeccion;

public class ADN {

    private String[][] adn;

    public ADN(String[] adn) {
        this.adn = OperadorColeccion.convertirColeccion1DA2D(adn);
    }

    public String[][] getAdn() {
        return adn;
    }
}
