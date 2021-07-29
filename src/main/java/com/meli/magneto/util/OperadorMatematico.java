package com.meli.magneto.util;

public class OperadorMatematico {

    public double calcularTasa(int cantidadMutantes, int cantidadHumanos) {
        if(cantidadHumanos == 0){
            return 0;
        }else{
            return cantidadMutantes / (double)cantidadHumanos;
        }
    }
}
