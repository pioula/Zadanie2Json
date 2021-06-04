package program.argumenty.wyrazenieLogiczne.porownania;

import wyjatki.BladWykonania;
import program.Program;

public class Rowne extends Porownanie {
    public Rowne() {}

    @Override
    public double wykonaj(Program program) throws BladWykonania {
        return argument1.wykonaj(program) == argument2.wykonaj(program) ? 1 : 0;

    }
}
