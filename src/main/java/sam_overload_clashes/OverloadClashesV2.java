package sam_overload_clashes;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

class Item {
  String sku;
  String description;

  Item() {

    sku = "#AAAA";
    description = "unknown";
  }

  Item(String sku) {

    this.sku = sku;
    description = "unknown";
  }

  Item(String sku, String description) {

    this.sku = sku;
    this.description = description;
  }

  public Item clone() {

    String firstPart = this.sku.split("-")[0];
    return new Item(firstPart + "-0001", "cloned");
  }

  public String toString() {

    return "Item{" +
         "sku='" + sku + '\'' +
         ", description='" + description + '\'' +
         '}';
  }
}

public class OverloadClashesV2 {
  public static void main(String[] args) {
    List<Item> list = new ArrayList<>();

    Consumer<List>  consumerLambda = l -> l.add(new Item("1"));
    Predicate<List> predicatLambda = l -> l.add(new Item("2"));

    consumerLambda.accept(list);
    predicatLambda.test  (list);

    create(list, consumerLambda);
    create(list, predicatLambda);
//    create(list, l -> l.add(new Item("->"));

  }

  private static void create(List<Item> l, Consumer<List> c) {

    c.accept(l);
  }

  private static void create(List<Item> l, Predicate<List> p) {

    p.test(l);
  }

}