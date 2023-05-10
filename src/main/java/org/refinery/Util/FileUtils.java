package org.refinery.Util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileUtils {
    private File file;
    public FileUtils(String filepath) {
        file = new File(filepath);
    }

    public String toString() {
        String string = "";
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file.getPath()));
            String line = reader.readLine();

            while (line != null) {
                string+=line;
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return string;
    }
}
