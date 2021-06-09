import wyjatki.BladWykonania;
import wyjatki.CreateFile;
import wyjatki.ManyFiles;
import wyjatki.NieprawidlowyProgram;
import robson.Robson;

import java.io.FileNotFoundException;

public class Testerka {
    /*
    Reguły kompilacji są opisane w pliku Zadanie2Json/target/pom.xml
    Konwencje wypisywania i wczytywania jsona oraz exportu programu do javy są opisane w klasie Robson.
    Przyjmuję, że wszystko jest wyrażeniem (dozwolone jest while(if(while(1))))
    0 - fałsz
    co kolwiek innego - prawda
    * */
    public static void main(String[] args) throws NieprawidlowyProgram, BladWykonania, FileNotFoundException,
            ManyFiles, CreateFile {
        Robson robson = new Robson();

        robson.fromJSON("fib.json");
        if (robson.wykonaj() == 55.0)
            System.out.println("POPRAWNY WYNIK!");
        else
            System.out.println("ZŁY WYNIK!");
    }
}
