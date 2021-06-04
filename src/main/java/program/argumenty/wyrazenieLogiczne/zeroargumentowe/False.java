package program.argumenty.wyrazenieLogiczne.zeroargumentowe;

import wyjatki.BladWykonania;
import program.Program;

public class False extends WyrazenieLogiczneZeroargumentowe {
    public False() {}

    @Override
    public double wykonaj(Program program) throws BladWykonania {
        return 0;
    }
}
