package functionalinterfaces;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerExample {
  public static void main(String[] args) {

    //----BASICS----ONE-ARGUMENT------------------------------------------------
    Consumer<String> sout = (text) -> show("This is " + text);
    sout.accept("execute show");

    Consumer<List<String>> listCons = (list) -> list.forEach(sout);
    listCons.accept(List.of("One", "Ten"));

    BiConsumer<List<String>, Consumer<String>>
         biCons = (list, execConsumer) -> list.forEach(execConsumer);

    biCons.accept(
         List.of("One", "Ten"),                // List given
         (s) -> show("\tCounting... " + s)); // Lambda as consumer

    //----AND-THEN----TWO-ARGUMENTS---------------------------------------------
    BiConsumer<List<String>, Consumer<String>> biConsThen =
         (list, consumer) -> list.forEach(System.out::print);

    biCons = biCons.andThen(biConsThen);

    biCons.accept(
         List.of("OneAndThen", "TenAndThen"),  // List given
         (s) -> show("\t\t" + s)       );   // Consumer as Lambda

    //----AND-THEN-CHAIN--------------------------------------------------------
    System.out.println("\n");
    biCons
      .andThen(biConsThen)
      .accept( List.of("OneChain", "TenChain"),  // List given
               (s) -> show("\t\t\t" + s)   );  // Consumer as Lambda
  }

  private static void show(String s) {

    System.out.println(s);
  }
}