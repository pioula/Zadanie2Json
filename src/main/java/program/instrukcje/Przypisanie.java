package program.instrukcje;

import Wyjatki.BladWykonania;
import program.Program;
import program.argumenty.wyrazeniaMatematyczne.WyrazenieMatematyczne;

public class Przypisanie extends Instrukcja {
    private String nazwa;
    private WyrazenieMatematyczne wartosc;
    public Przypisanie() {}

    @Override
    public double wykonaj(Program program) throws BladWykonania {
        double wartoscZmiennej = wartosc.wykonaj(program);
        program.zaktualizujZmienna(nazwa, wartoscZmiennej);
        return wartoscZmiennej;
    }
}
