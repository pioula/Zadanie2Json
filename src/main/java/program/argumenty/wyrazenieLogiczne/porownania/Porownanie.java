package program.argumenty.wyrazenieLogiczne.porownania;

import javaBuilder.JavaBuilder;
import program.Program;
import program.Wyrazenie;
import program.argumenty.wyrazenieLogiczne.WyrazenieLogiczne;

public abstract class Porownanie extends WyrazenieLogiczne {
    protected Wyrazenie argument1;
    protected Wyrazenie argument2;

    @Override
    public void toJava(Program javaProgram, JavaBuilder javaBuilder, String functionName) {
        StringBuilder javaPorownanie = new StringBuilder();

        String argument1Name = javaBuilder.getNextFunctionName();
        argument1.toJava(javaProgram, javaBuilder, argument1Name);
        String argument2Name = javaBuilder.getNextFunctionName();
        argument2.toJava(javaProgram, javaBuilder, argument2Name);

        javaPorownanie.append("return ").append(argument1Name).append("() ").append(typ).append(" ").append(argument2Name).append("() ? 1 : 0;\n");

        javaProgram.getJavaProgram().append(javaBuilder.createFunction(functionName, javaPorownanie.toString()));
    }
}
