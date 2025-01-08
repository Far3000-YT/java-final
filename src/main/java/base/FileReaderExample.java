package base;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class FileReaderExample {
    public static LinkedList<String> textReader(String filePath){
        LinkedList<String> list = new LinkedList<>();

        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fileReader);
            String line;

            while ((line = br.readLine()) != null){
                list.add(line);
            }

            br.close();
        } 
        
        catch (FileNotFoundException e) {
            System.out.println("File not found !!! " + e);
        } 
        
        catch (IOException e) {
            System.out.println("Exception XD - " + e);
        }
        
        return list;
    }

    public static void textWriter(String filePath, LinkedList<String> line_added){
        try {
            FileWriter fileWriter = new FileWriter(filePath, true);
            BufferedWriter br = new BufferedWriter(fileWriter);
            for (String line : line_added){
                br.write("\n" + line);
            }

            br.close();
        } 
        
        catch (FileNotFoundException e) {
            System.out.println("File not found !!! " + e);
        } 
        
        catch (IOException e) {
            System.out.println("Exception XD - " + e);
        }
    }
}