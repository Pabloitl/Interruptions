package io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

/**
 * ResultWriter
 */
public class ResultWriter {
    File file;

    public ResultWriter(String file) {
        this.file = new File(file);
    }

    public void writeResults(int[] results) {
        try {
            FileWriter writer = new FileWriter(file);

            for (int i : results) {
                writer.write(String.valueOf(i) + "\n");
                System.out.println(i);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
