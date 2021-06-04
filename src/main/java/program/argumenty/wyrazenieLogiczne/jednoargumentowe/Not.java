package program.argumenty.wyrazenieLogiczne.jednoargumentowe;

import wyjatki.BladWykonania;
import javaBuilder.JavaBuilder;
import program.Program;

public class Not extends WyrazenieLogiczneJednoargumentowe {
    public Not() {}

    @Override
    public double wykonaj(Program program) throws BladWykonania {
        double val1 = argument.wykonaj(program);
        if (val1 != 0 && val1 != 1)
            throw new BladWykonania();

        return val1 == 1 ? 0 : 1;
    }

    @Override
    public void toJava(Program javaProgram, JavaBuilder javaBuilder, String functionName) {
        StringBuilder javaNot = new StringBuilder();

        String argumentName = javaBuilder.getNextFunctionName();
        argument.toJava(javaProgram, javaBuilder, argumentName);

        javaNot.append("return ").append(argumentName).append("() == 1 ? 0 : 1;\n");

        javaProgram.getJavaProgram().append(javaBuilder.createFunction(functionName, javaNot.toString()));
    }
}
