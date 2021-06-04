package program.argumenty.wyrazenieLogiczne.dwuargumentowe;

import wyjatki.BladWykonania;
import javaBuilder.JavaBuilder;
import program.Program;

public class Or extends WyrazenieLogiczneDwuargumentowe {
    public Or() {}

    @Override
    public double wykonaj(Program program) throws BladWykonania {
        double val1 = argument1.wykonaj(program);
        double val2 = argument2.wykonaj(program);
        if ((val1 != 0 && val1 != 1) || (val2 != 0 && val2 != 1))
            throw new BladWykonania();

        return val1 == 1 || val2 == 1 ? 1 : 0;
    }

    @Override
    public void toJava(Program javaProgram, JavaBuilder javaBuilder, String functionName) {
        StringBuilder javaOr = new StringBuilder();

        String argument1Name = javaBuilder.getNextFunctionName();
        argument1.toJava(javaProgram, javaBuilder, argument1Name);
        String argument2Name = javaBuilder.getNextFunctionName();
        argument2.toJava(javaProgram, javaBuilder, argument2Name);

        javaOr.append("return ").append(argument1Name).append("() == 1 || ").append(argument2Name).append("() == 1 ? 1 : 0;\n");

        javaProgram.getJavaProgram().append(javaBuilder.createFunction(functionName, javaOr.toString()));
    }
}
