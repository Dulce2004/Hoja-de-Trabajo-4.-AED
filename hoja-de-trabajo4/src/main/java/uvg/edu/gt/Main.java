package uvg.edu.gt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Clase principal que ejecuta la calculadora con diferentes tipos de stacks.
 */
public class Main {

    /**
     * Método principal que inicia la aplicación.
     *
     * @param args los argumentos de la línea de comandos (no se utilizan)
     */
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("hoja-de-trabajo4\\src\\main\\java\\uvg\\edu\\gt\\datos.txt"));
            Scanner entrada = new Scanner(System.in);

            System.out.println("[Sistema]: Archivo txt cargado correctamente.\n");
            System.out.println(
                    "---------- Calculadora Infix ----------\n[Sistema]: ¿Qué implementación de Stack desea usar?\n1. ArrayList\n2. Vector\n3. Lista");
            String opcion = entrada.nextLine();

            // Validación de la entrada del usuario
            while (!esCadenaNumeroValida(opcion) || Integer.parseInt(opcion) < 1 || Integer.parseInt(opcion) > 3) {
                System.out.println("\n[Sistema]: Por favor, ingrese una opción válida (1, 2 o 3).");
                opcion = entrada.nextLine();
            }

            String tipoStack;
            int opt = Integer.parseInt(opcion);

            switch (opt) {
                case 1:
                    tipoStack = "ArrayList";
                    break;
                case 2:
                    tipoStack = "Vector";
                    break;
                case 3:
                    System.out.println("[Sistema]: ¿Qué tipo de lista desea implementar?\n1. Simple\n2. Doble");
                    String tipoLista = entrada.nextLine();

                    // Validación de la entrada del usuario
                    while (!esCadenaNumeroValida(tipoLista) || Integer.parseInt(tipoLista) < 1
                            || Integer.parseInt(tipoLista) > 2) {
                        System.out.println("\n[Sistema]: Por favor, ingrese una opción válida (1 o 2).");
                        tipoLista = entrada.nextLine();
                    }

                    int listaTipo = Integer.parseInt(tipoLista);

                    switch (listaTipo) {
                        case 1:
                            tipoStack = "ListaSimple";
                            break;
                        case 2:
                            tipoStack = "ListaDoble";
                            break;
                        default:
                            throw new IllegalStateException("[Sistema]: Opción de lista inválida.");
                    }
                    break;
                default:
                    throw new IllegalStateException("[Sistema]: Opción de stack inválida.");
            }

            // Crear instancia de la calculadora con el tipo de stack seleccionado
            Calculadora calculadora = Calculadora.getInstance(tipoStack);

            // Procesar cada línea del archivo de entrada
            while (scanner.hasNextLine()) {
                String cadena = scanner.nextLine();
                int resultado = calculadora.calcular(cadena);

                // Mostrar resultado o mensaje de error correspondiente
                switch (resultado) {
                    case -10:
                        System.out.println("[Sistema]: Error. Carácter no reconocido en la expresión.");
                        break;
                    case -20:
                        System.out.println("[Sistema]: Error. Insuficientes operandos para realizar una operación.");
                        break;
                    case -30:
                        System.out.println("[Sistema]: Error. División entre cero detectada.");
                        break;
                    case -40:
                        System.out.println("[Sistema]: Error. Expresión vacía.");
                        break;
                    default:
                        System.out.println("[Sistema]: Resultado: " + resultado);
                }
            }

            System.out.println("\n[Sistema]: Gracias por usar nuestro programa :).");
            scanner.close();
            entrada.close();
        } catch (FileNotFoundException e) {
            System.err.println("Error: No se pudo cargar o leer el archivo." + e.getMessage());
        } catch (IllegalStateException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Método auxiliar que verifica si una cadena es una representación válida de un
     * número entero.
     *
     * @param cadena La cadena que se va a verificar.
     * @return true si la cadena es una representación válida de un número entero,
     *         false en caso contrario.
     */
    private static boolean esCadenaNumeroValida(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}