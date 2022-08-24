package functionalinterfaces;

import java.util.function.*;

public class DoublePrimitiveExamples {
  public static void main(String[] args) {

    DoubleBinaryOperator dbo = (double d, double e) -> d + 5 * e + d;
    System.out.println("2 doubles | double: " + dbo.applyAsDouble(3d, 1d));

    DoubleFunction<String> df = (double d) -> String.format("Value = %.2f", d);
    System.out.println("double | generic: " + df.apply(Math.PI));

    DoubleToIntFunction dif = (double d) -> (int) d;
    System.out.println("double | int: " + dif.applyAsInt(Math.PI));

    DoubleToLongFunction dil = (double d) -> (long) d;
    System.out.println("double | long: " + dil.applyAsLong(Math.PI));

    ToDoubleFunction<String> tdf = (String s) -> Double.parseDouble(s);
    System.out.println("ToDouble: " + tdf.applyAsDouble("10.98"));

    ToDoubleBiFunction<String, String> tdb =
         (String s, String t) -> Double.parseDouble(s) + Double.parseDouble(t);
    System.out.println("ToDoubleBiFunction: " + tdb.applyAsDouble("10.98", "0.02"));

    DoublePredicate dp = (double d) -> d == 0;
    System.out.println("Double | boolean: " + dp.test(Math.PI));

    DoubleConsumer dc = (double d) -> System.out.println("Display: " + d);
    System.out.print("DoubleConsumer: ");
    dc.accept(Math.PI);

    ObjDoubleConsumer<Object> dco =
         (Object s, double d) -> System.out.println((String) s + " " + d);
    dco.accept("ObjDoubleConsumer: ", Math.PI);

  }
}