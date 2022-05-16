import readFromFile.ReadFromFile;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        //ReadFromFile.nactiData();
       // ReadFromFile.numberLines();
        System.out.println("soubor ../text.txt má " + ReadFromFile.numberOfWord("../text.txt"));

    }
}
