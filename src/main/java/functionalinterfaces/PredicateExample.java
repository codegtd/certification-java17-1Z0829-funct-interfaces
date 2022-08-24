package functionalinterfaces;

import java.util.function.Predicate;

public class PredicateExample {
  public static void main(String[] args) {
    Predicate           b1 = s -> true;
    Predicate           b2 = s -> s == null;
    Predicate<Boolean>  b3 = b -> b;
    Predicate<String>   b4 = (String s) -> {  return s.equals("hello");    };
    Predicate<String>   b5 = b4.negate();
    Predicate<Integer>  c1 = i -> {      return i > -10;      };
    Predicate<Integer>  c2 = i -> {      return i <  10;      };
    Predicate<Integer>  c3 = c1.or(c2);

    final boolean t2 =  c1.and(c2).test(- 11);
    final boolean t3 =  c1.or(c2) .test(0);
    final boolean t1 =  c3        .test(- 11);
    final boolean at =  b3        .test(Boolean.valueOf("true"));
    final boolean h1 =  b4        .test("hello");
    final boolean h2 =  b5        .test("hello");
    final boolean t4 =  b1        .test(null);
    final boolean t6 =  b2        .test(null);

    final boolean t7 = Predicate.isEqual("h").test("h");
    final boolean t8 = Predicate.not(Predicate.isEqual("h")).test("h");

    display(t2, t3, t1, at, h1, h2, t7, t8, t4, t6);
  }

  private static void display(boolean test2, boolean test3, boolean test, boolean aTrue,
                                boolean hello1, boolean hello, boolean test4, boolean test5,
                                boolean test11, boolean test22) {

    System.out.println("s -> true: " + test11);
    System.out.println("s -> s == null: " + test22);
    System.out.println("s -> \"hello\": " + hello1);
    System.out.println("c1 && c2(Short-Circ): " + test2);
    System.out.println("c1 || c2(Short-Circ):  " + test3);
    System.out.println("c1 |  c2(Short-Circ):  " + test);
    System.out.println("Return Boolean: " + aTrue);
    System.out.println("Negate: !(s=\"hello\"):" + hello);
    System.out.println("isEqual:" + test4);
    System.out.println("NotEqual:" + test5);
  }
}