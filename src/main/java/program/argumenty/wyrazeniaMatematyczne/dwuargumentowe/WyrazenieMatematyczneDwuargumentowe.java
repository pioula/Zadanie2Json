package program.argumenty.wyrazeniaMatematyczne.dwuargumentowe;

import javaBuilder.JavaBuilder;
import program.Program;
import program.argumenty.wyrazeniaMatematyczne.WyrazenieMatematyczne;

public abstract class WyrazenieMatematyczneDwuargumentowe extends WyrazenieMatematyczne {
    protected WyrazenieMatematyczne argument1;
    protected WyrazenieMatematyczne argument2;

    @Override
    public void toJava(Program javaProgram, JavaBuilder javaBuilder, String functionName) {
        StringBuilder javaDwuArg = new StringBuilder();

        String argument1Name = javaBuilder.getNextFunctionName();
        argument1.toJava(javaProgram, javaBuilder, argument1Name);
        String argument2Name = javaBuilder.getNextFunctionName();
        argument2.toJava(javaProgram, javaBuilder, argument2Name);

        char operator = ' ';

        switch (typ) {
            case "Razy" -> operator = '*';
            case "Dzielenie" -> operator = '/';
            case "Plus" -> operator = '+';
            case "Minus" -> operator = '-';
        }

        javaDwuArg.append("return ").append(argument1Name).append("() ").append(operator).append(" ").append(argument2Name).append("();\n");

        javaProgram.getJavaProgram().append(javaBuilder.createFunction(functionName, javaDwuArg.toString()));
    }
}
