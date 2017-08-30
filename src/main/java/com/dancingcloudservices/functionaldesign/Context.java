package com.dancingcloudservices.functionaldesign;

import java.awt.Color;

/**
 * @author Simon Roberts
 */
public class Context {

  public static void main(String[] args) {
    // Without context, this is NOT a CarCriterion expression!
//    (c -> c.getPermits().contains("Main-Front")).

    Car car = new Car(Color.WHITE, "Toyota", "Lot 1-Front", "Main-Front");
    boolean good = ((CarCriterion)(c -> c.getPermits().contains("Main-Front"))).test(car);
    System.out.println("Good? " + good);

    boolean good2 = ((CarSelection)(c -> c.getPermits().contains("Main-Front"))).select(car);
  }
}
