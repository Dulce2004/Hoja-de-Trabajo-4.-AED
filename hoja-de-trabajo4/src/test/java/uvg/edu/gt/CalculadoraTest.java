package uvg.edu.gt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Clase de pruebas unitarias para la clase Calculadora.
 */
public class CalculadoraTest {

    /**
     * Prueba para calcular una expresión utilizando ArrayList como implementación
     * de stack.
     */
    @Test
    public void pruebaCalcularArrayList() {
        Calculadora calculadora = Calculadora.getInstance("ArrayList");

        assertEquals(9, calculadora.calcular("(1+2)*3"));
    }

    /**
     * Prueba para calcular una expresión utilizando Vector como implementación de
     * stack.
     */
    @Test
    public void pruebaCalcularVector() {
        Calculadora calculadora1 = Calculadora.getInstance("Vector");

        assertEquals(9, calculadora1.calcular("(1+2)*3"));
    }

    /**
     * Prueba para calcular una expresión utilizando ListaSimple como implementación
     * de stack.
     */
    @Test
    public void pruebaCalcularListaSimple() {
        Calculadora calculadora2 = Calculadora.getInstance("ListaSimple");

        assertEquals(9, calculadora2.calcular("(1+2)*3"));
    }

    /**
     * Prueba para calcular una expresión utilizando ListaDoble como implementación
     * de stack.
     */
    @Test
    public void pruebaCalcularListaDoble() {
        Calculadora calculadora3 = Calculadora.getInstance("ListaDoble");

        assertEquals(9, calculadora3.calcular("(1+2)*3"));
    }

    /**
     * Prueba para verificar que la instancia de Calculadora sea única.
     */
    @Test
    public void pruebaDeInstancia() {
        Calculadora calculadora1 = Calculadora.getInstance("ListaSimple");
        Calculadora calculadora2 = Calculadora.getInstance("ListaDoble");

        assertTrue(calculadora1 == calculadora2);
    }
}