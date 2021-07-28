package com.meli.magneto.adn.db.modelo;

public class ADNRegistro {

    String id;
    String identificadorHash;
    String[] adn;
    String tipo;
    int cantidad;

    public ADNRegistro() {
    }

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

    public void setId(String id) {
        this.id = id;
    }

    public void setIdentificadorHash(String identificadorHash) {
        this.identificadorHash = identificadorHash;
    }

    public void setAdn(String[] adn) {
        this.adn = adn;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
