package program;

import wyjatki.BladWykonania;
import javaBuilder.JavaBuilder;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Program {
    private Wyrazenie kod;
    private Map<String, Double> zmienne;
    private Set<String> declaredFields;
    private StringBuilder javaProgram;
    public Program(Wyrazenie kod) {
        this.kod = kod;
        zmienne = new HashMap<>();
        declaredFields = new TreeSet<>();
        javaProgram = new StringBuilder();
    }

    public double wykonaj() throws BladWykonania {
       return kod.wykonaj(this);
    }

    public void zaktualizujZmienna(String nazwa, double wartosc) {
        zmienne.put(nazwa, wartosc);
    }

    public double wartoscZmiennej(String nazwa) {
        if (zmienne.containsKey(nazwa)) {
            return zmienne.get(nazwa);
        }
       else {// wszystkie zmienne są globalne, początkowo zadeklarowane na 0
            zmienne.put(nazwa, 0.0);
            return 0;
        }
    }

    public boolean isDeclared(String nazwa) {
        return declaredFields.contains(nazwa);
    }

    public void declareField(String nazwa) {
        declaredFields.add(nazwa);
    }

    public StringBuilder getJavaProgram() {
        return javaProgram;
    }

    public void toJava(File f, String mainClassName) {
        FileWriter writer;
        try {
            writer = new FileWriter(f);

            JavaBuilder javaBuilder = new JavaBuilder();

            javaProgram.append(javaBuilder.openClass(mainClassName));
            kod.toJava(this, javaBuilder, javaBuilder.getNextFunctionName());
            javaProgram.append(javaBuilder.createMain());
            javaProgram.append(javaBuilder.closeClass());

            writer.write(javaProgram.toString());

            javaProgram = null;
            declaredFields = null;
            writer.close();
        }
        catch(Exception ex) {
            System.out.println("Nie udalo sie stworzyc pliku java!");
        }
    }
}
