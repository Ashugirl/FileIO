package be.intecbrussel.examples.files;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesEx2App {
    public static void main(String[] args) {


    try(FileWriter fileWriter = new FileWriter("/Users/avivashuman/Documents/examples_folder/file.txt");
    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)){
        bufferedWriter.write("The quick brow fox");
        bufferedWriter.write(" jumped over the lazy dog.");
        bufferedWriter.append("\nWhy is the dog so lazy?");
        bufferedWriter.newLine();
        bufferedWriter.append("I don't know. Why is the fox so quick?");

    /*try(FileWriter fileWriter = new FileWriter("/Users/avivashuman/Documents/examples_folder/file.txt")){
        fileWriter.write("The quick brow fox");
        fileWriter.write(" jumped over the lazy dog.");
        fileWriter.append("\nWhy is the dog so lazy?");

     */



        } catch (IOException e) {
        System.out.println("Computer says no....");
        System.out.println(e.getMessage());
    }

    Path path1 = Paths.get("/Users/avivashuman/Documents/examples_folder/file.txt");
    try (BufferedReader reader = Files.newBufferedReader(path1)){
        String line = null;
        while((line = reader.readLine()) != null){
            System.out.println(line);

        }

    }catch (IOException e){
        System.out.println("Nope");
        System.out.println(e.getMessage());
    }
    /*try(FileReader fileReader = new FileReader("/Users/avivashuman/Documents/examples_folder/file.txt")){
        int character;
        while ((character = fileReader.read()) !=-1) {
            System.out.println((char) character);
        }
    }catch (IOException e){
        System.out.println(e.getMessage());
    }

     */

    }
}
