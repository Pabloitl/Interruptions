/*
    Clase que evalúa expresiones
*/
package evaluator;

import java.util.Stack;

public class Evaluator {
    public static int evaluate(String expression) {
        //Convierte la expresión a un arreglo de char
        char[] tokens = expression.toCharArray();
        Stack<Integer> values = new Stack(); //Pila para almacenar valores
        Stack<Character> ops = new Stack();  //Pila para almacenar operadores

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i] == ' ')
                continue;   //Ignora los espacios
            if (tokens[i] >= '0' && tokens[i] <= '9') {
                // Si los tokens son números entre 0 y 9, se apilan en values
                StringBuffer sbuf = new StringBuffer();
                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
                    sbuf.append(tokens[i++]);
                values.push(Integer.parseInt(sbuf.toString()));
                i--;
            }
            //Si los tokens son paréntesis, se apilan en ops
            else if (tokens[i] == '(')
                ops.push(tokens[i]);
            else if (tokens[i] == ')') {
                // Se considera todo lo que hay entre paréntesis a valores
                while (ops.peek() != '(')
                    // Dependiendo del operador, se hace la operación 
                    // y se apila el resultado
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                ops.pop();
            }
            else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {
                // Se realizan las operaciones con los valores mientras haya operadores en la pila
                // y existan valores con qué poder realizarlas
                while (!ops.empty() && hasPrecedence(tokens[i], ops.peek()))
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                //Se apilan los operadores en la pila ops
                ops.push(tokens[i]);
            }
        }
        // Se realiza la evaluación mientras haya operadores en la pila
        while (!ops.empty())
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));
        // Regresa el último valor de la pila values, es decir, el resultado
        return values.pop();
    }

    // Método que indica si hay más operandos participando en la operación
    private static boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }

    // Método que realiza la evaluación de la expresión
    // Identifica la operación a realizar y los operandos
    private static int applyOp(char op, int b, int a) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0)
                    throw new UnsupportedOperationException("Cannot divide by zero");
                return a / b;
        }
        return 0;
    }
}
