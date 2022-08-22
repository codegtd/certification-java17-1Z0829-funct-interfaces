package funcInterfacesLambdas;

interface Functionable {
  int myFunctionValidMethod(int i1, int i2);

  String toString();        //JAVA.LANG.OBJECT
  boolean equals(Object o); //JAVA.LANG.OBJECT
//  Object clone();           //JAVA.LANG.OBJECT
//  int hashCode();           //JAVA.LANG.OBJECT
}

public class FunctionalTest {
  public static void main(String[] args) {
    Functionable f = (s, t) -> s + t;
    System.out.println(f.myFunctionValidMethod(5, 5));
    System.out.println(f.toString());  } }