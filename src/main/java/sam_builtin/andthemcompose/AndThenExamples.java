package sam_builtin.andthemcompose;

import java.util.function.*;

public class AndThenExamples {
  public static void main(String[] args) {
    Function<String, String> function;

    function = (s) -> {
      System.out.println("\nFunction " + s);
      return "";      };

         function
              .compose(s -> {
                System.out.println("\n\t2) COMPOSE");
                return s.toString();})
              .compose(s -> {
                System.out.println("\n\t1) COMPOSE");
                return s.toString();})
              .andThen(s -> {
                System.out.println("\n\t1) AndThen");
                return s.toString();})
              .andThen(s -> {
                System.out.println("\n\t2) AndThen");
                return s.toString();              })
              .apply(" - Applying: ");
  }
}