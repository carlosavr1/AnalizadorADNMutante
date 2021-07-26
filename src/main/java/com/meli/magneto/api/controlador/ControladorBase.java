package com.meli.magneto.api.controlador;

import com.meli.magneto.adn.AdministradorADN;
import com.meli.magneto.adn.evaluador.*;
import com.meli.magneto.adn.extractor.ExtractorSecuenciaDiagDerIzq;
import com.meli.magneto.adn.extractor.ExtractorSecuenciaDiagIzqDer;
import com.meli.magneto.adn.extractor.ExtractorSecuenciaHorizontal;
import com.meli.magneto.adn.extractor.ExtractorSecuenciaVertical;

public class ControladorBase {

    protected AdministradorADN administradorADN;
    protected AdministradorEvaluadoresSecuencia administradorEvaluadoresSecuencia;
    protected EvaluadorSecuenciaHorizontal evaluadorSecuenciaHorizontal;
    protected EvaluadorSecuenciaVertical evaluadorSecuenciaVertical;
    protected EvaluadorSecuenciaDiagIzqDer evaluadorSecuenciaDiagIzqDer;
    protected EvaluadorSecuenciaDiagDerIzq evaluadorSecuenciaDiagDerIzq;

    public void prepararDependencias() {
        ExtractorSecuenciaHorizontal extractorCadenaHorizontal = new ExtractorSecuenciaHorizontal();
        evaluadorSecuenciaHorizontal = new EvaluadorSecuenciaHorizontal(extractorCadenaHorizontal);
        ExtractorSecuenciaVertical extractorSecuenciaVertical = new ExtractorSecuenciaVertical();
        evaluadorSecuenciaVertical = new EvaluadorSecuenciaVertical(extractorSecuenciaVertical);
        ExtractorSecuenciaDiagIzqDer extractorSecuenciaDiagIzqDer = new ExtractorSecuenciaDiagIzqDer();
        evaluadorSecuenciaDiagIzqDer = new EvaluadorSecuenciaDiagIzqDer(extractorSecuenciaDiagIzqDer);
        ExtractorSecuenciaDiagDerIzq extractorSecuenciaDiagDerIzq = new ExtractorSecuenciaDiagDerIzq();
        evaluadorSecuenciaDiagDerIzq = new EvaluadorSecuenciaDiagDerIzq(extractorSecuenciaDiagDerIzq);
        administradorEvaluadoresSecuencia = new AdministradorEvaluadoresSecuencia(evaluadorSecuenciaHorizontal, evaluadorSecuenciaVertical, evaluadorSecuenciaDiagIzqDer, evaluadorSecuenciaDiagDerIzq);
        administradorADN = new AdministradorADN( administradorEvaluadoresSecuencia );

    }

}