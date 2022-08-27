package sam_basics;

interface FunctInterfDoubleArgs {
  int myFunctionInterfaceDoubleArgsMethod(int i1, int i2);
}

interface FunctInterfTripleArgs {
  int myFunctionInterfaceTripleArgsMethod(int i1, int i2, int i3);
}

class SamMultipleArgs {
  public static void main(String[] args) {

    FunctInterfDoubleArgs doubleArgs = (s, t) -> s + t;
    System.out.println(doubleArgs.myFunctionInterfaceDoubleArgsMethod(5, 5));

    FunctInterfTripleArgs tripleArgs = (s, t, z) -> s + t + z;
    System.out.println(tripleArgs.myFunctionInterfaceTripleArgsMethod(5, 5, 5));
  }
}