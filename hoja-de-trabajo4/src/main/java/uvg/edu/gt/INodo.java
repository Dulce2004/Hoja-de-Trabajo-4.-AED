package uvg.edu.gt;

/**
 * Interfaz para un nodo genérico utilizado en estructuras de datos enlazadas.
 *
 * @param <T> el tipo de datos almacenados en el nodo
 */
public interface INodo<T> {

    /**
     * Obtiene el dato almacenado en el nodo.
     *
     * @return el dato almacenado en el nodo
     */
    public T getData();

    /**
     * Obtiene el siguiente nodo en la estructura enlazada.
     *
     * @return el siguiente nodo en la estructura enlazada, o null si no hay
     *         siguiente nodo
     */
    public INodo<T> getNext();

    /**
     * Establece el siguiente nodo en la estructura enlazada.
     *
     * @param nodo el siguiente nodo que se establecerá
     * @return 1 si se estableció correctamente, -1 si ocurrió un error
     */
    public int setNext(INodo<T> nodo);

    /**
     * Obtiene el nodo previo en la estructura enlazada.
     *
     * @return el nodo previo en la estructura enlazada, o null si no hay nodo
     *         previo
     */
    public INodo<T> getPrev();

    /**
     * Establece el nodo previo en la estructura enlazada.
     *
     * @param nodo el nodo previo que se establecerá
     * @return 1 si se estableció correctamente, -1 si ocurrió un error
     */
    public int setPrev(INodo<T> nodo);
}