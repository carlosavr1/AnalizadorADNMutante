package com.meli.magneto.util;

import java.math.BigInteger;
import java.security.MessageDigest;

public class Codificador {

    public String md5HashString( String texto ) throws Exception {
        String ALGORITMO_DE_CODIFICACION = "MD5";
        int SIGNO_POSITIVO = 1;
        int BASE = 16;
        return new BigInteger( SIGNO_POSITIVO, MessageDigest.getInstance( ALGORITMO_DE_CODIFICACION ).digest( texto.getBytes() ) ).toString( BASE );
    }
}
