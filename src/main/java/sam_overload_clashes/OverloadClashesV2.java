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
/*
EXPLICACAO:
a) Na Consumer, temos '1 arg + 1 metodo', logo, neste caso ignoramos o "arg" e add o 'Objeto Item',
usando  "l -> l.add(new Item("1")"; Mesmo 'efeito' que o "Supplier";
b) Na Predicate, temos '1 arg + 1 metodo', logo, neste caso, ignoramos  o "arg"  e add o 'Objeto Item',
usando  "l -> l.add(new Item("1")"; Mesmo 'efeito' que o "Supplier";

PROBLEMA:
Qdo usamos:
a) l -> l.add(new Item("1"), seja em Consumer, Predicate ou em Create, eles 'clasham', confundindo o compilador;

SOLUCAO:
- Castear o argumento no metodo 'create' com o InterfFunc desejada
- Criar InterfFunc variables, e fornece-la como PARAM do create, nao usando lambda
 */
public class OverloadClashesV2 {
  public static void main(String[] args) {
    List<Item> list = new ArrayList<>();

    Consumer<List>  consumerLambda = l -> l.add(new Item("1"));
    Predicate<List> predicatLambda = l -> l.add(new Item("2"));

    consumerLambda.accept(list);
    predicatLambda.test  (list);

    create(list, consumerLambda);
    create(list, predicatLambda);
    create(list, (Consumer<List>) l -> l.add(new Item("->")));
    create(list, (Predicate<List>)l -> l.add(new Item("->")));

    for(var arg :list) System.out.println(arg.toString());

  }

  static void create(List<Item> l, Consumer<List> c) {  c.accept(l);  }
  static void create(List<Item> l, Predicate<List> p) {  p.test(l);   }
}