package program.argumenty.wyrazeniaMatematyczne.dwuargumentowe;

import Wyjatki.BladWykonania;
import program.Program;

public class Dzielenie extends WyrazenieMatematyczneDwuargumentowe {
    public Dzielenie() {}

    @Override
    public double wykonaj(Program program) throws BladWykonania {
        double wartoscArgumentu2 = argument2.wykonaj(program);
        if (wartoscArgumentu2 == 0)
            throw new BladWykonania();
        return argument1.wykonaj(program) / argument2.wykonaj(program);
    }
}
