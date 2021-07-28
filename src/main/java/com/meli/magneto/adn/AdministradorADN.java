package com.meli.magneto.adn;

import com.meli.magneto.adn.db.IPersistenciaADN;
import com.meli.magneto.adn.db.modelo.ADNRegistro;
import com.meli.magneto.adn.evaluador.*;
import com.meli.magneto.adn.modelo.ADN;
import com.meli.magneto.adn.modelo.TiposADN;
import com.meli.magneto.util.Codificador;

import java.util.ArrayList;
import java.util.UUID;

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
        String identificadorHashADN = codificador.md5HashString(adn.getAdnOriginal());
        ADNRegistro adnRegistro = persistenciaADN.consultarADNRegistro(identificadorHashADN);
        if(adnRegistro != null){
            adnRegistro.setCantidad(adnRegistro.getCantidad() + 1);
            persistenciaADN.actualizarCantidadADNRegistro(adnRegistro);
            return !esHumano(adnRegistro.getTipo());
        } else {
            return evaluarAdn(adn, identificadorHashADN);
        }
    }

    public boolean esHumano(String tipo){
        return TiposADN.valueOf(tipo) == TiposADN.HUMANO;
    }

    public boolean evaluarAdn(ADN adn, String identificadorHashADN) throws Exception {
        ArrayList<EvaluadorSecuenciaADN> evaluadores = new ArrayList<>();
        boolean evaluarHorizontal;
        boolean evaluarVertical;
        boolean evaluarDiagIzqDer;
        boolean evaluarDiagDerIzq;
        int tamanoADN = adn.getAdn().length;
        int cantidadSencuencias = 0;
        for (int x = 0; x < tamanoADN; x++) {
            evaluarVertical = administradorEvaluadoresSecuencia.determinarEvaluarVertical(x, tamanoADN);
            for (int y = 0; y < tamanoADN; y++) {
                evaluarHorizontal = administradorEvaluadoresSecuencia.determinarEvaluarHorizontal(y, tamanoADN);
                evaluarDiagIzqDer = administradorEvaluadoresSecuencia.determinarEvaluarDiagIzqDer(x, y, tamanoADN);
                evaluarDiagDerIzq = administradorEvaluadoresSecuencia.determinarEvaluarDiagDerIzq(x, y, tamanoADN);
                ArrayList<EvaluadorSecuenciaADN> evaluadoresSecuenciaADN = administradorEvaluadoresSecuencia.definirEvaluadoresCadena(evaluadores, evaluarHorizontal, evaluarVertical, evaluarDiagIzqDer, evaluarDiagDerIzq);
                for (EvaluadorSecuenciaADN evaluadorSecuenciaADN : evaluadoresSecuenciaADN) {
                    cantidadSencuencias = cantidadSencuencias + (evaluadorSecuenciaADN.evaluarSecuencia(adn, x, y, instruccionSecuenciaRegex) ? 1 : 0);
                }
                if (cantidadSencuencias > 1) {
                    ADNRegistro aDNRegistro = crearADNRegistro(identificadorHashADN, adn.getAdnOriginal(), TiposADN.MUTANTE.name(), 1);
                    persistenciaADN.crearADNRegistro(aDNRegistro);
                    return true;
                }
            }
        }
        ADNRegistro aDNRegistro = crearADNRegistro(identificadorHashADN, adn.getAdnOriginal(), TiposADN.HUMANO.name(), 1);
        persistenciaADN.crearADNRegistro(aDNRegistro);
        return false;
    }

    public ADNRegistro crearADNRegistro(String identificadorHashADN, String[] adn, String tipo, int cantidad){
        ADNRegistro adnRegistro = new ADNRegistro(UUID.randomUUID().toString(), identificadorHashADN, adn, tipo, cantidad);;
        return adnRegistro;

    }

}
