package com.krakedev.aliens;

public class Alien {
    private int tamanio;
    private String color;
    private int numeroOjos;
    private int numeroBrazos;
    private int numeroPies;
    private double precioExtremidad;
    private double precioOjo;
    private double precioCuerpo;

    public Alien(int tamanio, String color) {
        if (tamanio < 5) {
            tamanio = 5;
        } else if (tamanio > 30) {
            tamanio = 30;
        }

        this.tamanio = tamanio;
        this.color = color;

        this.precioCuerpo = tamanio * 0.20;
        this.precioExtremidad = tamanio * 0.10;
        this.precioOjo = tamanio * 0.05;
    }
}