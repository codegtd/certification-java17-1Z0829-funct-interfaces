package sam_builtin.function;

import java.util.function.BiFunction;

public class AddThenExample {
  public static void main(String args[]) {
    /*╔════════════════════╗
      ║ SIMPLE-BIFUNCTION  ║
      ╠════════════════════╣
      ║ A) Exec 'function1'║
      ║ B) Exec 'andThen'  ║
      ╚════════════════════╝*/
    BiFunction<Integer, Integer, Integer> function1 = (a, b) -> {
      show("Function: " + (a + b));
      return a + b;      };

    function1 = function1.andThen(function1Result -> {
      show("After Function(andThen): " + (2 * function1Result));
      return 2 * function1Result;      });
    show("Final result from \"Function\": " + function1.apply(2, 3));
    //--------------------------------------------------------------------------

    /*╔════════════════════╗
      ║ CHAINED-BIFUNCTION ║
      ╠════════════════════╣
      ║ A) Exec 'function1'║
      ║ B) Exec 'andThen'  ║
      ╚════════════════════╝*/
    BiFunction<Integer, Integer, Integer> function2 = (a, b) -> a + b;
    Integer result =
         function2
              .andThen(function2Result -> 2 * function2Result)
              .apply(1, 1);
    show("\nChained Style: " + result);
    //--------------------------------------------------------------------------

    /*╔═══════════════════════╗
      ║ EXCEPTION BIFUNCTION  ║
      ╚═══════════════════════╝*/
    BiFunction<Integer, Integer, Integer> beforeExc = (a, b) -> a + b;

    beforeExc = beforeExc.andThen(beforeExcResult -> beforeExcResult / (beforeExcResult - 5));

    try {
      show("\nException: Zero Division: " + beforeExc.apply(2, 3));
    }
    catch (Exception e) {
      show("\nException: " + e);
    }
    //--------------------------------------------------------------------------
  }

  private static void show(String text) {

    System.out.println(text);
  }
}