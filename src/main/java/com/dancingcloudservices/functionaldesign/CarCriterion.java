package com.dancingcloudservices.functionaldesign;

/**
 * @author Simon Roberts
 */

// this annotation causes an error *here* if we accidentally create more than one 
// abstract method. 
// Also serves as a heads-up to other programmers that we intend to use this for
// creating lambdas, so "don't spoil it!!!"
@FunctionalInterface
public interface CarCriterion {
  boolean test(Car c);
//  void doStuff();
}
