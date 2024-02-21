package uvg.edu.gt;

/**
 * Clase que implementa un nodo simple utilizado en estructuras de datos
 * enlazadas.
 *
 * @param <T> el tipo de datos almacenados en el nodo
 */
public class NodoSimple<T> implements INodo<T> {
    private T dato;
    private INodo<T> next;

    /**
     * Constructor para crear un nuevo nodo simple con el dato proporcionado.
     *
     * @param dato el dato a almacenar en el nodo
     */
    public NodoSimple(T dato) {
        this.dato = dato;
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
     * Método no válido para un nodo simple.
     *
     * @throws UnsupportedOperationException siempre que este método sea llamado
     */
    @Override
    public INodo<T> getPrev() {
        throw new UnsupportedOperationException("[Sistema]: Método inválido para Nodo Simple.");
    }

    /**
     * Método no válido para un nodo simple.
     *
     * @throws UnsupportedOperationException siempre que este método sea llamado
     */
    @Override
    public int setPrev(INodo<T> nodo) {
        throw new UnsupportedOperationException("[Sistema]: Método inválido para Nodo Simple.");
    }
}