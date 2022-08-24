package functionalinterfaces;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

//interface MyUnaryOperator<T> {
//  T apply(T t);
//}

public class OperatorExamples {
  public static void main(String[] args) {
    Map<String, Integer[]> map = new TreeMap<>();
    map.put("John", new Integer[]{31, 35});
    map.put("Michael", new Integer[]{21, 27});

    UnaryOperator<Integer>  inc = (s) -> s + 1;
    BinaryOperator<Integer> avr = (s, t) -> (s + t) / 2;
    BinaryOperator<Integer> max = BinaryOperator.maxBy(Comparator.naturalOrder());
    BinaryOperator<Integer> min = BinaryOperator.minBy(Comparator.naturalOrder());

    Integer[] arrayValues;
    for (Map.Entry<String, Integer[]> item : map.entrySet()) {
      arrayValues = item.getValue();
      System.out.println("\n" + item.getKey() + ": " + Arrays.toString(item.getValue()));
      System.out.println("\tinc: " + inc.apply(arrayValues[0]));
      System.out.println("\tavr: " + avr.apply(arrayValues[0], arrayValues[1]));
      System.out.println("\tMax: " + max.apply(arrayValues[0], arrayValues[1]));
      System.out.println("\tMin: " + min.apply(arrayValues[0], arrayValues[1])); }}}