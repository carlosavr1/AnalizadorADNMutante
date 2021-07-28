package com.meli.magneto.api.controlador;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControladorBaseTest {

    @Test
    void prepararDependenciasDebeInstanciarTodasLasClasesNecesarias() throws Exception {
        ControladorBase controladorBase = new ControladorBase();
        controladorBase.prepararDependencias();

        assertNotNull(controladorBase.validadorACL);
        assertNotNull(controladorBase.administradorADN);
        assertNotNull(controladorBase.administradorEvaluadoresSecuencia);
        assertNotNull(controladorBase.evaluadorSecuenciaHorizontal);
        assertNotNull(controladorBase.evaluadorSecuenciaVertical);
        assertNotNull(controladorBase.evaluadorSecuenciaDiagIzqDer);
        assertNotNull(controladorBase.evaluadorSecuenciaDiagDerIzq);

    }
}