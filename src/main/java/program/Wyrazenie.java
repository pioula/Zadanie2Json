package program;

import wyjatki.BladWykonania;
import javaBuilder.JavaBuilder;

public abstract class Wyrazenie {
    protected String typ;

    public String getTyp() {
        return typ;
    }

    public abstract double wykonaj(Program program) throws BladWykonania;

    public abstract void toJava(Program javaProgram, JavaBuilder javaBuilder, String functionName);
}
