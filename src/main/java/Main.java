import javaBuilder.JavaBuilder;
import wyjatki.BladWykonania;
import wyjatki.NieprawidlowyProgram;
import robson.Robson;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.net.URLClassLoader;

public class Main {

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
            System.out.println("Blad out");
        }
    }

    public static void main(String[] args) throws NieprawidlowyProgram, BladWykonania {
        Robson robson = new Robson();

        int liczbaTestow = 13;

        for (int i = 1; i <= liczbaTestow; i++) {
            robson.fromJSON(i + "in.json");
            robson.toJSON(i + "out.json");
            robson.toJava("out" + i + ".java");
            createJsonOutput(robson, i);
        }
    }
}
