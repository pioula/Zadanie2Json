package program.instrukcje;

import wyjatki.BladWykonania;
import javaBuilder.JavaBuilder;
import program.Program;
import program.Wyrazenie;

public class While extends Instrukcja {
    private Wyrazenie warunek;
    private Wyrazenie blok;

    public While() {}

    @Override
    public double wykonaj(Program program) throws BladWykonania {

        while(warunek.wykonaj(program) != 0) {
            blok.wykonaj(program);
        }
        return 0;
    }

    @Override
    public void toJava(Program javaProgram, JavaBuilder javaBuilder, String functionName) {
        StringBuilder javaWhile = new StringBuilder();

        String warunekName = javaBuilder.getNextFunctionName();
        javaWhile.append("while (").append(warunekName).append("() != 0) {\n");
        warunek.toJava(javaProgram, javaBuilder, warunekName);

        String blokName = javaBuilder.getNextFunctionName();
        javaWhile.append(blokName).append("();\n}\n");
        blok.toJava(javaProgram, javaBuilder, blokName);

        javaWhile.append("return 0;\n");

        javaProgram.getJavaProgram().append(javaBuilder.createFunction(functionName, javaWhile.toString()));
    }
}
