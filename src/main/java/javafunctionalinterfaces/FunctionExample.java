package javafunctionalinterfaces;

import java.util.List;
import java.util.function.Function;

public class FunctionExample {
  public static void main(String[] args) {

    Function<String, String> f1 = (s) -> s;
    Function<String, String> f2 = (s) -> s.split("\\s")[0];
    Function<
         List<Integer>, String> f3 = (s) -> s.subList(1, 3)
                                             .toString()
                                             .replace(',', ' ');

    System.out.println(f1.apply("hello"));
    System.out.println(f2.apply("hello there"));
    System.out.println(f3.apply(List.of(10, 20, 30, 40)));

    Function<List<Integer>, List<Integer>> pre =
         (s) -> {
           final List<Integer> x = s.subList(1, 3);
           System.out.println("\nPre: " + x);
           return x;
         };

    Function<List<Integer>, String> res =
         (s) -> {
           System.out.println("Result: " + "s.get(0)");
           return s.toString();
         };

    Function<String, String> pos =
         (s) -> {
           final String r = s.replace(',', ' ');
           System.out.println("Pos: " + r);
           return r;
         };

    final String function =
         res
              .compose(pre)
              .andThen(pos)
              .apply(List.of(1, 22, 3, 4));

    System.out.println("1) Compose; 2) Apply; 3) andThen; " + function);

    //    // Executing by chaining Function local variables...
    //    System.out.println("fResult.compose(fPre).andThen(fPost).apply = " +
    //                            result.andThen(pos).compose(pre).
    //                                   apply(List.of(10, 20, 30, 40, 50)));
    //
    //    // Executing by chaining lambda expressions - ugly but ok
    //    String newResult = (
    //         (Function<List<Integer>, String>) ((s) -> s.toString())).
    //         <List<Integer>>compose((s) -> s.subList(1, 4)).
    //         <String>andThen((s) -> s.replace(',', ' '))
    //         .apply(List.of(10, 20, 30, 40, 50));
    //
    //    System.out.println("Chaining it all together: " + newResult);
  }
}