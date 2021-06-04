package robson;

import wyjatki.BladWykonania;
import wyjatki.CreateFile;
import wyjatki.ManyFiles;
import wyjatki.NieprawidlowyProgram;
import json.JsonManager;
import program.Program;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Robson {
    private Program program;
    private JsonManager jsonManager;

    /*
    * fromJSON, przyjmuje nazwę pliku json wraz z rozszerzeniem znajdującym się w folderze
    * Zadanie2Json/Json i konwertuje jego zawartość na Program */
    public void fromJSON(String filename) throws NieprawidlowyProgram, FileNotFoundException, ManyFiles {
        File f = new File("Json");
        File[] matchingFiles = f.listFiles((dir, name) -> name.equals(filename));

        if (matchingFiles == null || matchingFiles.length == 0) {
            throw new FileNotFoundException("input JSON not found!");
        }

        if (matchingFiles.length > 1) {
            throw new ManyFiles("There are more than one file with this name!");
        }

        jsonManager = new JsonManager(matchingFiles[0]);
        this.program = new Program(jsonManager.getProgram());
    }

    /*
    * toJSON przyjmuje nazwę pliku wraz z rozszerzeniem. Jeżeli w folderze Zadanie2Json/Json znajduje się już plik
    * o takiej nazwie to zapisuje w nim swój wynik. Jeżeli nie istnieje, to próbuje stworzyć plik i zapisać tam
    * swój wynik. Wynikiem jest przekonwertowany Program na format JSON*/
    public void toJSON(String filename) throws CreateFile, ManyFiles {
        File f = new File("Json");
        File[] matchingFiles = f.listFiles((dir, name) -> name.equals(filename));

        File json;

        if (matchingFiles == null || matchingFiles.length == 0) {
            json = new File(f.getPath() + "/"+ filename);
            try {
            if (!json.createNewFile())
                    throw new CreateFile("Couldn't create new JSON file! Check is there is Json folder in Zadanie2Json!");
            }
            catch(IOException exp) {
                throw new CreateFile("Couldn't create new JSON file! Check is there is Json folder in Zadanie2Json!");
            }
        }
        else {
            if (matchingFiles.length > 1) {
                throw new ManyFiles("There are more than one file with this name!");
            }

            json = matchingFiles[0];
        }
        jsonManager.writeToJson(json);
    }

    /*
    * toJava przyjmuje nazwę pliku wraz z rozszerzeniem. Jeżeli w folderze Zadanie2Json/Java znajduje się już plik
     * o takiej nazwie to zapisuje w nim swój wynik. Jeżeli nie istnieje, to próbuje stworzyć plik i zapisać tam
     * swój wynik. Wynikiem jest przekonwertowany Program na kompilowalny kod w Javie  */
    public void toJava(String filename) throws CreateFile, ManyFiles {
        File f = new File("Java");
        File[] matchingFiles = f.listFiles((dir, name) -> name.equals(filename));

        File java;

        if (matchingFiles == null || matchingFiles.length == 0) {
            java = new File(f.getPath() + "/"+ filename);
            try {
                if (!java.createNewFile())
                    throw new CreateFile("Couldn't create new Java file! Check is there is Java folder in Zadanie2Json!");
            }
            catch(IOException | CreateFile exp) {
                throw new CreateFile("Couldn't create new Java file! Check is there is Java folder in Zadanie2Json!");
            }
        }
        else {
            if (matchingFiles.length > 1) {
                throw new ManyFiles("There are more than one file with this name!");
            }
            java = matchingFiles[0];
        }

        program.toJava(java, filename);
    }

    public double wykonaj() throws BladWykonania {
        if (jsonManager == null || program == null) {
            throw new BladWykonania();
        }

        return program.wykonaj();
    }
}
