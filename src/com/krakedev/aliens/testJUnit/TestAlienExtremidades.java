package com.krakedev.aliens.testJUnit;

import org.junit.jupiter.api.Test;

import com.krakedev.aliens.Alien;

import static org.junit.jupiter.api.Assertions.*;

public class TestAlienExtremidades {

    // ---------- Casos válidos ----------

    @Test
    public void testAgregarBrazosValido() {
        Alien alien = new Alien(10, "Verde");
        boolean resultado = alien.agregarBrazos(4);
        assertTrue(resultado);
        assertEquals(4, alien.getNumeroBrazos());
    }

    @Test
    public void testAgregarPiernasValido() {
        Alien alien = new Alien(10, "Verde");
        boolean resultado = alien.agregarPiernas(3);
        assertTrue(resultado);
        assertEquals(3, alien.getNumeroPies());
    }

    // ---------- Casos límite ----------

    @Test
    public void testAgregarBrazosEnElLimiteExacto() {
        Alien alien = new Alien(10, "Verde");
        boolean resultado = alien.agregarBrazos(10);
        assertTrue(resultado);
        assertEquals(10, alien.getNumeroBrazos());
    }

    @Test
    public void testAgregarBrazosExcedeElLimite() {
        Alien alien = new Alien(10, "Verde");
        boolean resultado = alien.agregarBrazos(11);
        assertFalse(resultado);
        assertEquals(0, alien.getNumeroBrazos());
    }

    @Test
    public void testAgregarPiernasEnElLimiteExacto() {
        Alien alien = new Alien(10, "Verde");
        boolean resultado = alien.agregarPiernas(10);
        assertTrue(resultado);
        assertEquals(10, alien.getNumeroPies());
    }

    @Test
    public void testAgregarPiernasExcedeElLimite() {
        Alien alien = new Alien(10, "Verde");
        boolean resultado = alien.agregarPiernas(11);
        assertFalse(resultado);
        assertEquals(0, alien.getNumeroPies());
    }

    // ---------- Casos combinados ----------

    @Test
    public void testAgregarBrazosYLuegoPiernasDentroDelLimite() {
        Alien alien = new Alien(10, "Verde");
        boolean resultadoBrazos = alien.agregarBrazos(6);
        boolean resultadoPiernas = alien.agregarPiernas(4);

        assertTrue(resultadoBrazos);
        assertTrue(resultadoPiernas);
        assertEquals(6, alien.getNumeroBrazos());
        assertEquals(4, alien.getNumeroPies());
    }

    @Test
    public void testAgregarBrazosYLuegoPiernasExcedeElLimite() {
        Alien alien = new Alien(10, "Verde");
        boolean resultadoBrazos = alien.agregarBrazos(7);
        boolean resultadoPiernas = alien.agregarPiernas(5); // 7 + 5 = 12 > 10

        assertTrue(resultadoBrazos);
        assertFalse(resultadoPiernas);
        assertEquals(7, alien.getNumeroBrazos());
        assertEquals(0, alien.getNumeroPies()); // no se agregó nada
    }

    @Test
    public void testAgregarPiernasYLuegoBrazosEnElLimiteExacto() {
        Alien alien = new Alien(10, "Verde");
        boolean resultadoPiernas = alien.agregarPiernas(5);
        boolean resultadoBrazos = alien.agregarBrazos(5); // 5 + 5 = 10, justo en el límite

        assertTrue(resultadoPiernas);
        assertTrue(resultadoBrazos);
        assertEquals(5, alien.getNumeroPies());
        assertEquals(5, alien.getNumeroBrazos());
    }

    @Test
    public void testMultiplesLlamadasAcumulanCorrectamente() {
        Alien alien = new Alien(10, "Verde");
        alien.agregarBrazos(2);
        alien.agregarBrazos(2);
        alien.agregarPiernas(3);

        assertEquals(4, alien.getNumeroBrazos());
        assertEquals(3, alien.getNumeroPies());
    }
}