package com.krakedev.aliens.testJUnit;

import com.krakedev.aliens.Alien;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestAlien {

    @Test
    void testAsignacionDeAtributos() {
        Alien alien = new Alien(10, "Verde");
        assertEquals(10, alien.getTamanio());
        assertEquals("Verde", alien.getColor());
    }

    @Test
    void testTamanioMenorAlMinimoSeAjusta() {
        Alien alien = new Alien(2, "Rojo");
        assertEquals(5, alien.getTamanio());
    }

    @Test
    void testTamanioMayorAlMaximoSeAjusta() {
        Alien alien = new Alien(50, "Morado");
        assertEquals(30, alien.getTamanio());
    }

    @Test
    void testCalculoDePrecios() {
        Alien alien = new Alien(10, "Verde");
        assertEquals(2.0, alien.getPrecioCuerpo(), 0.0001);
        assertEquals(1.0, alien.getPrecioExtremidad(), 0.0001);
        assertEquals(0.5, alien.getPrecioOjo(), 0.0001);
    }
}