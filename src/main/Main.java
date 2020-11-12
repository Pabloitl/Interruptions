package main;

import java.util.Scanner;

import evaluator.Evaluator;
import evaluator.EvaluatorApplier;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        new EvaluatorApplier(in.nextLine(), in.nextLine()).apply();
    }
}
