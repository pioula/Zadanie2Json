package program.instrukcje;

import Wyjatki.BladWykonania;
import program.Program;
import program.argumenty.wyrazenieLogiczne.WyrazenieLogiczne;

public class While extends Instrukcja {
    private WyrazenieLogiczne warunek;
    private Blok blok;

    public While() {}

    @Override
    public double wykonaj(Program program) throws BladWykonania {
        while(warunek.wykonaj(program) == 1) {
            blok.wykonaj(program);
        }
        return 0;
    }
}
