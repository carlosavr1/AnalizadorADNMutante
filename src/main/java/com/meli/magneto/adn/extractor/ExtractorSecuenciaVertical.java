package com.meli.magneto.adn.extractor;

import com.meli.magneto.adn.modelo.ADN;

public class ExtractorSecuenciaVertical implements IExtractorSecuenciaADN {


    @Override
    public String obtenerSencuencia(ADN adn, int posicionActualEjeX, int posicionActualEjeY) {
        return adn.getAdn()[posicionActualEjeX][posicionActualEjeY] +
                adn.getAdn()[posicionActualEjeX+1][posicionActualEjeY] +
                adn.getAdn()[posicionActualEjeX+2][posicionActualEjeY] +
                adn.getAdn()[posicionActualEjeX+3][posicionActualEjeY];
    }
}
