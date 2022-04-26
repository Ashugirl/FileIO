package be.intecbrussel.examples.files;

import java.io.*;

public class CivilService {
    public static void main(String[] args) {
        try (FileInputStream fileInputStream = new FileInputStream("Users/avivashuman/Documents/Joni_Mitchell.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            Person person = (Person) objectInputStream.readObject();
            System.out.println(person);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        /*try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

         */
    }
}
