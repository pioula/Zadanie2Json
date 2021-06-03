package program;

import Wyjatki.BladWykonania;

public abstract class Wyrazenie {
    protected String typ;

    public String getTyp() {
        return typ;
    }

    public abstract double wykonaj(Program program) throws BladWykonania;

    //public abstract String toJava(Program program);
}
