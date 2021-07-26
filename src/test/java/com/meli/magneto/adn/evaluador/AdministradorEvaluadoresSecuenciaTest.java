package com.meli.magneto.adn.evaluador;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AdministradorEvaluadoresSecuenciaTest {
    AdministradorEvaluadoresSecuencia administradorEvaluadoresSecuencia;

    @BeforeEach
    void setUp() {
        EvaluadorSecuenciaHorizontal evaluadorSecuenciaHorizontal = Mockito.mock(EvaluadorSecuenciaHorizontal.class);
        EvaluadorSecuenciaVertical evaluadorSecuenciaVertical = Mockito.mock(EvaluadorSecuenciaVertical.class);
        EvaluadorSecuenciaDiagIzqDer evaluadorSecuenciaDiagIzqDer = Mockito.mock(EvaluadorSecuenciaDiagIzqDer.class);
        EvaluadorSecuenciaDiagDerIzq evaluadorSecuenciaDiagDerIzq = Mockito.mock(EvaluadorSecuenciaDiagDerIzq.class);
        administradorEvaluadoresSecuencia = new AdministradorEvaluadoresSecuencia(evaluadorSecuenciaHorizontal, evaluadorSecuenciaVertical, evaluadorSecuenciaDiagIzqDer, evaluadorSecuenciaDiagDerIzq);
    }

    @Test
    void definirEvaluadoresCadenaDebeRetornarTodosLosEvaluadoresAlSerTrueTodasLasCondiciones() {
        ArrayList<EvaluadorSecuenciaADN> evaluadoresEsperados = new ArrayList<>();
        boolean evaluarHorizontal = true;
        boolean evaluarVertical = true;
        boolean evaluarDiagIzqDer = true;
        boolean evaluarDiagDerIzq = true;
        int tamanoEvaluadoresEsperado = 4;

        ArrayList<EvaluadorSecuenciaADN> evaluadores = administradorEvaluadoresSecuencia.definirEvaluadoresCadena(evaluadoresEsperados, evaluarHorizontal, evaluarVertical, evaluarDiagIzqDer, evaluarDiagDerIzq);

        assertEquals(tamanoEvaluadoresEsperado, evaluadores.size());
    }

    @Test
    void determinarEvaluarHorizontalDebeRetornarTrueCuandoLaDiferenciaEntreElTamanoADNYLaPosicionActualEjeYEsMayorATres() {
        int posicionActualEjeY = 0;
        int tamanoADN = 4;
        boolean resultadoEsperado = true;

        boolean resultado = administradorEvaluadoresSecuencia.determinarEvaluarHorizontal(posicionActualEjeY, tamanoADN);

        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    void determinarEvaluarHorizontalDebeRetornarFalseCuandoLaDiferenciaEntreElTamanoADNYLaPosicionActualEjeYNoEsMayorATres() {
        int posicionActualEjeY = 1;
        int tamanoADN = 4;
        boolean resultadoEsperado = false;

        boolean resultado = administradorEvaluadoresSecuencia.determinarEvaluarHorizontal(posicionActualEjeY, tamanoADN);

        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    void determinarEvaluarVerticalDebeRetornarTrueCuandoLaDiferenciaEntreElTamanoADNYLaPosicionActualEjeXEsMayorATres() {
        int posicionActualEjeX = 0;
        int tamanoADN = 4;
        boolean resultadoEsperado = true;

        boolean resultado = administradorEvaluadoresSecuencia.determinarEvaluarVertical(posicionActualEjeX, tamanoADN);

        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    void determinarEvaluarVerticalDebeRetornarFalseCuandoLaDiferenciaEntreElTamanoADNYLaPosicionActualEjeXNoEsMayorATres() {
        int posicionActualEjeX = 1;
        int tamanoADN = 4;
        boolean resultadoEsperado = false;

        boolean resultado = administradorEvaluadoresSecuencia.determinarEvaluarVertical(posicionActualEjeX, tamanoADN);

        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    void determinarEvaluarDiagDerIzqDebeRetornarTrueCuandoLaDiferenciaEntreElTamanoADNYLaPosicionActualEjeXEsMayorATresYLaPosicionActualEjeYEsMayorADos() {
        int posicionActualEjeX = 0;
        int posicionActualEjeY = 3;
        int tamanoADN = 4;
        boolean resultadoEsperado = true;

        boolean resultado = administradorEvaluadoresSecuencia.determinarEvaluarDiagDerIzq(posicionActualEjeX, posicionActualEjeY, tamanoADN);

        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    void determinarEvaluarDiagDerIzqDebeRetornarFalseCuandoLaDiferenciaEntreElTamanoADNYLaPosicionActualEjeXEsMenorACuatroYLaPosicionActualEjeYEsMayorADos() {
        int posicionActualEjeX = 1;
        int posicionActualEjeY = 3;
        int tamanoADN = 4;
        boolean resultadoEsperado = false;

        boolean resultado = administradorEvaluadoresSecuencia.determinarEvaluarDiagDerIzq(posicionActualEjeX, posicionActualEjeY, tamanoADN);

        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    void determinarEvaluarDiagDerIzqDebeRetornarFalseCuandoLaDiferenciaEntreElTamanoADNYLaPosicionActualEjeXEsMayorATresYLaPosicionActualEjeYEsMenorATres() {
        int posicionActualEjeX = 0;
        int posicionActualEjeY = 2;
        int tamanoADN = 4;
        boolean resultadoEsperado = false;

        boolean resultado = administradorEvaluadoresSecuencia.determinarEvaluarDiagDerIzq(posicionActualEjeX, posicionActualEjeY, tamanoADN);

        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    void determinarEvaluarDiagDerIzqDebeRetornarFalseCuandoLaDiferenciaEntreElTamanoADNYLaPosicionActualEjeXEsMenorACuatroYLaPosicionActualEjeYEsMenorATres() {
        int posicionActualEjeX = 1;
        int posicionActualEjeY = 2;
        int tamanoADN = 4;
        boolean resultadoEsperado = false;

        boolean resultado = administradorEvaluadoresSecuencia.determinarEvaluarDiagDerIzq(posicionActualEjeX, posicionActualEjeY, tamanoADN);

        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    void determinarEvaluarDiagIzqDerDebeRetornarTrueCuandoLaDiferenciaEntreElTamanoADNYLaPosicionActualEjeXEsMayorATresYLaDiferenciaEntreElTamanoADNYLaPosicionActualEjeYEsMayorATres() {
        int posicionActualEjeX = 0;
        int posicionActualEjeY = 0;
        int tamanoADN = 4;
        boolean resultadoEsperado = true;

        boolean resultado = administradorEvaluadoresSecuencia.determinarEvaluarDiagIzqDer(posicionActualEjeX, posicionActualEjeY, tamanoADN);

        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    void determinarEvaluarDiagIzqDerDebeRetornarFalseCuandoLaDiferenciaEntreElTamanoADNYLaPosicionActualEjeXEsMenorACuatroYLaDiferenciaEntreElTamanoADNYLaPosicionActualEjeYEsMayorATres() {
        int posicionActualEjeX = 1;
        int posicionActualEjeY = 0;
        int tamanoADN = 4;
        boolean resultadoEsperado = false;

        boolean resultado = administradorEvaluadoresSecuencia.determinarEvaluarDiagIzqDer(posicionActualEjeX, posicionActualEjeY, tamanoADN);

        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    void determinarEvaluarDiagIzqDerDebeRetornarTrueCuandoLaDiferenciaEntreElTamanoADNYLaPosicionActualEjeXEsMayorATresYLaDiferenciaEntreElTamanoADNYLaPosicionActualEjeYEsMenorACuatro() {
        int posicionActualEjeX = 0;
        int posicionActualEjeY = 1;
        int tamanoADN = 4;
        boolean resultadoEsperado = false;

        boolean resultado = administradorEvaluadoresSecuencia.determinarEvaluarDiagIzqDer(posicionActualEjeX, posicionActualEjeY, tamanoADN);

        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    void determinarEvaluarDiagIzqDerDebeRetornarTrueCuandoLaDiferenciaEntreElTamanoADNYLaPosicionActualEjeXEsMenorACuatroYLaDiferenciaEntreElTamanoADNYLaPosicionActualEjeYEsMenorACuatro() {
        int posicionActualEjeX = 1;
        int posicionActualEjeY = 1;
        int tamanoADN = 4;
        boolean resultadoEsperado = false;

        boolean resultado = administradorEvaluadoresSecuencia.determinarEvaluarDiagIzqDer(posicionActualEjeX, posicionActualEjeY, tamanoADN);

        assertEquals(resultadoEsperado, resultado);
    }

}