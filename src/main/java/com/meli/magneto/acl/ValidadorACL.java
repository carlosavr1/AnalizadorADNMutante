package com.meli.magneto.acl;

public class ValidadorACL {

    private String instruccionGeneticaRegex = "[ATCG]+";

    public boolean esUnADNCorrecto(String[] adn) {
        int cantidadFilas = adn.length;
        if( cantidadFilas < 4 ) {
            return false;
        }else {
            for (String fila : adn) {
                if( fila.length() != cantidadFilas || !tieneInstruccionGeneticaCorrecta(fila)) {
                    return false;
                }
            }
            return true;
        }
    }

    public boolean tieneInstruccionGeneticaCorrecta(String fila) {
        return fila.matches(instruccionGeneticaRegex);
    }
}
