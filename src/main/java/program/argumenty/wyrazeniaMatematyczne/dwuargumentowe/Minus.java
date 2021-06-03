package program.argumenty.wyrazeniaMatematyczne.dwuargumentowe;

import Wyjatki.BladWykonania;
import program.Program;

public class Minus extends WyrazenieMatematyczneDwuargumentowe {
    public Minus() {}

    @Override
    public double wykonaj(Program program) throws BladWykonania {
        return argument1.wykonaj(program) - argument2.wykonaj(program);
    }
}
