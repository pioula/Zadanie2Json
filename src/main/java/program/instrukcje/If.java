package program.instrukcje;

import wyjatki.BladWykonania;
import javaBuilder.JavaBuilder;
import program.Program;
import program.Wyrazenie;

public class If extends Instrukcja {
    private Wyrazenie warunek;
    private Wyrazenie blok_prawda;
    private Wyrazenie blok_falsz;

    @Override
    public double wykonaj(Program program) throws BladWykonania {
        if (warunek.wykonaj(program) != 0) {
            return blok_prawda.wykonaj(program);
        }
        else if (blok_falsz != null){
            return blok_falsz.wykonaj(program);
        }
        else {
            return 0;
        }
    }

    @Override
    public void toJava(Program javaProgram, JavaBuilder javaBuilder, String functionName) {
        StringBuilder javaIf = new StringBuilder();

        String warunekName = javaBuilder.getNextFunctionName();
        javaIf.append("if (").append(warunekName).append("() != 0) {\n");
        warunek.toJava(javaProgram, javaBuilder, warunekName);

        String blok_prawdaName = javaBuilder.getNextFunctionName();
        javaIf.append("return ").append(blok_prawdaName).append("();\n}\n");
        blok_prawda.toJava(javaProgram, javaBuilder, blok_prawdaName);

        if (blok_falsz != null) {
            String blok_falszName = javaBuilder.getNextFunctionName();
            javaIf.append("else {\n").append("return ").append(blok_falszName).append("();\n}\n");
            blok_falsz.toJava(javaProgram, javaBuilder, blok_falszName);
        }
        else {
            javaIf.append("return 0;\n");
        }

        javaProgram.getJavaProgram().append(javaBuilder.createFunction(functionName, javaIf.toString()));
    }
}
