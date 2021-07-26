package com.meli.magneto.adn.extractor;

import com.meli.magneto.adn.ADN;

public class ExtractorSecuenciaHorizontal implements IExtractorSecuenciaADN {

    @Override
    public String obtenerSencuencia(ADN adn, int posicionActualEjeX, int posicionActualEjeY) {
        return adn.getAdn()[posicionActualEjeX][posicionActualEjeY] +
                adn.getAdn()[posicionActualEjeX][posicionActualEjeY+1] +
                adn.getAdn()[posicionActualEjeX][posicionActualEjeY+2] +
                adn.getAdn()[posicionActualEjeX][posicionActualEjeY+3];
    }
}
