package program.instrukcje;

import Wyjatki.BladWykonania;
import program.Program;
import program.Wyrazenie;

import java.util.Collection;

public class Blok extends Instrukcja {
    private Collection<Wyrazenie> instrukcje;

    public Blok() {}

    @Override
    public double wykonaj(Program program) throws BladWykonania {
        double wynik = 0;
        for (Wyrazenie komponent : instrukcje) {
            wynik = komponent.wykonaj(program);
        }

        return wynik;
    }

    /*@Override
    public String toJava(Program program) {
        return null;
    }*/
}
