package com.meli.magneto.adn.extractor;

import com.meli.magneto.adn.modelo.ADN;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExtractorSecuenciaDiagIzqDerTest {

    @Test
    void obtenerSencuenciaDebeRetornarLaCadenaRespectiva() {
        ExtractorSecuenciaDiagIzqDer extractorSecuenciaDiagIzqDer = new ExtractorSecuenciaDiagIzqDer();
        String[] coleccion1D = {"ATGC","CAGT","TTAT", "AGAA"};
        ADN adn = new ADN(coleccion1D);
        int posicionActualEjeX = 0;
        int posicionActualEjeY =0;
        String resultadoEsperado = "AAAA";

        String resultado = extractorSecuenciaDiagIzqDer.obtenerSencuencia(adn, posicionActualEjeX, posicionActualEjeY);

        assertEquals(resultadoEsperado, resultado);
    }
}