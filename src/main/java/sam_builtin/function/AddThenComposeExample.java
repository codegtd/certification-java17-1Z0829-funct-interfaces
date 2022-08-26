package sam_builtin.function;

import java.util.List;
import java.util.function.Function;

public class AddThenComposeExample {
  public static void main(String args[]) {

    /*╔════════════════════╗
      ║  SIMPLE-FUNCTION   ║
      ╠════════════════════╣
      ║ A) Exec 'compose'  ║
      ║ B) Exec 'func1' ║
      ╚════════════════════╝*/
    Function<Integer, Integer> func1 = (composeResult) -> {
      final int ret = composeResult + 1;
      show("Func1: " + ret);
      return ret;
    };

    func1 = func1.compose(functionParam -> {
      final int ret = 2 * functionParam;
      show("Before Func1(compose):" + ret);
      return ret;
    });

    func1 = func1.andThen(functionResult -> {
      final int ret = 2 + functionResult;
      show("After Func1(andThen): " + ret);
      return ret;
    });

    show("-->Final result from \"Function\": " + func1.apply(10));

    //--------------------------------------------------------------------------

    /*╔═════════════════════════╗
      ║ CHAINED-FUNCTION-SIMPLE ║
      ╚═════════════════════════╝*/
    Function<Integer, Integer> func = (composeResult) -> {
      final int ret = composeResult + 1;
      show("Func: " + ret);
      return ret;
    };

    var result =
         func
              .compose(funcParam -> {
                int ret = (Integer) funcParam + 1;
                show("\nBefore Func(compose):" + ret);
                return ret;
              })
              .andThen(funcResult -> {
                int ret = 2 + funcResult;
                show("After Func(andThen): " + ret);
                return ret;
              })
              .apply(1);

    show("-->Chained Simple: " + + result + "\n");
    //--------------------------------------------------------------------------

    /*╔═══════════════════════════╗
      ║ CHAINED-FUNCTION-ADVANCED ║
      ╚═══════════════════════════╝*/

    Function<List<Integer>, List<Integer>> pre =
         (funcParam) -> {
           show("pre: take(funcParam): " + funcParam);
           return funcParam.subList(1, 4);
         };

    Function<List<Integer>, String> func3 =
         (composeResult) -> {
           show("func3: take(composeResult): " + composeResult);
           return composeResult.toString();
         };

    Function<String, String> post =
         (funcResult) -> {
           show("post: take(funcResult): " + funcResult);
           return funcResult.replace(',', ' ');
         };

    show("-->Chained Variables: " +
              func3
                   .andThen(post)
                   .compose(pre)
                   .apply(List.of(10, 20, 30, 40, 50)));
    //--------------------------------------------------------------------------

    /*╔═══════════════════════╗
      ║ CHAINED-FUNCTION-UGLY ║
      ╚═══════════════════════╝*/
    String newResult =
     ((Function<List<Integer>, String>) ((composeResult) -> composeResult.toString()))
     .<List<Integer>>compose((funcParam) -> funcParam.subList(1, 4))
     .<String>andThen((funcResult) -> funcResult.replace(',', ' '))
     .apply(List.of(10, 20, 30, 40, 50));

    show("-->Chained Ugly: " + newResult);

  }

  private static void show(String ret) {

    System.out.println(ret);
  }
}