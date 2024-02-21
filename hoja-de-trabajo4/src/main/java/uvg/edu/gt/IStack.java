package uvg.edu.gt;

/**
 * Interfaz para una pila genérica.
 *
 * @param <T> el tipo de elementos almacenados en la pila
 */
public interface IStack<T> {

    /**
     * Agrega un elemento a la cima de la pila.
     *
     * @param dato el elemento que se va a agregar
     */
    public void push(T dato);

    /**
     * Elimina y devuelve el elemento en la cima de la pila.
     *
     * @return el elemento en la cima de la pila
     */
    public T pop();

    /**
     * Obtiene el elemento en la cima de la pila sin eliminarlo.
     *
     * @return el elemento en la cima de la pila
     */
    public T peek();

    /**
     * Verifica si la pila está vacía.
     *
     * @return true si la pila está vacía, false de lo contrario
     */
    public boolean empty();
}