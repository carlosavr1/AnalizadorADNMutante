package com.meli.magneto.adn.evaluador;

public abstract class EvaluadorSecuenciaADN implements IEvaluadorSecuenciaADN {

    public boolean tieneSecuenciaMutante(String secuencia, String expresionAEvaluar){
        return secuencia.matches(expresionAEvaluar);
    }

}
