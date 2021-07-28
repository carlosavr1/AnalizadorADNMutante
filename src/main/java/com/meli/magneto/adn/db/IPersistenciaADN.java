package com.meli.magneto.adn.db;

public interface IPersistenciaADN {

    public void crearCliente() throws Exception;

    public void crearADNRegistro(String identificadorHashADN, String[] adn, String tipo, int cantidad)  throws Exception;

}
