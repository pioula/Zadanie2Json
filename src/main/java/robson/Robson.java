package robson;

import Wyjatki.BladWykonania;
import Wyjatki.NieprawidlowyProgram;
import json.JsonManager;
import program.Program;

import java.io.File;
import java.io.FilenameFilter;

public class Robson {
    private Program program;
    private JsonManager jsonManager;

    public void fromJSON(String filename) throws NieprawidlowyProgram {
        File f = new File("Json");
        File[] matchingFiles = f.listFiles((dir, name) -> name.equals(filename));

        if (matchingFiles == null || matchingFiles.length == 0) {
            System.out.println("Nie znaleziono pliku!");
            return;
        }

        if (matchingFiles.length > 1) {
            System.out.println("Znaleziono więcej niż 1 plik o tej samej nazwie!");
            return;
        }

        jsonManager = new JsonManager(matchingFiles[0]);
        this.program = new Program(jsonManager.getProgram());
    }

    public void toJSON(String filename) {
        File f = new File("Json");
        File[] matchingFiles = f.listFiles((dir, name) -> name.equals(filename));

        File json;

        if (matchingFiles == null || matchingFiles.length == 0) {
            json = new File(f.getPath() + "/"+ filename);
            try {
                if (!json.createNewFile())
                    throw new Exception();
            }
            catch(Exception ex) {
                System.out.println("Nie udało się znaleźć i stworzyć pliku json!");
                return;
            }
        }
        else {
            if (matchingFiles.length > 1) {
                System.out.println("Znaleziono więcej niż 1 plik o tej samej nazwie!");
                return;
            }
            json = matchingFiles[0];
        }
        jsonManager.writeToJson(json);
    }

    public void toJava(String filename) {
        File f = new File("Java");
        File[] matchingFiles = f.listFiles((dir, name) -> name.equals(filename));

        File java;

        if (matchingFiles == null || matchingFiles.length == 0) {
            java = new File(f.getPath() + "/"+ filename);
            try {
                if (!java.createNewFile())
                    throw new Exception();
            }
            catch(Exception ex) {
                System.out.println("Nie udało się znaleźć i stworzyć pliku java!");
                return;
            }
        }
        else {
            if (matchingFiles.length > 1) {
                System.out.println("Znaleziono więcej niż 1 plik o tej samej nazwie!");
                return;
            }
            java = matchingFiles[0];
        }

        program.toJava(java);
    }

    public double wykonaj() throws BladWykonania {
        if (jsonManager == null || program == null) {
            throw new BladWykonania();
        }

        return program.wykonaj();
    }
}
