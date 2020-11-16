package main;

import java.util.Scanner; // Importamos la clase Escaner

import evaluator.Evaluator; // Importamos la clase Evauator
import evaluator.EvaluatorApplier; // Importamos la clase EvaluatorApplier

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); // Se crea un objecto Scanner

        new EvaluatorApplier(in.nextLine(), in.nextLine()).apply(); // Se lee todo el objecto de la clase Applier
    }
}
