package com.meli.magneto.adn.extractor;

import com.meli.magneto.adn.ADN;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExtractorSecuenciaDiagDerIzqTest {

    @Test
    void obtenerSencuenciaDebeRetornarLaCadenaRespectiva() {
        ExtractorSecuenciaDiagDerIzq extractorSecuenciaDiagDerIzq = new ExtractorSecuenciaDiagDerIzq();
        String[] coleccion1D = {"ATGC","CAGT","TTAT", "AGAA"};
        ADN adn = new ADN(coleccion1D);
        int posicionActualEjeX = 0;
        int posicionActualEjeY = 3;
        String resultadoEsperado = "CGTA";

        String resultado = extractorSecuenciaDiagDerIzq.obtenerSencuencia(adn, posicionActualEjeX, posicionActualEjeY);

        assertEquals(resultadoEsperado, resultado);
    }
}