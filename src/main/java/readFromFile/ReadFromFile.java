package readFromFile;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class ReadFromFile {

    public static String odstranMezery(String data){
         data =  data.replaceAll("\\s+", " ");
        // data = data.replaceAll("\n", "");
         return data;
    }

    public static void numberLines() {
        try {
            File myObj = new File("../text.txt");
            Scanner myReader = new Scanner(myObj);
            int i = 0;
            BufferedReader br = new BufferedReader(new FileReader("../text.txt"));
            FileWriter fw = new FileWriter(myObj, true); // co delá to true a false když mi funguje jen true
            BufferedWriter bw = new BufferedWriter(fw);
            String data = "";
            //tady nevím jak daný řádek přepsat
            while  (myReader.hasNextLine())
            {
                String temp = myReader.nextLine();
                data = i + " " + temp + "\n";
                System.out.println(data);
                i++;
                bw.write(data);
            }

            bw.close();
            myReader.close();



        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void nactiData() {

        try {
            System.out.println(" data try");
            File myObj = new File("../text.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = odstranMezery(myReader.nextLine());
                if(!data.isBlank()){
                    System.out.println(data.isBlank());
                    zapisData(data, "../text.txt", "output.txt");
                }else{
                    System.out.println("empty line");
                }

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void zapisData(String data, String input, String output){
        try{
            //File myObj = new File("../input.txt");
            //BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));

            Path path = Paths.get(input);
            FileWriter fw = new FileWriter(output, true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(data);
            bw.newLine();
            bw.close();
        } catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();

    } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
