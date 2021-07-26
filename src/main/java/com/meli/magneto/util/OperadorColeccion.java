package com.meli.magneto.util;

public class OperadorColeccion {

    public static String[][] convertirColeccion1DA2D(String[] coleccion){
        int tamanoColeccion1D = coleccion.length;
        String[][] coleccion2D = new String[tamanoColeccion1D][tamanoColeccion1D];
        for ( int x = 0; x<tamanoColeccion1D; x++) {
            for ( int y = 0; y<tamanoColeccion1D; y++) {
                coleccion2D[x][y] = String.valueOf(coleccion[x].charAt(y));
            }
        }
        return coleccion2D;
    }

}
