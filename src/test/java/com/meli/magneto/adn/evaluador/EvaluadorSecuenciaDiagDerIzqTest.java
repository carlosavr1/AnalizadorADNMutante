package com.meli.magneto.adn.evaluador;

import com.meli.magneto.adn.ADN;
import com.meli.magneto.adn.extractor.ExtractorSecuenciaDiagDerIzq;
import com.meli.magneto.adn.extractor.ExtractorSecuenciaDiagIzqDer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class EvaluadorSecuenciaDiagDerIzqTest {

    @Test
    void evaluarSecuenciaDebeEvaluarLaSecuencia() {
        ExtractorSecuenciaDiagDerIzq extractorSecuenciaDiagDerIzq = Mockito.mock(ExtractorSecuenciaDiagDerIzq.class);
        EvaluadorSecuenciaDiagDerIzq evaluadorSecuenciaDiagDerIzq = Mockito.spy(new EvaluadorSecuenciaDiagDerIzq(extractorSecuenciaDiagDerIzq));
        String[] coleccion1D = {"ATGC","CAGT","TTAT", "AGAA"};
        ADN adn = new ADN(coleccion1D);
        boolean resultadoEsperado = false;
        int posicionActualEjeX = 0;
        int posicionActualEjeY = 0;
        String instruccionSecuenciaRegex = "(AAAA|TTTT|CCCC|GGGG)";
        String secuencia = "ATGC";
        Mockito.when( extractorSecuenciaDiagDerIzq.obtenerSencuencia(adn, posicionActualEjeX, posicionActualEjeY) ).thenReturn(secuencia);
        Mockito.when( evaluadorSecuenciaDiagDerIzq.tieneSecuenciaMutante(secuencia, instruccionSecuenciaRegex) ).thenReturn(false);

        boolean resultado = evaluadorSecuenciaDiagDerIzq.evaluarSecuencia(adn, posicionActualEjeX, posicionActualEjeY, instruccionSecuenciaRegex);

        assertEquals(resultadoEsperado, resultado);
    }
}