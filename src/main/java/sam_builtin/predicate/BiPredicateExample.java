package sam_builtin.predicate;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;


public class BiPredicateExample {
  public static void main(String[] args) {

    //Simple BiPredicate
    BiPredicate<String, Integer> checkLength = (word, wordSize) -> {
      return word.length() == wordSize;
    };

    boolean result = checkLength.test("mkyong", 6);
    System.out.println(result);  // true

    boolean result2 = checkLength.test("java", 10);
    System.out.println(result2); // false

    //BiPredicate as function argument
    List<Domain> domains = Arrays.asList(new Domain("google.com", 1),
                                         new Domain("i-am-spammer.com", 10),
                                         new Domain("mkyong.com", 0),
                                         new Domain("microsoft.com", 2)
    );

    BiPredicate<String, Integer> bi = (domain, score) -> {
      return (domain.equalsIgnoreCase("google.com") || score == 0);
    };


    List<Domain> result32 = filterBadDomain(domains, bi);
    System.out.println(result32);
  }

  public static <T extends Domain> List<T> filterBadDomain(
       List<T> list, BiPredicate<String, Integer> biPredicate) {

    return list.stream()
               .filter(x -> biPredicate.test(x.getMyName(), x.getMyScore()))
               .collect(Collectors.toList());

  }
}

@Getter
class Domain {

  String myName;
  Integer myScore;


  public Domain(String name, Integer score) {


    this.myName = name;
    this.myScore = score;
  }
}