package com.meli.magneto.adn.evaluador;

import java.util.ArrayList;

public class AdministradorEvaluadoresSecuencia {

    EvaluadorSecuenciaHorizontal evaluadorSecuenciaHorizontal;
    EvaluadorSecuenciaVertical evaluadorSecuenciaVertical;
    EvaluadorSecuenciaDiagIzqDer evaluadorSecuenciaDiagIzqDer;
    EvaluadorSecuenciaDiagDerIzq evaluadorSecuenciaDiagDerIzq;

    public AdministradorEvaluadoresSecuencia(EvaluadorSecuenciaHorizontal evaluadorSecuenciaHorizontal, EvaluadorSecuenciaVertical evaluadorSecuenciaVertical,
                                             EvaluadorSecuenciaDiagIzqDer evaluadorSecuenciaDiagIzqDer, EvaluadorSecuenciaDiagDerIzq evaluadorSecuenciaDiagDerIzq){
        this.evaluadorSecuenciaHorizontal = evaluadorSecuenciaHorizontal;
        this.evaluadorSecuenciaVertical = evaluadorSecuenciaVertical;;
        this.evaluadorSecuenciaDiagIzqDer = evaluadorSecuenciaDiagIzqDer;
        this.evaluadorSecuenciaDiagDerIzq = evaluadorSecuenciaDiagDerIzq;
    }

    public ArrayList<EvaluadorSecuenciaADN> definirEvaluadoresCadena(ArrayList<EvaluadorSecuenciaADN> evaluadores, boolean evaluarHorizontal, boolean evaluarVertical, boolean evaluarDiagIzqDer, boolean evaluarDiagDerIzq) {
        evaluadores.clear();
        if(evaluarHorizontal){
            evaluadores.add(evaluadorSecuenciaHorizontal);
        }
        if(evaluarVertical){
            evaluadores.add(evaluadorSecuenciaVertical);
        }
        if(evaluarDiagIzqDer){
            evaluadores.add(evaluadorSecuenciaDiagIzqDer);
        }
        if(evaluarDiagDerIzq){
            evaluadores.add(evaluadorSecuenciaDiagDerIzq);
        }
        return evaluadores;
    }

    public boolean determinarEvaluarHorizontal(int posicionActualEjeY, int tamanoADN){
        return tamanoADN - posicionActualEjeY > 3;
    }

    public boolean determinarEvaluarVertical(int posicionActualEjeX, int tamanoADN){
        return tamanoADN - posicionActualEjeX > 3;
    }

    public boolean determinarEvaluarDiagIzqDer(int posicionActualEjeX, int posicionActualEjeY, int tamanoADN){
        return tamanoADN - posicionActualEjeX > 3 && tamanoADN - posicionActualEjeY > 3;
    }

    public boolean determinarEvaluarDiagDerIzq(int posicionActualEjeX, int posicionActualEjeY, int tamanoADN){
        return posicionActualEjeY > 2 && tamanoADN - posicionActualEjeX > 3;
    }

}
