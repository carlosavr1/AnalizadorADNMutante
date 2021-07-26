package com.meli.magneto.adn.evaluador;

import com.meli.magneto.adn.ADN;
import com.meli.magneto.adn.extractor.ExtractorSecuenciaDiagIzqDer;

public class EvaluadorSecuenciaDiagIzqDer extends EvaluadorSecuenciaADN {
    ExtractorSecuenciaDiagIzqDer extractorSecuenciaDiagIzqDer;

    public EvaluadorSecuenciaDiagIzqDer(ExtractorSecuenciaDiagIzqDer extractorSecuenciaDiagIzqDer){
        this.extractorSecuenciaDiagIzqDer = extractorSecuenciaDiagIzqDer;
    }
    @Override
    public boolean evaluarSecuencia(ADN adn, int posicionActualEjeX, int posicionActualEjeY, String expresionAEvaluar) {
        String secuencia = extractorSecuenciaDiagIzqDer.obtenerSencuencia(adn, posicionActualEjeX, posicionActualEjeY);
        return tieneSecuenciaMutante(secuencia,expresionAEvaluar);
    }

}
