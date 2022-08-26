package sam_builtin.function;

import java.util.List;
import java.util.function.Function;

public class FunctionBasicsExample {
  public static void main(String[] args) {

    Function<String, String> f1 = (s) -> s;
    final String hello = f1.apply("hello");

    Function<String, String> f2 = (s) -> s.split("\\s")[0];
    final String hello_there = f2.apply("hello there");

    Function<List<Integer>, String> f3 =
         (s) -> s.subList(1, 3)
                 .toString()
                 .replace(',', ' ');
    final String list = f3.apply(List.of(10, 20, 30, 40));

    System.out.println(hello_there);
    System.out.println(hello);
    System.out.println(list);
  }
}