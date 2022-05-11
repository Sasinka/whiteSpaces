package readFromFile;

import java.io.*;
import java.util.Scanner;

public class ReadFromFile {


    public static void nactiData() {
        try {
            File myObj = new File("../input.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                //tady něco udělat
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
