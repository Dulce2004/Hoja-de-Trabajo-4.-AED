package uvg.edu.gt;

import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * Clase que implementa una pila utilizando un ArrayList.
 *
 * @param <T> el tipo de elementos almacenados en la pila
 */
public class StackArrayList<T> implements IStack<T> {
    private ArrayList<T> pila;

    /**
     * Constructor para crear una nueva pila utilizando un ArrayList.
     */
    public StackArrayList() {
        this.pila = new ArrayList<>();
    }

    /**
     * Agrega un elemento a la cima de la pila.
     *
     * @param dato el elemento que se va a agregar
     */
    @Override
    public void push(T dato) {
        pila.add(dato);
    }

    /**
     * Elimina y devuelve el elemento en la cima de la pila.
     *
     * @return el elemento en la cima de la pila
     * @throws EmptyStackException si la pila está vacía
     */
    @Override
    public T pop() {
        if (empty()) {
            throw new EmptyStackException();
        }
        return pila.remove(pila.size() - 1);
    }

    /**
     * Obtiene el elemento en la cima de la pila sin eliminarlo.
     *
     * @return el elemento en la cima de la pila
     * @throws EmptyStackException si la pila está vacía
     */
    @Override
    public T peek() {
        if (empty()) {
            throw new EmptyStackException();
        }
        return pila.get(pila.size() - 1);
    }

    /**
     * Verifica si la pila está vacía.
     *
     * @return true si la pila está vacía, false de lo contrario
     */
    @Override
    public boolean empty() {
        return pila.isEmpty();
    }
}