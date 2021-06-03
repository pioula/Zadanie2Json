package program.argumenty.wyrazenieLogiczne.dwuargumentowe;


import Wyjatki.BladWykonania;
import program.Program;

public class And extends WyrazenieLogiczneDwuargumentowe {
    public And() {}

    @Override
    public double wykonaj(Program program) throws BladWykonania {
        return argument1.wykonaj(program) == 1 && argument2.wykonaj(program) == 1 ? 1 : 0;
    }
}
