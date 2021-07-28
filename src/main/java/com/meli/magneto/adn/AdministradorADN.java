package com.meli.magneto.adn;

import com.meli.magneto.adn.db.CosmosPersistenciaADN;
import com.meli.magneto.adn.db.IPersistenciaADN;
import com.meli.magneto.adn.evaluador.*;
import com.meli.magneto.adn.modelo.ADN;
import com.meli.magneto.adn.modelo.TiposADN;
import com.meli.magneto.util.Codificador;

import java.util.ArrayList;

public class AdministradorADN {

    private String instruccionSecuenciaRegex = "(AAAA|TTTT|CCCC|GGGG)";
    private AdministradorEvaluadoresSecuencia administradorEvaluadoresSecuencia;
    private IPersistenciaADN persistenciaADN;
    private Codificador codificador;

    public AdministradorADN(AdministradorEvaluadoresSecuencia administradorEvaluadoresSecuencia, IPersistenciaADN persistenciaADN, Codificador codificador){
        this.administradorEvaluadoresSecuencia = administradorEvaluadoresSecuencia;
        this.persistenciaADN = persistenciaADN;
        this.codificador = codificador;
    }

    public boolean isMutant(ADN adn) throws Exception {
        String identificadorHashADN = codificador.md5HashString("PruebaADN");
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
                    persistenciaADN.crearADNRegistro(identificadorHashADN, adn.getAdnOriginal(), TiposADN.MUTANTE.name(), 1);
                    return true;
                }
            }
        }
        persistenciaADN.crearADNRegistro(identificadorHashADN, adn.getAdnOriginal(), TiposADN.HUMANO.name(), 1);
        return false;
    }

}
