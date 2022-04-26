package be.intecbrussel.examples.files;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

public class Maternity {
    public static void main(String[] args) {
        Person joni = new Person("Joni", "Mitchell", LocalDate.of(1990, 10, 4));

        try {
            Path path = Paths.get("Users/avivashuman/Documents/Joni_Mitchell.ser");
            Files.createDirectories(path.getParent());
            if(Files.notExists(path)){
                Files.createFile(path);
                System.out.println("file created");
            }else{
                System.out.println("file already exists");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(FileOutputStream file = new FileOutputStream("Users/avivashuman/Documents/Joni_Mitchell.ser");
            ObjectOutputStream outputStream = new ObjectOutputStream(file);){
            outputStream.writeObject(joni);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
       /* try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        */
    }
}
