package uvg.edu.gt;

import java.util.EmptyStackException;

/**
 * Clase que implementa una lista enlazada simple.
 *
 * @param <T> el tipo de elementos almacenados en la lista enlazada
 */
public class ListaEnlazadaSimple<T> implements IListaEnlazada<T> {
    private INodo<T> head;

    /**
     * Constructor para crear una nueva lista enlazada simple vacía.
     */
    public ListaEnlazadaSimple() {
        this.head = null;
    }

    /**
     * Agrega un elemento al principio de la lista enlazada.
     *
     * @param dato el elemento que se va a agregar
     */
    @Override
    public void addFirst(T dato) {
        INodo<T> nuevoNodo = new NodoSimple<>(dato);
        if (head == null) {
            head = nuevoNodo;
        } else {
            nuevoNodo.setNext(head);
            head = nuevoNodo;
        }
    }

    /**
     * Elimina y devuelve el primer elemento de la lista enlazada.
     *
     * @return el primer elemento de la lista enlazada
     * @throws EmptyStackException si la lista enlazada está vacía
     */
    @Override
    public T removeFirst() {
        if (head == null) {
            throw new EmptyStackException();
        }

        T datoBorrado = head.getData();
        head = head.getNext();
        return datoBorrado;
    }

    /**
     * Obtiene el primer elemento de la lista enlazada sin eliminarlo.
     *
     * @return el primer elemento de la lista enlazada
     * @throws EmptyStackException si la lista enlazada está vacía
     */
    @Override
    public T getFirst() {
        if (head == null) {
            throw new EmptyStackException();
        }
        return head.getData();
    }

    /**
     * Verifica si la lista enlazada está vacía.
     *
     * @return true si la lista enlazada está vacía, false de lo contrario
     */
    @Override
    public boolean empty() {
        return head == null;
    }
}