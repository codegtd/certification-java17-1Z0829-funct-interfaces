package sam_basics;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class BasicExamples {

  public static void main(String[] args) {

    // CONSUMER: Void + Parameter
    Consumer<String> stringConsumer = s -> {
      StringBuilder sb = new StringBuilder(s);
      sb.insert(0, " -> appended");
      System.out.println(sb);
    };
    stringConsumer.accept("I want to log this statement");

    // PREDICATE: Check Boolean
    Predicate<String> initialLetter = p -> p.startsWith("A") == true;
    if (initialLetter.test("Apple")) System.out.println("Begin is \"A\"");

    // SUPPLIER: Return Object
    String apple = "Apple";
    if (initialLetter.test(apple)) {
      System.out.println(apple + " starts with an A");
    }

    // SUPPLIER: Return Object
    Supplier<String> returnString = () -> new String("return Str-Object");
    System.out.println("returned Object: " + returnString.get());

    // FUNCTION: Return a result + Based on a parameter
    Function<String, String> function = (parameter) -> {
      parameter += " Ola";
      return parameter + ".";
    };
    System.out.println("function: " + function.apply("a"));

  }
}