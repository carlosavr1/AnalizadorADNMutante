package com.meli.magneto.adn.evaluador;

import com.meli.magneto.adn.ADN;
import com.meli.magneto.adn.extractor.ExtractorSecuenciaVertical;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class EvaluadorSecuenciaVerticalTest {

    @Test
    void evaluarSecuenciaDebeEvaluarLaSecuencia() {
        ExtractorSecuenciaVertical extractorCadenaVertical = Mockito.mock(ExtractorSecuenciaVertical.class);
        EvaluadorSecuenciaVertical evaluadorSecuenciaVertical = Mockito.spy(new EvaluadorSecuenciaVertical(extractorCadenaVertical));
        String[] coleccion1D = {"ATGC","CAGT","TTAT", "AGAA"};
        ADN adn = new ADN(coleccion1D);
        boolean resultadoEsperado = false;
        int posicionActualEjeX = 0;
        int posicionActualEjeY = 0;
        String instruccionSecuenciaRegex = "(AAAA|TTTT|CCCC|GGGG)";
        String secuencia = "ATGC";
        Mockito.when( extractorCadenaVertical.obtenerSencuencia(adn, posicionActualEjeX, posicionActualEjeY) ).thenReturn(secuencia);
        Mockito.when( evaluadorSecuenciaVertical.tieneSecuenciaMutante(secuencia, instruccionSecuenciaRegex) ).thenReturn(false);

        boolean resultado = evaluadorSecuenciaVertical.evaluarSecuencia(adn, posicionActualEjeX, posicionActualEjeY, instruccionSecuenciaRegex);

        assertEquals(resultadoEsperado, resultado);
    }
}