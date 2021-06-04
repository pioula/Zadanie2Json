import wyjatki.BladWykonania;
import wyjatki.CreateFile;
import wyjatki.ManyFiles;
import wyjatki.NieprawidlowyProgram;
import robson.Robson;

import java.io.FileNotFoundException;

public class Testerka {
    /*
    Reguły kompilacji są opisane w pliku Zadanie2Json/target/pom.xml
    * */
    public static void main(String[] args) throws NieprawidlowyProgram, BladWykonania, FileNotFoundException,
            ManyFiles, CreateFile {
        Robson robson = new Robson();

        robson.fromJSON("1in.json");
        if (robson.wykonaj() == 0.0)
            System.out.println("POPRAWNY WYNIK!");
        else
            System.out.println("ZŁY WYNIK!");
    }
}
