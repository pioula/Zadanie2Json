package program.argumenty.wyrazenieLogiczne.jednoargumentowe;

import Wyjatki.BladWykonania;
import javaBuilder.JavaBuilder;
import program.Program;

public class Not extends WyrazenieLogiczneJednoargumentowe {
    public Not() {}

    @Override
    public double wykonaj(Program program) throws BladWykonania {
        return argument.wykonaj(program) == 1 ? 1 : 0;
    }

    @Override
    public void toJava(Program javaProgram, JavaBuilder javaBuilder, String functionName) {
        StringBuilder javaNot = new StringBuilder();

        String argumentName = javaBuilder.getNextFunctionName();
        argument.toJava(javaProgram, javaBuilder, argumentName);

        javaNot.append("return ").append(argumentName).append("() == 1 ? 0 : 1;");

        javaProgram.getJavaProgram().append(javaBuilder.createFunction(functionName, javaNot.toString()));
    }
}
