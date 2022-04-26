package be.intecbrussel.examples.files;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class ReadingWriting {
    public static void main(String[] args) {

        Path path = Path.of("/Users/avivashuman/Documents/file.txt");



        /*FileWriter fileWriter = null;

        try {
            Path path = Path.of("/Users/avivashuman/Documents/file.txt");
            fileWriter = new FileWriter(path.toString());
            fileWriter.write("woodchuck");
            fileWriter.write("would chuck");

        } catch (IOException e) {
            throw new RuntimeException();
        }finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }*/
    }
}
