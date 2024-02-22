package uvg.edu.gt;

import java.util.ArrayList;

/**
 * Clase que implementa una calculadora para evaluar expresiones en notación
 * infija y posfija.
 */
public class Calculadora implements CalculadoraPOSTFIX {
    private static Calculadora instance;
    private IStack<Integer> pilaInt;
    private IStack<Character> pilaChar;

    /**
     * Constructor privado para crear una instancia de la calculadora.
     *
     * @param tipoStack el tipo de pila a utilizar ("ArrayList", "Vector",
     *                  "ListaSimple" o "ListaDoble")
     */
    private Calculadora(String tipoStack) {
        StackFactory<Integer> stackerInt = new StackFactory<>();
        StackFactory<Character> stackerChar = new StackFactory<>();
        pilaInt = stackerInt.crearStack(tipoStack);
        pilaChar = stackerChar.crearStack(tipoStack);
    }

    /**
     * Método estático para obtener una instancia de la calculadora (patrón
     * Singleton).
     *
     * @param tipoStack el tipo de pila a utilizar ("ArrayList", "Vector",
     *                  "ListaSimple" o "ListaDoble")
     * @return la instancia de la calculadora
     */
    public static synchronized Calculadora getInstance(String tipoStack) {
        if (instance == null) {
            instance = new Calculadora(tipoStack);
        }
        return instance;
    }

    /**
     * Convierte una expresión en notación infija a notación posfija.
     *
     * @param expresionInfix la expresión en notación infija
     * @return la expresión en notación posfija
     */
    private String convertirInfixToPostfix(String expresionInfix) {
        StringBuilder postfix = new StringBuilder();
        pilaChar.push('#');

        for (char caracter : expresionInfix.toCharArray()) {
            if (Character.isLetterOrDigit(caracter)) {
                postfix.append(caracter).append(" "); // Agregar espacio después de cada operando
            } else if (caracter == '(' || caracter == '^') {
                pilaChar.push(caracter);
            } else if (caracter == ')') {
                while (pilaChar.peek() != '(') {
                    postfix.append(pilaChar.pop()).append(" "); // Agregar espacio después de cada operador
                }
                pilaChar.pop();
            } else {
                while (!pilaChar.empty() && precedence(caracter) <= precedence(pilaChar.peek())) {
                    postfix.append(pilaChar.pop()).append(" "); // Agregar espacio después de cada operador
                }
                pilaChar.push(caracter);
            }
        }

        while (pilaChar.peek() != '#') {
            postfix.append(pilaChar.pop()).append(" "); // Agregar espacio después de cada operador
        }

        return postfix.toString();
    }

    /**
     * Obtiene la precedencia de un operador.
     *
     * @param operador el operador
     * @return la precedencia del operador
     */
    private int precedence(char operador) {
        switch (operador) {
            case '^':
                return 3;
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                return 0;
        }
    }

    /**
     * Calcula el resultado de una expresión en notación posfija.
     *
     * @param cadenaInFix la expresión en notación infija
     * @return el resultado de la evaluación de la expresión, o un código de error
     *         si la expresión es inválida
     */
    @Override
    public int calcular(String cadenaInFix) {
        String txtPostFix = convertirInfixToPostfix(cadenaInFix);
        ArrayList<String> cadenaPostFix = new ArrayList<>();
        int contadorDeVariables = 0;

        for (String elemento : txtPostFix.split(" ")) {
            cadenaPostFix.add(elemento);
        }

        for (String variable : cadenaPostFix) {
            if (variable.equals("+") || variable.equals("-") || variable.equals("*") || variable.equals("/")) {
                if (contadorDeVariables < 2) {
                    return -20;
                }
                int operandoB = pilaInt.pop();
                int operandoA = pilaInt.pop();
                switch (variable) {
                    case "+":
                        pilaInt.push(operandoA + operandoB);
                        break;
                    case "-":
                        pilaInt.push(operandoA - operandoB);
                        break;
                    case "*":
                        pilaInt.push(operandoA * operandoB);
                        break;
                    case "/":
                        if (operandoB == 0) {
                            return -30;
                        }
                        pilaInt.push(operandoA / operandoB);
                        break;
                    default:
                        return -10;
                }
                contadorDeVariables--;
            } else {
                try {
                    pilaInt.push(Integer.parseInt(variable));
                    contadorDeVariables++;
                } catch (NumberFormatException e) {
                    return -10;
                }
            }
        }

        if (contadorDeVariables == 1) {
            return pilaInt.pop();
        } else {
            return -20;
        }
    }
}