package com.krakedev.aliens.test;

import com.krakedev.aliens.Alien;

public class TestConstructores {
    public static void main(String[] args) {
        Alien alien1 = new Alien(10, "Verde");
        System.out.println("Alien 1:");
        alien1.imprimir();

        Alien alien2 = new Alien(2, "Azul");
        System.out.println("Alien 2:");
        alien2.imprimir();

        Alien alien3 = new Alien(50, "Rojo");
        System.out.println("Alien 3:");
        alien3.imprimir();

        Alien alien4 = new Alien(30, "Morado");
        System.out.println("Alien 4:");
        alien4.imprimir();
    }
}