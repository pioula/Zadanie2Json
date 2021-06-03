package program.argumenty.wyrazenieLogiczne.zeroargumentowe;

import Wyjatki.BladWykonania;
import program.Program;

public class True extends WyrazenieLogiczneZeroargumentowe {
    public True() {}

    @Override
    public double wykonaj(Program program) throws BladWykonania {
        return 1;
    }
}
