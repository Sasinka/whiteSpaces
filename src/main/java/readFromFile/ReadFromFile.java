package readFromFile;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

import static java.lang.Character.SPACE_SEPARATOR;
import static java.lang.Long.parseLong;

public class ReadFromFile {

    public static String odstranMezery(String data) {
        data = data.replaceAll("\\s+", " ");
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
            while (myReader.hasNextLine()) {
                String temp = myReader.nextLine();
                data = i + " " + temp + "\n";
                System.out.println(data);
                i++;
                bw.write(data);
            }

            bw.close();
            myReader.close();


        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int numberOfWord(String inputFile) throws FileNotFoundException {
        int i = 0;
        try {
            File myObj = new File(inputFile);
            Scanner myReader = new Scanner(myObj);
            BufferedReader br = new BufferedReader(new FileReader(inputFile));

            while (myReader.hasNextLine()) {
                String temp = myReader.nextLine();

                //Char nemá equals?
                for (int k = 0; k < temp.length(); k++) {
                    if (temp.charAt(k) == SPACE_SEPARATOR) { //temp.charAt(k)
                        System.out.println(i);
                        i++;
                    }
                }


            }

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return i;


    }

    public static void readData() {

        try {
            System.out.println(" data try");
            File myObj = new File("../text.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = odstranMezery(myReader.nextLine());
                if (!data.isBlank()) {
                    System.out.println(data.isBlank());
                    writeData(data, "../text.txt", "output.txt");
                } else {
                    System.out.println("empty line");
                }

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void writeData(String data, String input, String output) {
        try {
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

    public static void writeData(String data, String output) {
        try {
            System.out.println("vytvtářím soubor");
            File newFile = new File(output);
            newFile.createNewFile();

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

    public static void realNumberToBinary(String outputFile) {
        System.out.println("Insert number to print into a file: ");
        //načtení z konzole
        Scanner in = new Scanner(System.in);
        long s = parseLong(in.nextLine());
        //převod do binárního čísla
        System.out.println("to binary" + s);
        String bin = Long.toBinaryString(s);
        //zápis do souboru
        System.out.println(bin + "bin");
        writeData(bin, outputFile);


    }
}
