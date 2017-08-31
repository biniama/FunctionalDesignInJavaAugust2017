package com.dancingcloudservices.functionaldesign;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author Simon Roberts
 */
public class ListBehaviors {

  public static <E, F> List<F> map(Iterable<E> in, Function<E, F> function) {
    List<F> rv = new ArrayList<>();
    in.forEach(x -> {
      rv.add(function.apply(x));
    });
    return rv;
  }

  public static <E> List<E> filter(Iterable<E> in, Predicate<E> criterion) {
    List<E> rv = new ArrayList<>();
    in.forEach(x -> {
      if (criterion.test(x)) {
        rv.add(x);
      }
    });
    return rv;
  }

  public static void main(String[] args) {
    List<String> ls = Arrays.asList("Fred", "Jim", "Sheila");

    filter(ls, s -> s.length() > 3).forEach(System.out::println);

    System.out.println("--------------");
    map(ls, String::toUpperCase).forEach(System.out::println);

    System.out.println("--------------");
    map(ls, String::length).forEach(System.out::println);
    
    System.out.println("--------------");
    SuperIterable.of(ls)
        .map(String::toUpperCase)
        .filter(s->s.length() > 3)
        .forEach(System.out::println);

  }
}
