package com.meli.magneto.api;

import com.meli.magneto.acl.ValidadorACL;
import com.meli.magneto.adn.AdministradorADN;
import com.meli.magneto.adn.modelo.Estadisticas;
import com.meli.magneto.api.dto.ADNSolicitud;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class DetectorMutanteWSTest {

    @Test
    void esMutanteDebeRetornarHTTP200CuandoElADNEsMutante() throws Exception {
        String[] adn = {"ADN"};
        ADNSolicitud peticion = new ADNSolicitud();
        peticion.setDna(adn);
        DetectorMutanteWS detectorMutanteWS = new DetectorMutanteWS() {
            @Override
            public void prepararDependencias() throws Exception {
                validadorACL = Mockito.mock(ValidadorACL.class);
                Mockito.when(validadorACL.esUnADNCorrecto(adn)).thenReturn(true);
                administradorADN = Mockito.mock(AdministradorADN.class);
                Mockito.when(administradorADN.isMutant(any())).thenReturn(true);
            }
        };
        int resultadoEsperado = Response.Status.OK.getStatusCode();

        Response resultado = detectorMutanteWS.esMutante(peticion);

        assertEquals(resultadoEsperado, resultado.getStatus());
    }

    @Test
    void esMutanteDebeRetornarHTTP403CuandoElADNNoEsMutante() throws Exception {
        String[] adn = {"ADN"};
        ADNSolicitud peticion = new ADNSolicitud();
        peticion.setDna(adn);
        DetectorMutanteWS detectorMutanteWS = new DetectorMutanteWS() {
            @Override
            public void prepararDependencias() throws Exception {
                validadorACL = Mockito.mock(ValidadorACL.class);
                Mockito.when(validadorACL.esUnADNCorrecto(adn)).thenReturn(true);
                administradorADN = Mockito.mock(AdministradorADN.class);
                Mockito.when(administradorADN.isMutant(any())).thenReturn(false);
            }
        };
        int resultadoEsperado = Response.Status.FORBIDDEN.getStatusCode();

        Response resultado = detectorMutanteWS.esMutante(peticion);

        assertEquals(resultadoEsperado, resultado.getStatus());
    }

    @Test
    void esMutanteDebeRetornarHTTP400CuandoElADNEsIncorrecto() throws Exception {
        String[] adn = {"ADN"};
        ADNSolicitud peticion = new ADNSolicitud();
        peticion.setDna(adn);
        DetectorMutanteWS detectorMutanteWS = new DetectorMutanteWS() {
            @Override
            public void prepararDependencias() throws Exception {
                validadorACL = Mockito.mock(ValidadorACL.class);
                Mockito.when(validadorACL.esUnADNCorrecto(adn)).thenReturn(false);
                administradorADN = Mockito.mock(AdministradorADN.class);
                Mockito.when(administradorADN.isMutant(any())).thenReturn(true);
            }
        };
        int resultadoEsperado = Response.Status.BAD_REQUEST.getStatusCode();

        Response resultado = detectorMutanteWS.esMutante(peticion);

        assertEquals(resultadoEsperado, resultado.getStatus());
    }

    @Test
    void obtenerEstadisticasDebeRetornarLasEstadisticas() throws Exception {
        Estadisticas estadisticasEsperadas = new Estadisticas(1, 1, 1);
        DetectorMutanteWS detectorMutanteWS = new DetectorMutanteWS() {
            @Override
            public void prepararDependencias() throws Exception {
                administradorADN = Mockito.mock(AdministradorADN.class);
                Mockito.when(administradorADN.getStats()).thenReturn(estadisticasEsperadas);
            }
        };
        int resultadoEsperado = Response.Status.OK.getStatusCode();

        Response resultado = detectorMutanteWS.obtenerEstadisticas();

        assertEquals(resultadoEsperado, resultado.getStatus());
        assertEquals(estadisticasEsperadas, resultado.getEntity());
    }
}