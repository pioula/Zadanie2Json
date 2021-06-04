package program.instrukcje;

import wyjatki.BladWykonania;
import javaBuilder.JavaBuilder;
import program.Program;
import program.Wyrazenie;

public class While extends Instrukcja {
    private Wyrazenie warunek;
    private Wyrazenie blok;

    public While() {}

    /*przyjmujemy, że prawda jest 1, fałsz jest 0, a wszystko co nie jest 1, lub 0 jest błędem.
    Stąd while zwraca zawsze fałsz(bo zwraca 0).
     */

    private boolean check(double val) throws BladWykonania {
        if (val == 1)
            return true;
        else if (val == 0)
            return false;
        else
            throw new BladWykonania();
    }

    @Override
    public double wykonaj(Program program) throws BladWykonania {

        while(check(warunek.wykonaj(program))) {
            blok.wykonaj(program);
        }
        return 0;
    }

    @Override
    public void toJava(Program javaProgram, JavaBuilder javaBuilder, String functionName) {
        StringBuilder javaWhile = new StringBuilder();

        String warunekName = javaBuilder.getNextFunctionName();
        javaWhile.append("while (").append(warunekName).append("() == 1) {\n");
        warunek.toJava(javaProgram, javaBuilder, warunekName);

        String blokName = javaBuilder.getNextFunctionName();
        javaWhile.append(blokName).append("();\n}\n");
        blok.toJava(javaProgram, javaBuilder, blokName);

        javaWhile.append("return 0;\n");

        javaProgram.getJavaProgram().append(javaBuilder.createFunction(functionName, javaWhile.toString()));
    }
}
