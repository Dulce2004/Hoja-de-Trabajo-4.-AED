package uvg.edu.gt;

/**
 * Clase que proporciona métodos para crear instancias de diferentes tipos de
 * pilas.
 *
 * @param <T> el tipo de elementos almacenados en la pila
 */
public class StackFactory<T> {

    /**
     * Crea y devuelve una instancia de pila del tipo especificado.
     *
     * @param tipo el tipo de pila a crear ("ArrayList", "Vector", "ListaSimple" o
     *             "ListaDoble")
     * @return una instancia de pila del tipo especificado, o null si el tipo no es
     *         válido
     */
    public IStack<T> crearStack(String tipo) {
        switch (tipo) {
            case "ArrayList":
                return new StackArrayList<>();
            case "Vector":
                return new StackVector<>();
            case "ListaSimple":
                return new StackListaEnlazada<>(tipo);
            case "ListaDoble":
                return new StackListaEnlazada<>(tipo);
            default:
                return null;
        }
    }
}