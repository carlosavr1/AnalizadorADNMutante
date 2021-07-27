package com.meli.magneto.api.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ADNSolicitudTest {

    @Test
    void getDnaDebeRetornarElADNDelObjeto() {
        ADNSolicitud aDNSolicitud = new ADNSolicitud();
        String[] adn = {"A"};
        aDNSolicitud.dna = adn;
        assertEquals(adn, aDNSolicitud.getDna());
    }

    @Test
    void setDnaDebeAsignarElADNAlObjeto() {
        ADNSolicitud aDNSolicitud = new ADNSolicitud();
        String[] adn = {"A"};
        aDNSolicitud.setDna(adn);;
        assertEquals(adn, aDNSolicitud.dna);
    }
}