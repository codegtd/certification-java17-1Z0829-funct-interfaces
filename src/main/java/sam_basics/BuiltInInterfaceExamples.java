package sam_basics;

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

public class BuiltInInterfaceExamples {
  public static void main(String[] args) {
    List<Item> returnsList = new ArrayList<>();

    Supplier<Item> itemSupplier1 = Item::new;
    Supplier<Item> itemSupplier2 = () -> new Item("#ABCD-0000");
    UnaryOperator<Item> itemUnaryOp1 = s -> new Item(s.sku + "-0001", s.description);
    UnaryOperator<Item> itemUnaryOp2 = Item::clone;
    BiFunction<String, String, Item> itemBiFunc = (s, t) -> new Item(s, t);

    returnsList.add( itemSupplier1.get());
    returnsList.add( itemSupplier2.get());
    returnsList.add( itemUnaryOp1 .apply(returnsList.get(0)));
    returnsList.add( itemUnaryOp2 .apply(returnsList.get(1)));
    returnsList.add( itemBiFunc   .apply("->", "d Product"));

    Consumer<List>  consumer = l -> l.add(new Item("->", "e Prod"));
    consumer.accept(returnsList); // Consumer is void (No Return)

    // Predicate + .add: Both return Boolean,
    // but if I do not assign this 'return value' in a variable,
    // in practice, is the same as consumer(void - no return)
    // ex: boolean xxx = predicat.test(returnsList);
    Predicate<List> predicat = l -> l.add(new Item("->", "f Prod"));
    predicat.test(returnsList);

    returnsList.forEach(System.out::println);

    createAndAddItem(returnsList, consumer);
    createAndAddItem(returnsList, predicat);
//    createAndAddItem(returnsList, l -> l.add(new Item("->", "Prod")));


    // Lambdas Options:
    // * Sucess: (a)->new Item()
    // * Fail  :      Item::new   (clash)
    Function<String, Item> functionLambda = Item::new;

    // Lambdas Options:
    // * Sucess: ( )->new Item()
    // * Fail  :      Item::new   (clash)
    Supplier<Item> supplierLambda = Item::new;

    // 1° PARAMETER METHOD - OVERLOAD:
    // * Sucess:
    //   - Function: (a)->new Item()  ||  functionLambda
    //   - Supplier: ( )->new Item()  ||  supplierLambda
    // * Fail:
    //   - Item::new   (clash overload)
    //   - CLASH (Which method will be used):
    //     + createItem(Function<String, Item> lambda, String t)
    //     + createItem(Supplier<Item>         lambda, String t)
    Item i =  create((Function<String, Item>)  Item::new, "T");     }

  static Item create(Function<String, Item> lambda, String t) {
    return lambda.apply(t);                                   }

  static Item create(Supplier<Item>         lambda, String t) {
    Item i = lambda.get();      i.sku = t;       return i;    }

  private static void createAndAddItem(List<Item> l, Consumer <List> c) { c.accept(l); }
    private static void createAndAddItem(List<Item> l, Predicate<List> p) { p.test(l);   }

}