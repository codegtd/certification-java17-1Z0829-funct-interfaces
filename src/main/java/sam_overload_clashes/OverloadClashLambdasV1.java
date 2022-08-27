package sam_overload_clashes;

import java.util.function.Function;
import java.util.function.Supplier;

class MyItem {
  String sku;
  String description;

  MyItem() {

    sku = "#AAAA";
    description = "unknown";
  }

  MyItem(String sku) {

    this.sku = sku;
    description = "unknown";
  }

  MyItem(String sku, String description) {

    this.sku = sku;
    this.description = description;
  }

  public MyItem clone() {

    String firstPart = this.sku.split("-")[0];
    return new MyItem(firstPart + "-0001", "cloned");
  }

  public String toString() {

    return "Item{" +
         "sku='" + sku + '\'' +
         ", description='" + description + '\'' +
         '}';
  }
}

 class OverloadClashLambdasV1 {
  public static void main(String[] args) {
     // Lambdas Options:
    // * Sucess: (a)->new Item()
    // * Fail  :      Item::new   (clash)
    Function<String, MyItem> functionLambda = MyItem::new;

    // Lambdas Options:
    // * Sucess: ( )->new Item()
    // * Fail  :      Item::new   (clash)
    Supplier<MyItem> supplierLambda = MyItem::new;

    // 1° PARAMETER METHOD - OVERLOAD:
    // * Sucess:
    //   - Function: (a)->new Item()  ||  functionLambda
    //   - Supplier: ( )->new Item()  ||  supplierLambda
    // * Fail:
    //   - Item::new   (clash overload)
    //   - CLASH (Which method will be used):
    //     + createItem(Function<String, Item> lambda, String t)
    //     + createItem(Supplier<Item>         lambda, String t)

    // 04 SOLUTIONS:
    MyItem i =  create((Function<String, MyItem>)  MyItem::new, "T");
           i =  create((Supplier<MyItem>)          MyItem::new, "T");
           i =  create(functionLambda,                          "T");
           i =  create(supplierLambda,                          "T");


  }

  static MyItem create(Function<String, MyItem> lambda, String t) {
    return lambda.apply(t);                                   }

  static MyItem create(Supplier<MyItem>         lambda, String t) {
    MyItem i = lambda.get();      i.sku = t;       return i;    }
}