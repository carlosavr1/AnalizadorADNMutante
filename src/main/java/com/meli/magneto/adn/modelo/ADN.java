package com.meli.magneto.adn.modelo;

import com.meli.magneto.util.OperadorColeccion;

public class ADN {

    private String[] adnOriginal;
    private String[][] adn;

    public ADN(String[] adn) {
        this.adnOriginal = adn;
        this.adn = OperadorColeccion.convertirColeccion1DA2D(adn);
    }

    public String[] getAdnOriginal() {
        return adnOriginal;
    }

    public String[][] getAdn() {
        return adn;
    }
}
