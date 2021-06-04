package program.argumenty.wyrazenieLogiczne.zeroargumentowe;

import wyjatki.BladWykonania;
import program.Program;

public class True extends WyrazenieLogiczneZeroargumentowe {
    public True() {}

    @Override
    public double wykonaj(Program program) throws BladWykonania {
        return 1;
    }
}
