package com.meli.magneto.adn.evaluador;

import com.meli.magneto.adn.modelo.ADN;

public interface IEvaluadorSecuenciaADN {

    public boolean evaluarSecuencia(ADN adn, int posicionActualEjeX, int posicionActualEjeY, String expresionAEvaluar);

    public boolean tieneSecuenciaMutante(String secuencia, String expresionAEvaluar);


}
