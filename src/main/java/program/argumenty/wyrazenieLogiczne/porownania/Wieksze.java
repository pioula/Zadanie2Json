package program.argumenty.wyrazenieLogiczne.porownania;

import wyjatki.BladWykonania;
import program.Program;
import program.argumenty.wyrazenieLogiczne.WyrazenieLogiczne;
import program.argumenty.wyrazenieLogiczne.dwuargumentowe.WyrazenieLogiczneDwuargumentowe;

public class Wieksze extends Porownanie {
    public Wieksze() {}

    @Override
    public double wykonaj(Program program) throws BladWykonania {
        return argument1.wykonaj(program) > argument2.wykonaj(program) ? 1 : 0;

    }
}
