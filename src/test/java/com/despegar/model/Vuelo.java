package com.despegar.model;

public class Vuelo {
    private String origen;
    private String destino;
    private double precioIda;
    private double precioVuelta;
    // Otros campos y métodos relevantes

    public Vuelo(String origen, String destino, double precioIda, double precioVuelta) {
        this.origen = origen;
        this.destino = destino;
        this.precioIda = precioIda;
        this.precioVuelta = precioVuelta;
        // Inicializar otros campos
    }
    // Getters y setters para los campos
}