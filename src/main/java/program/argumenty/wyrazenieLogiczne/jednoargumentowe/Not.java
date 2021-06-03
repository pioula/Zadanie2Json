package program.argumenty.wyrazenieLogiczne.jednoargumentowe;

import Wyjatki.BladWykonania;
import program.Program;

public class Not extends WyrazenieLogiczneJednoargumentowe {
    public Not() {}

    @Override
    public double wykonaj(Program program) throws BladWykonania {
        return argument.wykonaj(program) == 1 ? 1 : 0;
    }
}
