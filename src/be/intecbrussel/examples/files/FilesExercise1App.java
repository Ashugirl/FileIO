package be.intecbrussel.examples.files;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class FilesExercise1App {
    public static void main(String[] args) {
        try{
            Path path = Paths.get("/Users/avivashuman/Documents/examples_folder/file.txt");
            Files.createDirectories(path.getParent());
            if (Files.notExists(path)
            ) {
                Files.createFile(path);
                System.out.println("file created");
            } else {
                System.out.println("File already exists");
            }

            List<String> text = new ArrayList<>();
            text.add("How much wood");
            text.add("would a woodchuck chuck?");
            Files.write(path, text, Charset.forName("UTF-8"), StandardOpenOption.APPEND);

            BasicFileAttributes basicFileAttributes = Files.readAttributes(path, BasicFileAttributes.class);

            System.out.println(basicFileAttributes.size());
            System.out.println(basicFileAttributes.creationTime());
            System.out.println(basicFileAttributes.lastAccessTime());
            System.out.println(basicFileAttributes.lastModifiedTime());
            System.out.println(basicFileAttributes.isDirectory());
            System.out.println(basicFileAttributes.isRegularFile());
            System.out.println(Files.getOwner(path));

            Files.lines(path).forEach(System.out::println);


            Path path2 = Paths.get("/Users/avivashuman/Documents/examples_folder/file_copy.txt");
            Files.copy(path, path2, StandardCopyOption.REPLACE_EXISTING);

            /*Files.move(path2, path2.resolveSibling("newFileName"));
            BasicFileAttributes bfa = Files.readAttributes(path2, BasicFileAttributes.class);
            System.out.println(bfa.size());

             */
            Files.deleteIfExists(path);
            //Files.deleteIfExists(path2);
        } catch (IOException e){
            e.printStackTrace();
        }

        /*Path path = Path.of("/Users/avivashuman/Documents");

        File aDirectory = path.toFile();
        File[] files = aDirectory.listFiles();

        for (File file: files){
            if(file.isDirectory()){
                System.out.println("Dirctory: " + file.getName());
            }else
                System.out.println("File: " + file.getName());
        }
        Path path3 = Paths.get("file.txt");
        System.out.println(path3.toAbsolutePath());

         */
    }
}
