package readFromFile;

import java.io.*;
import java.util.Scanner;

public class ReadFromFile {

    public static
    void odstranMezery(String data){
        data = data.replaceAll("\\s+", " ");
        //char[] charArray = new char[data.length()];
        //naplní charaArray
        /*for(int i = 0; i < data.length(); i++){
            charArray[i] = data.charAt(i);
            if(Character.isWhitespace((char) charArray[i])) //... je bílý
            {
                 charArray[i] = " ";

            }
        }*/

    }

    public static void nactiData() {

        try {
            File myObj = new File("../input.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                //tady něco udělat
                odstranMezery(data);
                System.out.println(data);
                zapisData(data);
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
            BufferedWriter writer = new BufferedWriter(new FileWriter("input1.txt"));
            writer.write(data);
            writer.close();
        } catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();

    } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
