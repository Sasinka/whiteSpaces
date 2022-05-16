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



    public static void nactiData() {

        try {
            File myObj = new File("../text.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = odstranMezery(myReader.nextLine());
                if(!data.isBlank()){
                    System.out.println(data.isBlank());
                    zapisData(data);
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

    public static void zapisData(String data){
        try{
            //File myObj = new File("../input.txt");
            //BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));

            Path path = Paths.get("input.txt");
/*            int lines = 0;
            try{
                lines = (int)Files.lines(path).count();
                System.out.println("Counted : "+ lines + " lines");
            }catch (IOException e){
                System.out.println("lines not counted");
            }
            */
            FileWriter fw = new FileWriter("output.txt", true);
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
