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

    public int getTamanio() {
        return tamanio;
    }

    public String getColor() {
        return color;
    }

    public int getNumeroOjos() {
        return numeroOjos;
    }

    public int getNumeroBrazos() {
        return numeroBrazos;
    }

    public int getNumeroPies() {
        return numeroPies;
    }

    public double getPrecioExtremidad() {
        return precioExtremidad;
    }

    public double getPrecioOjo() {
        return precioOjo;
    }

    public double getPrecioCuerpo() {
        return precioCuerpo;
    }

    public void imprimir() {
        System.out.println("----- Datos del Alien -----");
        System.out.println("Tamaño: " + tamanio + " cm");
        System.out.println("Color: " + color);
        System.out.println("Número de ojos: " + numeroOjos);
        System.out.println("Número de brazos: " + numeroBrazos);
        System.out.println("Número de pies: " + numeroPies);
        System.out.println("Precio cuerpo: $" + precioCuerpo);
        System.out.println("Precio extremidad: $" + precioExtremidad);
        System.out.println("Precio ojo: $" + precioOjo);
        System.out.println("----------------------------");
    }
    public boolean agregarBrazos(int cantidad) {
        if (this.numeroBrazos + this.numeroPies + cantidad > 10) {
            return false;
        }
        this.numeroBrazos += cantidad;
        return true;
    }
    public boolean agregarPiernas(int cantidad) {
        if (this.numeroBrazos + this.numeroPies + cantidad > 10) {
            return false;
        }
        this.numeroPies += cantidad;
        return true;
    }
    public boolean agregarOjos(int cantidad) {
        int maximoOjos;

        if (this.tamanio >= 5 && this.tamanio <= 10) {
            maximoOjos = 3;
        } else if (this.tamanio > 10 && this.tamanio <= 20) {
            maximoOjos = 5;
        } else {
            maximoOjos = 7;
        }

        if (this.numeroOjos + cantidad > maximoOjos) {
            return false;
        }

        this.numeroOjos += cantidad;
        return true;
    }
}