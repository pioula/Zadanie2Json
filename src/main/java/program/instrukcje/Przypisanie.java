package program.instrukcje;

import wyjatki.BladWykonania;
import javaBuilder.JavaBuilder;
import program.Program;
import program.Wyrazenie;

public class Przypisanie extends Instrukcja {
    private String nazwa;
    private Wyrazenie wartosc;
    public Przypisanie() {}

    @Override
    public double wykonaj(Program program) throws BladWykonania {
        double wartoscZmiennej = wartosc.wykonaj(program);
        program.updateVariable(nazwa, wartoscZmiennej);
        return wartoscZmiennej;
    }

    @Override
    public void toJava(Program javaProgram, JavaBuilder javaBuilder, String functionName) {
        StringBuilder javaPrzypisanie = new StringBuilder();

        if (!javaProgram.isDeclared(nazwa)) {
            javaProgram.getJavaProgram().append(javaBuilder.declare(nazwa));
            javaProgram.declareVariable(nazwa);
        }

        String wartoscName = javaBuilder.getNextFunctionName();
        javaPrzypisanie.append(nazwa).append(" = ").append(wartoscName).append("();\n");
        javaPrzypisanie.append("return ").append(nazwa).append(";\n");
        wartosc.toJava(javaProgram, javaBuilder, wartoscName);
        javaProgram.getJavaProgram().append(javaBuilder.createFunction(functionName, javaPrzypisanie.toString()));
    }
}
