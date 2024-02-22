package uvg.edu.gt;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Clase de pruebas unitarias para la clase ListaEnlazadaSimple.
 */
public class ListaSimpleTest {

    /**
     * Prueba para verificar los métodos push y peek de la lista enlazada simple.
     */
    @Test
    public void metodosPushPeek() {
        ListaEnlazadaSimple<Integer> listaPrueba = new ListaEnlazadaSimple<>();
        listaPrueba.addFirst(1);
        listaPrueba.addFirst(2);
        listaPrueba.addFirst(3);
        listaPrueba.addFirst(4);
        listaPrueba.addFirst(5);
        int valPrueba = listaPrueba.getFirst();

        assertEquals(5, valPrueba);
    }

    /**
     * Prueba para verificar los métodos pop y empty de la lista enlazada simple.
     */
    @Test
    public void metodosPopEmpty() {
        ListaEnlazadaSimple<Integer> listaPrueba = new ListaEnlazadaSimple<>();
        listaPrueba.addFirst(1);
        listaPrueba.addFirst(2);
        listaPrueba.addFirst(3);
        listaPrueba.addFirst(4);
        listaPrueba.addFirst(5);
        int valPrueba = listaPrueba.removeFirst();
        boolean boolPrueba = listaPrueba.empty();

        assertEquals(5, valPrueba);
        assertEquals(false, boolPrueba);
    }
}