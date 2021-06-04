package program.argumenty.wyrazeniaMatematyczne.jednoargumentowe;

import wyjatki.BladWykonania;
import javaBuilder.JavaBuilder;
import program.Program;

public class Zmienna extends WyrazenieMatematyczneJednoargumentowe {
    private String nazwa;

    @Override
    public double wykonaj(Program program) throws BladWykonania {
        return program.wartoscZmiennej(nazwa);
    }

    @Override
    public void toJava(Program javaProgram, JavaBuilder javaBuilder, String functionName) {
        StringBuilder javaZmienna = new StringBuilder();

        if (!javaProgram.isDeclared(nazwa)) {
            javaProgram.getJavaProgram().append(javaBuilder.declare(nazwa));
            javaProgram.declareField(nazwa);
        }

        javaZmienna.append("return ").append(nazwa).append(";\n");
        javaProgram.getJavaProgram().append(javaBuilder.createFunction(functionName, javaZmienna.toString()));
    }
}
