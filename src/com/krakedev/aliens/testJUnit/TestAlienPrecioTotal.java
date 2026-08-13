package com.krakedev.aliens.testJUnit;

import org.junit.jupiter.api.Test;

import com.krakedev.aliens.Alien;

import static org.junit.jupiter.api.Assertions.*;

public class TestAlienPrecioTotal {

    // ---------- Cálculo correcto del precio total ----------

    @Test
    public void testPrecioTotalInicialSoloConCuerpo() {
        Alien alien = new Alien(10, "Verde");
        // Sin brazos, pies ni ojos: precioTotal = precioCuerpo
        assertEquals(2.0, alien.getPrecioTotal(), 0.0001);
    }

    @Test
    public void testPrecioTotalConTamanioAjustadoAlMinimo() {
        Alien alien = new Alien(2, "Rojo"); // se ajusta a 5
        assertEquals(1.0, alien.getPrecioTotal(), 0.0001);
    }

    @Test
    public void testPrecioTotalDespuesDeAgregarBrazos() {
        Alien alien = new Alien(10, "Verde");
        alien.agregarBrazos(3);
        // precioCuerpo (2.0) + 3 brazos * precioExtremidad (1.0) = 5.0
        assertEquals(5.0, alien.getPrecioTotal(), 0.0001);
    }

    @Test
    public void testPrecioTotalDespuesDeAgregarPiernas() {
        Alien alien = new Alien(10, "Verde");
        alien.agregarPiernas(2);
        // precioCuerpo (2.0) + 2 pies * precioExtremidad (1.0) = 4.0
        assertEquals(4.0, alien.getPrecioTotal(), 0.0001);
    }

    @Test
    public void testPrecioTotalDespuesDeAgregarOjos() {
        Alien alien = new Alien(10, "Verde");
        alien.agregarOjos(3);
        // precioCuerpo (2.0) + 3 ojos * precioOjo (0.5) = 3.5
        assertEquals(3.5, alien.getPrecioTotal(), 0.0001);
    }

    @Test
    public void testPrecioTotalConBrazosPiernasYOjosCombinados() {
        Alien alien = new Alien(10, "Verde");
        alien.agregarBrazos(2);
        alien.agregarPiernas(2);
        alien.agregarOjos(3);
        // cuerpo (2.0) + (2+2)*extremidad (1.0) + 3*ojo (0.5) = 2.0 + 4.0 + 1.5 = 7.5
        assertEquals(7.5, alien.getPrecioTotal(), 0.0001);
    }

    // ---------- Comportamiento al agregar elementos ----------

    @Test
    public void testAgregarBrazosActualizaNumeroYPrecio() {
        Alien alien = new Alien(15, "Azul");
        boolean resultado = alien.agregarBrazos(4);
        assertTrue(resultado);
        assertEquals(4, alien.getNumeroBrazos());
        assertTrue(alien.getPrecioTotal() > alien.getPrecioCuerpo());
    }

    @Test
    public void testAgregarOjosActualizaNumeroYPrecio() {
        Alien alien = new Alien(15, "Azul");
        boolean resultado = alien.agregarOjos(4);
        assertTrue(resultado);
        assertEquals(4, alien.getNumeroOjos());
        assertTrue(alien.getPrecioTotal() > alien.getPrecioCuerpo());
    }

    @Test
    public void testOperacionRechazadaNoModificaPrecioTotal() {
        Alien alien = new Alien(10, "Verde");
        double precioAntes = alien.getPrecioTotal();

        boolean resultado = alien.agregarBrazos(11); // excede el límite de extremidades

        assertFalse(resultado);
        assertEquals(precioAntes, alien.getPrecioTotal(), 0.0001);
    }

    // ---------- Restricciones de negocio ----------

    @Test
    public void testNoSePuedenSuperarDiezExtremidadesEntreBrazosYPiernas() {
        Alien alien = new Alien(10, "Verde");
        alien.agregarBrazos(6);
        boolean resultado = alien.agregarPiernas(5); // 6 + 5 = 11 > 10

        assertFalse(resultado);
        assertEquals(6, alien.getNumeroBrazos());
        assertEquals(0, alien.getNumeroPies());
    }

    @Test
    public void testLimiteDeOjosSegunTamanioPequenio() {
        Alien alien = new Alien(8, "Gris"); // rango 5-10 -> máximo 3 ojos
        boolean resultado = alien.agregarOjos(4);

        assertFalse(resultado);
        assertEquals(0, alien.getNumeroOjos());
    }

    @Test
    public void testLimiteDeOjosSegunTamanioMedio() {
        Alien alien = new Alien(15, "Gris"); // rango >10-20 -> máximo 5 ojos
        boolean resultado = alien.agregarOjos(5);

        assertTrue(resultado);
        assertEquals(5, alien.getNumeroOjos());

        boolean resultadoExtra = alien.agregarOjos(1); // ya no caben más
        assertFalse(resultadoExtra);
        assertEquals(5, alien.getNumeroOjos());
    }

    @Test
    public void testLimiteDeOjosSegunTamanioGrande() {
        Alien alien = new Alien(25, "Gris"); // rango >20-30 -> máximo 7 ojos
        boolean resultado = alien.agregarOjos(8);

        assertFalse(resultado);
        assertEquals(0, alien.getNumeroOjos());
    }

    @Test
    public void testRestriccionesCombinadasNoAfectanPrecioTotalEnRechazo() {
        Alien alien = new Alien(8, "Gris"); // máximo 3 ojos
        alien.agregarOjos(3); // llega al límite
        double precioAntesDelRechazo = alien.getPrecioTotal();

        boolean resultado = alien.agregarOjos(1); // excede el límite

        assertFalse(resultado);
        assertEquals(precioAntesDelRechazo, alien.getPrecioTotal(), 0.0001);
    }
}