package com.meli.magneto.adn.db.modelo;

public class ADNRegistro {

    String id;
    String identificadorHash;
    String[] adn;
    String tipo;
    int cantidad;

    public ADNRegistro(String id, String identificadorHash, String[] adn, String tipo, int cantidad) {
        this.id = id;
        this.identificadorHash = identificadorHash;
        this.adn = adn;
        this.tipo = tipo;
        this.cantidad = cantidad;
    }

    public String getId() {
        return id;
    }

    public String getIdentificadorHash() {
        return identificadorHash;
    }

    public String[] getAdn() {
        return adn;
    }

    public String getTipo() {
        return tipo;
    }

    public int getCantidad() {
        return cantidad;
    }
}
