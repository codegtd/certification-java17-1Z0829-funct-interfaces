package functionalinterfaces;

import java.util.List;
import java.util.function.Supplier;

public class SupplierExample {
  public static void main(String[] args) {

    var wordSource = List.of("one", "two");

    Supplier<List<String>> stringSupplier = () -> wordSource;

    show("Output: " + stringSupplier.get().size());
    show("Output: " + stringSupplier.get());
  }

  private static void show(String stringSupplier) {

    System.out.println(stringSupplier);
  }
}