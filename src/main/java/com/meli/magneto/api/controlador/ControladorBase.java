package com.meli.magneto.api.controlador;

import com.meli.magneto.acl.ValidadorACL;
import com.meli.magneto.adn.AdministradorADN;
import com.meli.magneto.adn.db.CosmosPersistenciaADN;
import com.meli.magneto.adn.db.IPersistenciaADN;
import com.meli.magneto.adn.evaluador.*;
import com.meli.magneto.adn.extractor.ExtractorSecuenciaDiagDerIzq;
import com.meli.magneto.adn.extractor.ExtractorSecuenciaDiagIzqDer;
import com.meli.magneto.adn.extractor.ExtractorSecuenciaHorizontal;
import com.meli.magneto.adn.extractor.ExtractorSecuenciaVertical;
import com.meli.magneto.util.Codificador;

public class ControladorBase {

    protected ValidadorACL validadorACL;
    protected AdministradorADN administradorADN;
    protected AdministradorEvaluadoresSecuencia administradorEvaluadoresSecuencia;
    protected EvaluadorSecuenciaHorizontal evaluadorSecuenciaHorizontal;
    protected EvaluadorSecuenciaVertical evaluadorSecuenciaVertical;
    protected EvaluadorSecuenciaDiagIzqDer evaluadorSecuenciaDiagIzqDer;
    protected EvaluadorSecuenciaDiagDerIzq evaluadorSecuenciaDiagDerIzq;

    public void prepararDependencias() throws Exception {
        validadorACL = new ValidadorACL();
        ExtractorSecuenciaHorizontal extractorCadenaHorizontal = new ExtractorSecuenciaHorizontal();
        evaluadorSecuenciaHorizontal = new EvaluadorSecuenciaHorizontal(extractorCadenaHorizontal);
        ExtractorSecuenciaVertical extractorSecuenciaVertical = new ExtractorSecuenciaVertical();
        evaluadorSecuenciaVertical = new EvaluadorSecuenciaVertical(extractorSecuenciaVertical);
        ExtractorSecuenciaDiagIzqDer extractorSecuenciaDiagIzqDer = new ExtractorSecuenciaDiagIzqDer();
        evaluadorSecuenciaDiagIzqDer = new EvaluadorSecuenciaDiagIzqDer(extractorSecuenciaDiagIzqDer);
        ExtractorSecuenciaDiagDerIzq extractorSecuenciaDiagDerIzq = new ExtractorSecuenciaDiagDerIzq();
        evaluadorSecuenciaDiagDerIzq = new EvaluadorSecuenciaDiagDerIzq(extractorSecuenciaDiagDerIzq);
        administradorEvaluadoresSecuencia = new AdministradorEvaluadoresSecuencia(evaluadorSecuenciaHorizontal, evaluadorSecuenciaVertical, evaluadorSecuenciaDiagIzqDer, evaluadorSecuenciaDiagDerIzq);
        CosmosPersistenciaADN cosmosPersistenciaADN = new CosmosPersistenciaADN();
        cosmosPersistenciaADN.crearCliente();
        cosmosPersistenciaADN.crearBDSiNoExiste();
        cosmosPersistenciaADN.crearContenedorSiNoExiste();
        Codificador codificador = new Codificador();
        administradorADN = new AdministradorADN( administradorEvaluadoresSecuencia, cosmosPersistenciaADN, codificador);

    }

}