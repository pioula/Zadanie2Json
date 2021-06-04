package program.argumenty.wyrazenieLogiczne.zeroargumentowe;

import javaBuilder.JavaBuilder;
import program.Program;
import program.argumenty.wyrazenieLogiczne.WyrazenieLogiczne;

public abstract class WyrazenieLogiczneZeroargumentowe extends WyrazenieLogiczne {
    @Override
    public void toJava(Program javaProgram, JavaBuilder javaBuilder, String functionName) {
        StringBuilder javaZeroArg = new StringBuilder();

        char value = ' ';

        switch (typ) {
            case "True" -> value = '1';
            case "False" -> value = '0';
        }

        javaZeroArg.append("return ").append(value).append(";\n");

        javaProgram.getJavaProgram().append(javaBuilder.createFunction(functionName, javaZeroArg.toString()));
    }
}
