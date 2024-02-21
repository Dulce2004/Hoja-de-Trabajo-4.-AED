package uvg.edu.gt;

/**
 * Clase que implementa un nodo doble utilizado en estructuras de datos
 * enlazadas.
 *
 * @param <T> el tipo de datos almacenados en el nodo
 */
public class NodoDoble<T> implements INodo<T> {
    private T dato;
    private INodo<T> prev;
    private INodo<T> next;

    /**
     * Constructor para crear un nuevo nodo doble con el dato proporcionado.
     *
     * @param dato el dato a almacenar en el nodo
     */
    public NodoDoble(T dato) {
        this.dato = dato;
        this.prev = null;
        this.next = null;
    }

    /**
     * Obtiene el dato almacenado en el nodo.
     *
     * @return el dato almacenado en el nodo
     */
    @Override
    public T getData() {
        return dato;
    }

    /**
     * Obtiene el siguiente nodo en la estructura enlazada.
     *
     * @return el siguiente nodo en la estructura enlazada, o null si no hay
     *         siguiente nodo
     */
    @Override
    public INodo<T> getNext() {
        return next;
    }

    /**
     * Obtiene el nodo previo en la estructura enlazada.
     *
     * @return el nodo previo en la estructura enlazada, o null si no hay nodo
     *         previo
     */
    public INodo<T> getPrev() {
        return prev;
    }

    /**
     * Establece el siguiente nodo en la estructura enlazada.
     *
     * @param nodo el siguiente nodo que se establecerá
     * @return 1 si se estableció correctamente, -1 si el nodo proporcionado es nulo
     */
    @Override
    public int setNext(INodo<T> nodo) {
        if (nodo == null) {
            return -1;
        }
        this.next = nodo;
        return 1;
    }

    /**
     * Establece el nodo previo en la estructura enlazada.
     *
     * @param nodo el nodo previo que se establecerá
     * @return 1 si se estableció correctamente, -1 si el nodo proporcionado es nulo
     */
    public int setPrev(INodo<T> nodo) {
        if (nodo == null) {
            return -1;
        }
        this.prev = nodo;
        return 1;
    }
}