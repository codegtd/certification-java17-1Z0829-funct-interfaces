package sam_builtin;// Java Program to demonstrate
// BiFunction's apply() method

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class BiFunctionExample {
  public static void main(String args[]) {

    /*╔═══════════════╗
      ║ SIMPLE RETURN ║
      ╚═══════════════╝*/
    // 1) Create the Function "add"
    BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;

    // 2) Use the Function created: As asrgument in "apply()" method
    final Integer sumDone = add.apply(2, 3);

    System.out.println("Sum = " + sumDone);
    //--------------------------------------------------------------------------

    /*╔═════════════╗
      ║ LIST-RETURN ║
      ╚═════════════╝*/
    BiFunction<String, String, List<String>> bList =
         (String spliIt, String addIt) -> {
           List<String> finalText = new ArrayList<>();

           finalText.addAll(List.of(spliIt.split("\\s")));

           finalText.add(addIt);

           return finalText;
         };

    System.out.println("BiFunction + List: " +
                            bList.apply("Hello my", "old World"));
  }
}