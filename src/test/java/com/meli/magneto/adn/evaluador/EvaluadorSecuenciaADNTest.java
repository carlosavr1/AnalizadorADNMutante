package com.meli.magneto.adn.evaluador;

import com.meli.magneto.adn.ADN;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EvaluadorSecuenciaADNTest {

    String expresionRegular = "(AAAA|TTTT|CCCC|GGGG)";

    @Test
    void tieneSecuenciaMutanteDebeRetornarTrueCuandoSecuenciaEsMutante() {
        EvaluadorSecuenciaADN evaluadorSecuenciaADN = new EvaluadorSecuenciaADN(){
            @Override
            public boolean evaluarSecuencia(ADN adn, int posicionActualEjeX, int posicionActualEjeY, String expresionAEvaluar) {
                return false;
            }
        };
        String secuencia = "AAAA";
        boolean resultadoEsperado = true;

        boolean resultado = evaluadorSecuenciaADN.tieneSecuenciaMutante(secuencia, expresionRegular);

        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    void tieneSecuenciaMutanteDebeRetornarFalsoCuandoSecuenciaNoEsMutante() {
        EvaluadorSecuenciaADN evaluadorSecuenciaADN = new EvaluadorSecuenciaADN(){
            @Override
            public boolean evaluarSecuencia(ADN adn, int posicionActualEjeX, int posicionActualEjeY, String expresionAEvaluar) {
                return false;
            }
        };
        String secuencia = "AAAG";
        boolean resultadoEsperado = false;

        boolean resultado = evaluadorSecuenciaADN.tieneSecuenciaMutante(secuencia, expresionRegular);

        assertEquals(resultadoEsperado, resultado);
    }
}