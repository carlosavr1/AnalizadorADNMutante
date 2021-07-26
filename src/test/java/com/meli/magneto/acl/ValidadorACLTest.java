package com.meli.magneto.acl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidadorACLTest {

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