package program;

import wyjatki.BladWykonania;
import javaBuilder.JavaBuilder;
import wyjatki.CreateFile;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Program {
    private Wyrazenie code;
    private Map<String, Double> variables;
    private Set<String> declaredVariables;
    private StringBuilder javaProgram;
    public Program(Wyrazenie code) {
        this.code = code;
        variables = new HashMap<>();
        declaredVariables = new TreeSet<>();
        javaProgram = new StringBuilder();
    }

    public double wykonaj() throws BladWykonania {
       return code.wykonaj(this);
    }

    public void updateVariable(String nazwa, double wartosc) {
        variables.put(nazwa, wartosc);
    }

    public double variableValue(String nazwa) {
        if (variables.containsKey(nazwa)) {
            return variables.get(nazwa);
        }
       else {// wszystkie zmienne są globalne, początkowo zadeklarowane na 0
            variables.put(nazwa, 0.0);
            return 0;
        }
    }

    public boolean isDeclared(String nazwa) {
        return declaredVariables.contains(nazwa);
    }

    public void declareVariable(String nazwa) {
        declaredVariables.add(nazwa);
    }

    public StringBuilder getJavaProgram() {
        return javaProgram;
    }

    public void toJava(File f, String mainClassName) throws CreateFile {
        FileWriter writer;
        try {
            writer = new FileWriter(f);

            JavaBuilder javaBuilder = new JavaBuilder();

            javaProgram.append(javaBuilder.openClass(mainClassName));
            code.toJava(this, javaBuilder, javaBuilder.getNextFunctionName());
            javaProgram.append(javaBuilder.createMain());
            javaProgram.append(javaBuilder.closeClass());

            writer.write(javaProgram.toString());

            javaProgram = null;
            declaredVariables = null;
            writer.close();
        }
        catch(Exception ex) {
            throw new CreateFile("Couldn't open created java file!");
        }
    }
}
