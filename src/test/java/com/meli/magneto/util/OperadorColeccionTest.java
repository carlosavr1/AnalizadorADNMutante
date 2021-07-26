package com.meli.magneto.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperadorColeccionTest {

    @Test
    void convertirColeccion1DA2DDebeRetornarUnaColeccion2DAlSerLlamado() {
        String[] coleccion1D = {"ATG","CAG","TTA"};

        String coleccion2D[][] = OperadorColeccion.convertirColeccion1DA2D(coleccion1D);

        assertEquals("A", coleccion2D[0][0]);
        assertEquals("T", coleccion2D[0][1]);
        assertEquals("G", coleccion2D[0][2]);
        assertEquals("C", coleccion2D[1][0]);
        assertEquals("A", coleccion2D[1][1]);
        assertEquals("G", coleccion2D[1][2]);
        assertEquals("T", coleccion2D[2][0]);
        assertEquals("T", coleccion2D[2][1]);
        assertEquals("A", coleccion2D[2][2]);
    }
}