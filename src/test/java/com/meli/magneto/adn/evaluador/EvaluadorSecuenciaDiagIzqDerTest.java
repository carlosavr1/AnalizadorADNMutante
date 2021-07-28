package com.meli.magneto.adn.evaluador;

import com.meli.magneto.adn.modelo.ADN;
import com.meli.magneto.adn.extractor.ExtractorSecuenciaDiagIzqDer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class EvaluadorSecuenciaDiagIzqDerTest {

    @Test
    void evaluarSecuenciaDebeEvaluarLaSecuencia() {
        ExtractorSecuenciaDiagIzqDer extractorSecuenciaDiagIzqDer = Mockito.mock(ExtractorSecuenciaDiagIzqDer.class);
        EvaluadorSecuenciaDiagIzqDer evaluadorSecuenciaDiagIzqDer = Mockito.spy(new EvaluadorSecuenciaDiagIzqDer(extractorSecuenciaDiagIzqDer));
        String[] coleccion1D = {"ATGC","CAGT","TTAT", "AGAA"};
        ADN adn = new ADN(coleccion1D);
        boolean resultadoEsperado = false;
        int posicionActualEjeX = 0;
        int posicionActualEjeY = 0;
        String instruccionSecuenciaRegex = "(AAAA|TTTT|CCCC|GGGG)";
        String secuencia = "ATGC";
        Mockito.when( extractorSecuenciaDiagIzqDer.obtenerSencuencia(adn, posicionActualEjeX, posicionActualEjeY) ).thenReturn(secuencia);
        Mockito.when( evaluadorSecuenciaDiagIzqDer.tieneSecuenciaMutante(secuencia, instruccionSecuenciaRegex) ).thenReturn(false);

        boolean resultado = evaluadorSecuenciaDiagIzqDer.evaluarSecuencia(adn, posicionActualEjeX, posicionActualEjeY, instruccionSecuenciaRegex);

        assertEquals(resultadoEsperado, resultado);
    }
}