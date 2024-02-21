package uvg.edu.gt;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Clase de pruebas unitarias para la clase StackArrayList.
 */
public class StackArrayListTest {

    /**
     * Prueba para verificar los métodos push y peek de la pila implementada con
     * ArrayList.
     */
    @Test
    public void metodosPushPeek() {
        StackArrayList<Integer> pilaPrueba = new StackArrayList<>();
        pilaPrueba.push(1);
        pilaPrueba.push(2);
        pilaPrueba.push(3);
        pilaPrueba.push(4);
        pilaPrueba.push(5);
        int valPrueba = pilaPrueba.peek();

        assertEquals(5, valPrueba);
    }

    /**
     * Prueba para verificar los métodos pop y empty de la pila implementada con
     * ArrayList.
     */
    @Test
    public void metodosPopEmpty() {
        StackArrayList<Integer> pilaPrueba = new StackArrayList<>();
        pilaPrueba.push(1);
        pilaPrueba.push(2);
        pilaPrueba.push(3);
        pilaPrueba.push(4);
        pilaPrueba.push(5);
        int valPrueba = pilaPrueba.pop();
        boolean boolPrueba = pilaPrueba.empty();

        assertEquals(5, valPrueba);
        assertEquals(false, boolPrueba);
    }
}