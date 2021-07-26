package com.meli.magneto.adn;

import com.meli.magneto.adn.evaluador.*;

import java.util.ArrayList;

public class AdministradorADN {

    private String instruccionSecuenciaRegex = "(AAAA|TTTT|CCCC|GGGG)";
    private AdministradorEvaluadoresSecuencia administradorEvaluadoresSecuencia;

    public AdministradorADN(AdministradorEvaluadoresSecuencia administradorEvaluadoresSecuencia){
        this.administradorEvaluadoresSecuencia = administradorEvaluadoresSecuencia;
    }

    public boolean isMutant(ADN adn){
        ArrayList<EvaluadorSecuenciaADN> evaluadores = new ArrayList<>();
        boolean evaluarHorizontal;
        boolean evaluarVertical;
        boolean evaluarDiagIzqDer;
        boolean evaluarDiagDerIzq;
        int tamanoADN = adn.getAdn().length;
        int cantidadSencuencias = 0;
        for ( int x = 0; x<tamanoADN; x++){
            evaluarVertical = administradorEvaluadoresSecuencia.determinarEvaluarVertical(x, tamanoADN);
            for ( int y = 0; y<tamanoADN; y++){
                evaluarHorizontal = administradorEvaluadoresSecuencia.determinarEvaluarHorizontal(y, tamanoADN);
                evaluarDiagIzqDer = administradorEvaluadoresSecuencia.determinarEvaluarDiagIzqDer(x, y,tamanoADN);
                evaluarDiagDerIzq = administradorEvaluadoresSecuencia.determinarEvaluarDiagDerIzq(x, y, tamanoADN);
                ArrayList<EvaluadorSecuenciaADN> evaluadoresSecuenciaADN = administradorEvaluadoresSecuencia.definirEvaluadoresCadena(evaluadores, evaluarHorizontal, evaluarVertical, evaluarDiagIzqDer, evaluarDiagDerIzq);
                for (EvaluadorSecuenciaADN evaluadorSecuenciaADN: evaluadoresSecuenciaADN) {
                    cantidadSencuencias = cantidadSencuencias + (evaluadorSecuenciaADN.evaluarSecuencia(adn, x, y, instruccionSecuenciaRegex) ? 1 : 0);
                }
                if(cantidadSencuencias > 1){
                    return true;
                }
            }
        }
        return false;
    }

}
