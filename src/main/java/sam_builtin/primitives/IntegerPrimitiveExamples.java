package sam_builtin.primitives;

import java.util.function.*;

public class IntegerPrimitiveExamples {
  public static void main(String[] args) {

    IntUnaryOperator iuo = (int i) -> i++ + i--;
    show("IntUnary: " + iuo.applyAsInt(10));

    IntBinaryOperator ibo = (int d, int e) -> d + 5 * e + d;
    show("IntBinaryOperator: " + ibo.applyAsInt(15, 1));

    IntFunction<String> intf = (int i) -> String.format("String to Integer %d", i);
    show("IntFunction: " + intf.apply(Integer.MAX_VALUE));

    IntToDoubleFunction idf = (int i) -> (double) i;
    show("IntToDouble: " + idf.applyAsDouble(Integer.MAX_VALUE));

    IntToLongFunction ilf = (int d) -> (long) d;
    show("IntToLong: " + ilf.applyAsLong(Integer.MAX_VALUE));

    ToIntFunction<String> tdf = (String s) -> Integer.parseInt(s);
    show("ToIntFunction: " + tdf.applyAsInt("98765"));

    ToIntBiFunction<String, String> tdb =
         (String s, String t) -> Integer.parseInt(s) + Integer.parseInt(t);
    show("ToIntBiFunction: " + tdb.applyAsInt("109", "2"));

    IntPredicate dp = (int d) -> d == Integer.MAX_VALUE;
    show("IntPredicate: " + dp.test(Integer.MAX_VALUE));

    IntConsumer ic = (int i) -> show("Do it: " + i + " | returns void");
    ic.accept(Integer.MAX_VALUE);

    ObjIntConsumer<Object> ico = (Object s, int i) -> show((String) s + " " + i);
    ico.accept("Integer.MAX_VALUE equals", Integer.MAX_VALUE);

    IntSupplier is = () -> Integer.parseInt("100");
    show("IntSupplier: " + is.getAsInt());

  }

  private static void show(String txt) {

    System.out.print(txt);
  }
}