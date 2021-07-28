package com.meli.magneto.adn.evaluador;

import com.meli.magneto.adn.modelo.ADN;
import com.meli.magneto.adn.extractor.ExtractorSecuenciaVertical;

public class EvaluadorSecuenciaVertical extends EvaluadorSecuenciaADN {
    ExtractorSecuenciaVertical extractorSecuenciaVertical;

    public EvaluadorSecuenciaVertical(ExtractorSecuenciaVertical extractorSecuenciaVertical) {
        this.extractorSecuenciaVertical = extractorSecuenciaVertical;
    }

    @Override
    public boolean evaluarSecuencia(ADN adn, int posicionActualEjeX, int posicionActualEjeY, String expresionAEvaluar) {
        String secuencia = extractorSecuenciaVertical.obtenerSencuencia(adn, posicionActualEjeX, posicionActualEjeY);
        return tieneSecuenciaMutante(secuencia,expresionAEvaluar);
    }

}
