package program.instrukcje;

import Wyjatki.BladWykonania;
import javaBuilder.JavaBuilder;
import program.Program;
import program.Wyrazenie;

import java.util.ArrayList;

public class Blok extends Instrukcja {
    private ArrayList<Wyrazenie> instrukcje;

    public Blok() {}

    @Override
    public double wykonaj(Program program) throws BladWykonania {
        double wynik = 0;
        for (Wyrazenie komponent : instrukcje) {
            wynik = komponent.wykonaj(program);
        }

        return wynik;
    }

    @Override
    public void toJava(Program javaProgram, JavaBuilder javaBuilder, String functionName) {
        StringBuilder javaBlok = new StringBuilder();

        if (instrukcje.size() == 0) {
            javaBlok.append("return 0;\n");
        }
        else {
            for (int i = 0; i <  instrukcje.size(); i++) {
                String wyrazenieName = javaBuilder.getNextFunctionName();

                if (i + 1 == instrukcje.size())
                    javaBlok.append("return ").append(wyrazenieName).append("();\n");
                else
                    javaBlok.append(wyrazenieName).append("();\n");

                instrukcje.get(i).toJava(javaProgram, javaBuilder, wyrazenieName);
            }
        }

        javaProgram.getJavaProgram().append(javaBuilder.createFunction(functionName, javaBlok.toString()));
    }
}
