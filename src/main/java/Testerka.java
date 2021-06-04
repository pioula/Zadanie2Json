import wyjatki.BladWykonania;
import wyjatki.CreateFile;
import wyjatki.ManyFiles;
import wyjatki.NieprawidlowyProgram;
import robson.Robson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;

public class Testerka {

    private static void createJsonOutput(Robson robson, int i) {
        FileWriter writer;
        try {
            String filename = i + "json.out";
            File f = new File("out");
            File[] matchingFiles = f.listFiles((dir, name) -> name.equals(filename));

            File output;

            if (matchingFiles == null || matchingFiles.length == 0) {
                output = new File(f.getPath() + "/"+ filename);
                try {
                    if (!output.createNewFile())
                        throw new Exception();
                }
                catch(Exception ex) {
                    System.out.println("Nie udało się znaleźć i stworzyć pliku outjson!");
                    return;
                }
            }
            else {
                if (matchingFiles.length > 1) {
                    System.out.println("Znaleziono więcej niż 1 plik o tej samej nazwie outjson!");
                    return;
                }
                output = matchingFiles[0];
            }

            writer = new FileWriter(output);

            writer.write(String.valueOf(robson.wykonaj()));
            writer.close();
        }
        catch(Exception ex) {
            if (ex instanceof BladWykonania) {
                System.out.println("Blad wykonania!");
            }
            else {
                System.out.println("Blad out");
            }
        }
    }

    public static void main(String[] args) throws NieprawidlowyProgram, BladWykonania, FileNotFoundException,
            ManyFiles, CreateFile {
        Robson robson = new Robson();

        final int liczbaTestow = 18;

        for (int i = 0; i <= liczbaTestow; i++) {
            robson.fromJSON(i + "in.json");
            robson.toJSON(i + "out.json");
            robson.toJava("out" + i + ".java");
            createJsonOutput(robson, i);
        }
    }
}
