package program.argumenty.wyrazenieLogiczne.porownania;

import wyjatki.BladWykonania;
import program.Program;

public class WiekszeRowne extends Porownanie {
    public WiekszeRowne() {}

    @Override
    public double wykonaj(Program program) throws BladWykonania {
        return argument1.wykonaj(program) >= argument2.wykonaj(program) ? 1 : 0;
    }
}
