package javaBuilder;

public class JavaBuilder {
    private int functionIndex;

    public JavaBuilder() {
        functionIndex = 0;
    }

    public String getNextFunctionName() {
        return "f" + functionIndex++;
    }

    public String createFunction(String functionName, String inside) {
        return "public double " + functionName + "() {\n" + inside + "}\n\n";
    }

    public String declare(String field) {
        return "static double " + field + " = 0.0;\n\n";
    }

    public String openClass() {
        return "public class Main {\n";
    }

    public String closeClass() {
        return "}";
    }

    public String createMain() {
        return "public static void main(String[] args) {\n System.out.println(f0());\n}\n";
    }
}
