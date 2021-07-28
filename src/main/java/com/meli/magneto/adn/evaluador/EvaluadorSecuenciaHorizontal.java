package com.meli.magneto.adn.evaluador;

import com.meli.magneto.adn.modelo.ADN;
import com.meli.magneto.adn.extractor.ExtractorSecuenciaHorizontal;

public class EvaluadorSecuenciaHorizontal extends EvaluadorSecuenciaADN {
    ExtractorSecuenciaHorizontal extractorCadenaHorizontal;

    public EvaluadorSecuenciaHorizontal(ExtractorSecuenciaHorizontal extractorCadenaHorizontal){
        this.extractorCadenaHorizontal = extractorCadenaHorizontal;
    }

    @Override
    public boolean evaluarSecuencia(ADN adn, int posicionActualEjeX, int posicionActualEjeY, String expresionAEvaluar) {
        String secuencia = extractorCadenaHorizontal.obtenerSencuencia(adn, posicionActualEjeX, posicionActualEjeY);
        return tieneSecuenciaMutante(secuencia,expresionAEvaluar);
    }

}
