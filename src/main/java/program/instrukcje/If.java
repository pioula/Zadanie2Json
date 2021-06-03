package program.instrukcje;

import Wyjatki.BladWykonania;
import program.Program;
import program.Wyrazenie;
import program.argumenty.wyrazenieLogiczne.WyrazenieLogiczne;

public class If extends Instrukcja {
    private WyrazenieLogiczne warunek;
    private Wyrazenie blok_prawda;
    private Wyrazenie blok_falsz;

    @Override
    public double wykonaj(Program program) throws BladWykonania {
        if (warunek.wykonaj(program) == 1)
            return blok_prawda.wykonaj(program);
        else
            return blok_falsz.wykonaj(program);
    }
}
