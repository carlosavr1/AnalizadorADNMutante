package com.meli.magneto.adn.extractor;

import com.meli.magneto.adn.ADN;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExtractorSecuenciaHorizontalTest {

    @Test
    void obtenerSencuenciaDebeRetornarLaCadenaRespectiva() {
        ExtractorSecuenciaHorizontal extractorSecuenciaHorizontal = new ExtractorSecuenciaHorizontal();
        String[] coleccion1D = {"ATGC","CAGT","TTAT", "AGAA"};
        ADN adn = new ADN(coleccion1D);
        int posicionActualEjeX = 0;
        int posicionActualEjeY =0;
        String resultadoEsperado = "ATGC";

        String resultado = extractorSecuenciaHorizontal.obtenerSencuencia(adn, posicionActualEjeX, posicionActualEjeY);

        assertEquals(resultadoEsperado, resultado);
    }
}