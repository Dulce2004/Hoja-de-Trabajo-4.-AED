package uvg.edu.gt;

/**
 * Clase que implementa una pila utilizando una lista enlazada.
 *
 * @param <T> el tipo de elementos almacenados en la pila
 */
public class StackListaEnlazada<T> implements IStack<T> {
    private IListaEnlazada<T> pila;

    /**
     * Constructor que crea una pila utilizando una lista enlazada del tipo
     * especificado.
     *
     * @param tipoLista el tipo de lista enlazada a utilizar ("ListaSimple" o
     *                  "ListaDoble")
     * @throws IllegalArgumentException si el tipo de lista no es válido
     */
    public StackListaEnlazada(String tipoLista) {
        switch (tipoLista) {
            case "ListaSimple":
                this.pila = new ListaEnlazadaSimple<>();
                break;
            case "ListaDoble":
                this.pila = new ListaEnlazadaDoble<>();
                break;
            default:
                throw new IllegalArgumentException("[Sistema]: Tipo de lista no válido: " + tipoLista);
        }
    }

    /**
     * Agrega un elemento a la cima de la pila.
     *
     * @param dato el elemento que se va a agregar
     */
    @Override
    public void push(T dato) {
        pila.addFirst(dato);
    }

    /**
     * Elimina y devuelve el elemento en la cima de la pila.
     *
     * @return el elemento en la cima de la pila
     */
    @Override
    public T pop() {
        return pila.removeFirst();
    }

    /**
     * Obtiene el elemento en la cima de la pila sin eliminarlo.
     *
     * @return el elemento en la cima de la pila
     */
    @Override
    public T peek() {
        return pila.getFirst();
    }

    /**
     * Verifica si la pila está vacía.
     *
     * @return true si la pila está vacía, false de lo contrario
     */
    @Override
    public boolean empty() {
        return pila.empty();
    }
}