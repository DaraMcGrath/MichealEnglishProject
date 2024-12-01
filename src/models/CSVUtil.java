package src.models;

import java.io.*;
import java.util.ArrayList;

public class CSVUtil {
    public static void writeCSV(String filePath, String data) throws IOException {
        FileWriter writer = null;
        try {
            writer = new FileWriter(filePath, true); // Append mode
        } catch (FileNotFoundException e) {
            System.out.println("File not found: Generating file");
            File file = new File(filePath);
            writer = new FileWriter(filePath);
        }
        writer.write(data + "\n");
        writer.flush();
        writer.close();
    }

    public static ArrayList<String> readCSV(String filePath) throws IOException {
        ArrayList<String> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                data.add(line);
            }
        }
        return data;
    }
}
