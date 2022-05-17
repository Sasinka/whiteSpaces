import readFromFile.ReadFromFile;

import java.io.FileNotFoundException;

import static readFromFile.ReadFromFile.realNumberToBinary;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ReadFromFile.readData();
       // ReadFromFile.numberLines();
      //  System.out.println("soubor ../output.txt má " + ReadFromFile.numberOfWord("../output.txt"));
        realNumberToBinary("binarka.dat");
    }
}
