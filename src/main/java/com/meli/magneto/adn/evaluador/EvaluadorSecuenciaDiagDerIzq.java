package com.meli.magneto.adn.evaluador;

import com.meli.magneto.adn.ADN;
import com.meli.magneto.adn.extractor.ExtractorSecuenciaDiagDerIzq;

public class EvaluadorSecuenciaDiagDerIzq extends EvaluadorSecuenciaADN {
    ExtractorSecuenciaDiagDerIzq extractorSecuenciaDiagDerIzq;

    public EvaluadorSecuenciaDiagDerIzq(ExtractorSecuenciaDiagDerIzq extractorSecuenciaDiagDerIzq){
        this.extractorSecuenciaDiagDerIzq = extractorSecuenciaDiagDerIzq;
    }
    @Override
    public boolean evaluarSecuencia(ADN adn, int posicionActualEjeX, int posicionActualEjeY, String expresionAEvaluar) {
        String secuencia = extractorSecuenciaDiagDerIzq.obtenerSencuencia(adn, posicionActualEjeX, posicionActualEjeY);
        return tieneSecuenciaMutante(secuencia,expresionAEvaluar);
    }

}
