package funcInterfacesLambdas;



public class FunctionalInterface {
    public static void main(String[] args) {
        ExtendedDoable d2 = () -> System.out.println("Lambda invoking doIt()");
    }


  interface Doable {      void doIt();        }

  interface ExtendedDoable extends Doable, Shapeable {
    default void doIt() {    System.out.println("Default method doIt()");    }
    void extendedDoIt();
  }

  private interface Shapeable {

  }


}