package com.dancingcloudservices.functionaldesign;

/**
 * @author Simon Roberts
 */
@FunctionalInterface
public interface Criterion<E> {
  boolean test(E e);
}
