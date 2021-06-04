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
        return "public static double " + functionName + "() {\n" + inside + "}\n\n";
    }

    public String declare(String field) {
        return "static double " + field + " = 0.0;\n\n";
    }

    public String openClass(String mainClassName) {
        StringBuilder className = new StringBuilder();
        for (int i = 0; i < mainClassName.length(); i++) {
            if (mainClassName.charAt(i) != '.')
                className.append(mainClassName.charAt(i));
            else
                break;
        }
        return "public class " + className + " {\n";
    }

    public String closeClass() {
        return "}";
    }

    public String createMain() {
        return "public static void main(String[] args) {\n System.out.println(f0());\n}\n";
    }
}
