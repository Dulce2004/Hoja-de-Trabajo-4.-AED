package uvg.edu.gt;

/**
 * Interfaz para una lista enlazada genérica.
 *
 * @param <T> el tipo de elementos almacenados en la lista enlazada
 */
public interface IListaEnlazada<T> {

    /**
     * Agrega un elemento al principio de la lista enlazada.
     *
     * @param dato el elemento que se va a agregar
     */
    public void addFirst(T dato);

    /**
     * Elimina y devuelve el primer elemento de la lista enlazada.
     *
     * @return el primer elemento de la lista enlazada
     */
    public T removeFirst();

    /**
     * Obtiene el primer elemento de la lista enlazada sin eliminarlo.
     *
     * @return el primer elemento de la lista enlazada
     */
    public T getFirst();

    /**
     * Verifica si la lista enlazada está vacía.
     *
     * @return true si la lista enlazada está vacía, false de lo contrario
     */
    public boolean empty();
}