package program.argumenty.wyrazenieLogiczne.porownania;

import Wyjatki.BladWykonania;
import program.Program;

public class MniejszeRowne extends Porownanie {
    public MniejszeRowne() {}

    @Override
    public double wykonaj(Program program) throws BladWykonania {
        return argument1.wykonaj(program) <= argument2.wykonaj(program) ? 1 : 0;
    }
}
