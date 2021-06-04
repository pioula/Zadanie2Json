package program.argumenty.wyrazeniaMatematyczne.jednoargumentowe;

import Wyjatki.BladWykonania;
import javaBuilder.JavaBuilder;
import program.Program;

public class Liczba extends WyrazenieMatematyczneJednoargumentowe {
    private double wartosc;

    public Liczba() {}

    public double getWartosc() {
        return wartosc;
    }

    @Override
    public double wykonaj(Program program) throws BladWykonania {
        return wartosc;
    }

    @Override
    public void toJava(Program javaProgram, JavaBuilder javaBuilder, String functionName) {
        javaProgram.getJavaProgram().append(javaBuilder.createFunction(functionName, "return " + wartosc + ";\n"));
    }
}
