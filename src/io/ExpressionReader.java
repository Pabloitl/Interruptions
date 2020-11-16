package io;

import java.io.File; // Importamos la clase FileWriter
import java.io.FileNotFoundException; // Importamos la clase FileNotFoundException
import java.util.ArrayList; // Importamos la clase ArrayList
import java.util.Scanner; // Importamos la clase Escaner

/**
 * ExpressionReader
 */
public class ExpressionReader {
    File file; // Creamos un archivo 

    public ExpressionReader(String file) {
        this.file = new File(file); // Leemos el archivo 
    }

    public String[] getLines() {
        ArrayList<String> result = new ArrayList(); // Creamos el ArrayList
        try { // Inicio donde pudiera saltar un error
            Scanner in = new Scanner(file); // Utilizamos el Scanner para leer el archivo
            while (in.hasNextLine()) // Recorreos el arrayList
                result.add(in.nextLine());
            in.close(); // Cerramos el archivo
        } catch (FileNotFoundException e) {
            e.printStackTrace(); // Imprimos donde fue el error
        }

        return result.toArray(new String[]{}); // Retornamos el resultado del Array
    }
}
