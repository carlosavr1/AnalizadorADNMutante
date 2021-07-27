package com.meli.magneto.acl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidadorACLTest {

    @Test
    void esUnADNCorrectoDebeRetornarFalseCuandoElTamanoSeaMenorACuatro(){
        String[] adn = {"AAA", "AAA", "AAA"};
        ValidadorACL validadorACL = new ValidadorACL();
        boolean resultadoEsperado = false;

        boolean resultado = validadorACL.esUnADNCorrecto( adn );

        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    void esUnADNCorrectoDebeRetornarFalseCuandoElTamanoSeaMayorATresYAlMenosUnElementoTengaElTamanoDiferenteALaCantidadDeElementosYTengaLasInstruccionesPermitidas(){
        String[] adn = {"AAAA", "AAAA", "AAAA", "TTT"};
        ValidadorACL validadorACL = new ValidadorACL();
        boolean resultadoEsperado = false;

        boolean resultado = validadorACL.esUnADNCorrecto( adn );

        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    void esUnADNCorrectoDebeRetornarFalseCuandoElTamanoSeaMayorATresYTodosLosElementoTengaElMismoTamanoALaCantidadDeElementosYTengaAlMenosUnaInstruccionesNoPermitida(){
        String[] adn = {"AAAA", "AAAA", "AAAA", "AAAP"};
        ValidadorACL validadorACL = new ValidadorACL();
        boolean resultadoEsperado = false;

        boolean resultado = validadorACL.esUnADNCorrecto( adn );

        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    void esUnADNCorrectoDebeRetornarTrueCuandoElTamanoSeaMayorACuatroYTodosLosElementoTengaElMismoTamanoALaCantidadDeElementosYTengaInstruccionesPermitidas(){
        String[] adn = {"AAAA", "AAAT", "AAAC", "AAAG"};
        ValidadorACL validadorACL = new ValidadorACL();
        boolean resultadoEsperado = true;

        boolean resultado = validadorACL.esUnADNCorrecto( adn );

        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    void tieneInstruccionGeneticaCorrectaDebeRetornarFalsoCuandoFilaNoCumplaElPatron(){
        String fila = "ATPG";
        ValidadorACL validadorACL = new ValidadorACL();
        boolean resultadoEsperado = false;

        boolean resultado = validadorACL.tieneInstruccionGeneticaCorrecta( fila );

        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    void tieneInstruccionGeneticaCorrectaDebeRetornarTrueCuandoFilaCumplaElPatron(){
        String fila = "ATGG";
        ValidadorACL validadorACL = new ValidadorACL();
        boolean resultadoEsperado = true;
        boolean resultado = validadorACL.tieneInstruccionGeneticaCorrecta( fila );

        assertEquals(resultadoEsperado, resultado);
    }

}