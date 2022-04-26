package be.intecbrussel.examples.files;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class FilesApp {
    public static void main(String[] args) {
          try {
            Path path = Paths.get("/Users/avivashuman/Documents/test_folder/file");
            Files.createDirectories(path.getParent());
            if (Files.notExists(path)) {
                Files.createFile(path);
                System.out.println("File created");
            } else{
                System.out.println("File already exits");
            }

            System.out.println(path.toAbsolutePath());
            List<String> lines = new ArrayList<>();
            lines.add("Hello");
            lines.add("World");
            Files.write(path, lines, Charset.forName("UTF-8"), StandardOpenOption.APPEND);
            BasicFileAttributes attrs = Files.readAttributes(path, BasicFileAttributes.class);
            System.out.println(attrs.size());
            System.out.println(attrs.creationTime());
            System.out.println(attrs.lastAccessTime());
            System.out.println(attrs.lastModifiedTime());
           // System.out.println(attrs.isArchive());
            //System.out.println(attrs.isHidden());
            //System.out.println(attrs.isReadOnly());

            Files.lines(path).forEach(System.out::println);

            Path path2 = Paths.get("/Users/avivashuman/Documents/test_folder/file_copy.txt");
            Files.copy(path, path2, StandardCopyOption.REPLACE_EXISTING);

            Files.deleteIfExists(path);
        } catch (IOException e){
            e.printStackTrace();
        }



        /*try{
            FileSystem fs = FileSystems.getDefault();
            System.out.println(fs.getSeparator());
            for (Path p : fs.getRootDirectories()){
                System.out.println(p);
            }
        } catch (IOException e){
            e.printStackTrace();
        }

         */
    }
}
