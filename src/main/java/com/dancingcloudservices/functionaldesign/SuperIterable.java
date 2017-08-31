package com.dancingcloudservices.functionaldesign;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author Simon Roberts
 */
public class SuperIterable<E> {
  private final Iterable<E> wrapped;

  private SuperIterable(Iterable<E> wrapped) {
    this.wrapped = wrapped;
  }
  
  public static <E> SuperIterable<E> of(Iterable<E> wrapped) {
    return new SuperIterable<>(wrapped);
  }
  
  public SuperIterable<E> filter(Predicate<E> criterion) {
    ArrayList<E> output = new ArrayList<>();
    wrapped.forEach(x->{
      if (criterion.test(x)) {
        output.add(x);
      }
    });
    return SuperIterable.of(output);
  }
  
  public <F> SuperIterable<F> map(Function<E, F> function) {
    ArrayList<F> output = new ArrayList<>();
    wrapped.forEach(x->{
      output.add(function.apply(x));
    });
    return SuperIterable.of(output);
  }
  public void forEach(Consumer<E> action) {
    wrapped.forEach(action);
  }
}
