import Wyjatki.BladWykonania;
import Wyjatki.NieprawidlowyProgram;
import json.JsonManager;
import robson.Robson;

import java.io.File;

public class Main {
    public static void main(String[] args) throws NieprawidlowyProgram, BladWykonania {
        Robson robson = new Robson();
        robson.fromJSON("fib.json");

        System.out.println(robson.wykonaj());
        robson.toJSON("plik.json");
        //JsonManager jsonManager = new JsonManager(new File("src/main/java/fib.json"));

        //jsonManager.wypisz();
    }
}
