package com.meli.magneto.adn.db;

import com.meli.magneto.adn.db.modelo.ADNRegistro;

public interface IPersistenciaADN {

    public void crearCliente() throws Exception;

    public void crearADNRegistro(ADNRegistro aDNRegistro)  throws Exception;

    public ADNRegistro consultarADNRegistro(String identificadorHashADN) throws Exception;

    public void actualizarCantidadADNRegistro(ADNRegistro aDNRegistro) throws Exception;

}
