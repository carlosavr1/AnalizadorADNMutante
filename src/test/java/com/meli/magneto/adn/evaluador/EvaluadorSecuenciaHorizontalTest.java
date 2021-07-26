package com.meli.magneto.adn.evaluador;

import com.meli.magneto.adn.ADN;
import com.meli.magneto.adn.extractor.ExtractorSecuenciaHorizontal;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class EvaluadorSecuenciaHorizontalTest {

    @Test
    void evaluarSecuenciaDebeEvaluarLaSecuencia() {
        ExtractorSecuenciaHorizontal extractorCadenaHorizontal = Mockito.mock(ExtractorSecuenciaHorizontal.class);
        EvaluadorSecuenciaHorizontal evaluadorSecuenciaHorizontal = Mockito.spy(new EvaluadorSecuenciaHorizontal(extractorCadenaHorizontal));
        String[] coleccion1D = {"ATGC","CAGT","TTAT", "AGAA"};
        ADN adn = new ADN(coleccion1D);
        boolean resultadoEsperado = false;
        int posicionActualEjeX = 0;
        int posicionActualEjeY = 0;
        String instruccionSecuenciaRegex = "(AAAA|TTTT|CCCC|GGGG)";
        String secuencia = "ATGC";
        Mockito.when( extractorCadenaHorizontal.obtenerSencuencia(adn, posicionActualEjeX, posicionActualEjeY) ).thenReturn(secuencia);
        Mockito.when( evaluadorSecuenciaHorizontal.tieneSecuenciaMutante(secuencia, instruccionSecuenciaRegex) ).thenReturn(false);

        boolean resultado = evaluadorSecuenciaHorizontal.evaluarSecuencia(adn, posicionActualEjeX, posicionActualEjeY, instruccionSecuenciaRegex);

        assertEquals(resultadoEsperado, resultado);
    }
}