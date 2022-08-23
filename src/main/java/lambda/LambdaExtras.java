package lambda;

import java.util.*;

interface Confuseable<String> extends Comparator<String> {
  default int compare(String s1, String s2) {
    System.out.println("Compare method");
    Random r = new Random();
    int i = r.nextInt();
    if (i % 2 == 0) i = - i;
    return i;    }

  int thisMethodAllowTheLambda(String s1, String s2);
}

class Confused<T> implements Confuseable<String> {
  private String name;
  Confused(String name) {    this.name = name;  }
  public String toString() {    return this.name;  }
  public int thisMethodAllowTheLambda(String s1, String s2) {    return 0;  }
}

public class LambdaExtras {
  public static void main(String[] args) {

    Confuseable c = (s, t) -> { // RUN "default compare" Method from Confuseable
//    Comparator c = (s, t) -> { // Unique signature-in-comparator: RUN Lambda Functional
      System.out.println("Execute Lambda");
      return - 1;      };

    List<Confused> list = new ArrayList<>();
    list.add(new Confused<String>("Jane"));
    list.add(new Confused<String>("Mark"));

    Collections.sort(list, c);
    System.out.println(list);
  }
}