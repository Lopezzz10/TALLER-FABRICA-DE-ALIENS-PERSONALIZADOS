package com.krakedev.aliens.testJUnit;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import com.krakedev.aliens.Alien;

import static org.junit.jupiter.api.Assertions.*;

public class TestAlienIAJUnit {

    @Test
    @DisplayName("El color se asigna correctamente sin transformación")
    public void testColorSeAsignaSinModificar() {
        Alien alien = new Alien(10, "Verde");
        assertEquals("Verde", alien.getColor());
    }

    @Test
    @DisplayName("Atributos numéricos no inicializados quedan en 0 por defecto")
    public void testAtributosNoInicializadosQuedanEnCero() {
        Alien alien = new Alien(10, "Verde");
        assertEquals(0, alien.getNumeroOjos());
        assertEquals(0, alien.getNumeroBrazos());
        assertEquals(0, alien.getNumeroPies());
    }

    @ParameterizedTest
    @DisplayName("Validación de límites de tamaño con múltiples valores")
    @CsvSource({
        "0, 5",
        "4, 5",
        "5, 5",
        "6, 6",
        "29, 29",
        "30, 30",
        "31, 30",
        "100, 30",
        "-10, 5"
    })
    public void testLimitesTamanioParametrizado(int entrada, int esperado) {
        Alien alien = new Alien(entrada, "Gris");
        assertEquals(esperado, alien.getTamanio());
    }

    @ParameterizedTest
    @DisplayName("Cálculo de precios proporcional al tamaño final ajustado")
    @CsvSource({
        "10, 2.0, 1.0, 0.5",
        "5, 1.0, 0.5, 0.25",
        "30, 6.0, 3.0, 1.5",
        "0, 1.0, 0.5, 0.25",
        "100, 6.0, 3.0, 1.5"
    })
    public void testCalculoPreciosParametrizado(int entrada, double cuerpo, double extremidad, double ojo) {
        Alien alien = new Alien(entrada, "Gris");
        assertEquals(cuerpo, alien.getPrecioCuerpo(), 0.0001);
        assertEquals(extremidad, alien.getPrecioExtremidad(), 0.0001);
        assertEquals(ojo, alien.getPrecioOjo(), 0.0001);
    }

    @Test
    @DisplayName("No existen métodos set (encapsulamiento estricto)")
    public void testNoExistenSetters() {
        long settersCount = java.util.Arrays.stream(Alien.class.getMethods())
                .filter(m -> m.getName().startsWith("set"))
                .count();
        assertEquals(0, settersCount);
    }

    @Test
    @DisplayName("Suma total de precios de un alien base es consistente")
    public void testSumaTotalPrecios() {
        Alien alien = new Alien(20, "Amarillo");
        double totalEsperado = alien.getPrecioCuerpo() + alien.getPrecioExtremidad() + alien.getPrecioOjo();
        assertEquals(totalEsperado, 4.0 + 2.0 + 1.0, 0.0001);
    }
}