package com.dancingcloudservices.functionaldesign;

/**
 * @author Simon Roberts
 */
@FunctionalInterface
public interface Criterion<E> {
  boolean test(E e);
  default Criterion<E> and(Criterion<E> other) {
    return x -> this.test(x) && other.test(x);
  }
  
  default Criterion<E> inverse() {
    return x -> !this.test(x);
  }
}
