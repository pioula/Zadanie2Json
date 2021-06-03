package program.argumenty.wyrazeniaMatematyczne.dwuargumentowe;

import Wyjatki.BladWykonania;
import program.Program;
import program.argumenty.wyrazeniaMatematyczne.WyrazenieMatematyczne;

public class Razy extends WyrazenieMatematyczneDwuargumentowe {
    public Razy() {}

    @Override
    public double wykonaj(Program program) throws BladWykonania {
        return argument1.wykonaj(program) * argument2.wykonaj(program);
    }
}
