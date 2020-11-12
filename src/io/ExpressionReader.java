package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * ExpressionReader
 */
public class ExpressionReader {
    File file;

    public ExpressionReader(String file) {
        this.file = new File(file);
    }

    public String[] getLines() {
        ArrayList<String> result = new ArrayList();
        try {
            Scanner in = new Scanner(file);
            while (in.hasNextLine())
                result.add(in.nextLine());
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return result.toArray(new String[]{});
    }
}
