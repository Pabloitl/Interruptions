package evaluator;

import java.io.File; // Importamos la clase File

import io.ExpressionReader; // Importamos la clase ExpressionReader
import io.ResultWriter; // Importamos la clase ResultWriter

/**
 * EvaluatorApplier
 */
public class EvaluatorApplier {
    String in, out; // Declaramos las dos variables tipo string

    public EvaluatorApplier(String in, String out) { // Creamos el Constructor
        this.in = in;
        this.out = out;
    }

    public void apply() {
        String[] expr = new ExpressionReader(in).getLines(); // Creamos un arrreglo de tipo String
        int[] results = new int[expr.length]; // Creamos un arrreglo de tipo int

        for (int i = 0; i < expr.length; ++i) // Con el for recorremos todo el arreglo para saber su tamaño
            results[i] = Evaluator.evaluate(expr[i]);

        new ResultWriter(out).writeResults(results); // Creamos un nuevo objecto llamado ResultWriter
    }
}
