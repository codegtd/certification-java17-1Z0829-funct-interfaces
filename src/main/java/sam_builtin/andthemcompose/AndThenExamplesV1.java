package sam_builtin.andthemcompose;

import java.util.function.*;

public class AndThenExamplesV1 {
    public static void main(String[] args) {

        // Using andThen() and compose() with Function Interface
        System.out.println("----- Function andThen() and Compose() -----");
        // Declare a Function variable
        Function<String, String> function;

        // assign a lambda expression to function
        function = (s) -> {
            System.out.println("2. Doing the Main " + s);
            return s;
        };

        // invoke compose() on function?
        function.<String>compose((s) -> {
            System.out.println("1. Composing " + s);
            return s;
        });

        // invoke andThen() on function?
        function.andThen((s) -> {
            System.out.println("3. And Then " + s);
            return s;
        });

        function.apply("Test");

    }
}