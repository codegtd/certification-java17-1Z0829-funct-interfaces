package functionalinterfaces.function;

import java.util.function.Function;

public class ComposeExample {
  public static void main(String args[]) {

    final String title = "-->Final result from \"Function\": ";

    /*╔════════════════════╗
      ║  SIMPLE-FUNCTION   ║
      ╠════════════════════╣
      ║A) Exec 'compose'   ║
      ║B) Exec 'function1' ║
      ╚════════════════════╝*/
    Function<Integer, Integer> function1 = (composeResult) -> {
      final int ret = composeResult + 1;   show("Function: " + ret);
      return ret;      };

    function1 = function1.compose(function1Param -> {
      final int ret = 2 * function1Param; show("Before Function(compose): " + ret);
      return ret;      });

    show(title + function1.apply(1));
    //--------------------------------------------------------------------------
    /*╔══════════════════╗
      ║ CHAINED-FUNCTION ║
      ╚══════════════════╝*/
    Function<Integer, Integer> function2 = (composeResult) -> {
      return composeResult + 1;       };

    var result =
         function2
              .compose(function2Param -> {
                return (Integer)function2Param + 1;   })
              .apply(11);

    show("\nChained: " + title + result);
  }

  private static void show(String ret) {

    System.out.println(ret);
  }
}