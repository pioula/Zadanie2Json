package program.argumenty.wyrazeniaMatematyczne.jednoargumentowe;

import Wyjatki.BladWykonania;
import program.Program;

public class Zmienna extends WyrazenieMatematyczneJednoargumentowe {
    private String nazwa;

    @Override
    public double wykonaj(Program program) throws BladWykonania {
        return program.wartoscZmiennej(nazwa);
    }
}
