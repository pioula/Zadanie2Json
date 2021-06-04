package program.argumenty.wyrazenieLogiczne.dwuargumentowe;

import javaBuilder.JavaBuilder;
import program.Program;
import program.Wyrazenie;
import program.argumenty.wyrazenieLogiczne.WyrazenieLogiczne;

public abstract class WyrazenieLogiczneDwuargumentowe extends WyrazenieLogiczne {
    protected Wyrazenie argument1;
    protected Wyrazenie argument2;

    @Override
    public void toJava(Program javaProgram, JavaBuilder javaBuilder, String functionName) {
        StringBuilder javaDwuArg = new StringBuilder();

        String argument1Name = javaBuilder.getNextFunctionName();
        argument1.toJava(javaProgram, javaBuilder, argument1Name);
        String argument2Name = javaBuilder.getNextFunctionName();
        argument2.toJava(javaProgram, javaBuilder, argument2Name);

        String operator = "";

        switch (typ) {
            case "Or" -> operator = "||";
            case "And" -> operator = "&&";
        }

        javaDwuArg.append("return ").append(argument1Name).append("() == 1 ").append(operator).append(" ").append(argument2Name).append("() == 1 ? 1 : 0;\n");

        javaProgram.getJavaProgram().append(javaBuilder.createFunction(functionName, javaDwuArg.toString()));
    }
}
