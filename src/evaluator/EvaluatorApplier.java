package evaluator;

import java.io.File;

import io.ExpressionReader;
import io.ResultWriter;

/**
 * EvaluatorApplier
 */
public class EvaluatorApplier {
    String in, out;

    public EvaluatorApplier(String in, String out) {
        this.in = in;
        this.out = out;
    }

    public void apply() {
        String[] expr = new ExpressionReader(in).getLines();
        int[] results = new int[expr.length];

        for (int i = 0; i < expr.length; ++i)
            results[i] = Evaluator.evaluate(expr[i]);

        new ResultWriter(out).writeResults(results);
    }
}
