package com.dancingcloudservices.functionaldesign;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;

/**
 * @author Simon Roberts
 */
public class CarStream {
  public static void main(String[] args) {

    boolean all = Arrays.asList(
        new Car(Color.BLUE, "Ford", "Main-Front", "Main-Rear", "Lot 1-Front"),
        new Car(Color.GREEN, "Ford", "Main-Rear", "Lot 1-Rear"),
        new Car(Color.RED, "Toyota", "Lot 1-Rear", "Main-Rear"),
        new Car(Color.RED, "GM", "Lot 1-Rear", "Main-Front"),
        new Car(Color.WHITE, "Toyota", "Lot 1-Front"),
        new Car(Color.BLUE, "BMW", "Engineering-Front", "Main-Rear", "Main-Front"),
        new Car(Color.BLACK, "BMW", "Engineering-Rear"),
        new Car(Color.BLUE, "BMW", "Medicine-Front", "Main-Rear")
    )
         .stream()
        .peek(s->System.out.println(">> " + s))
         .filter(c->c.getColor().equals(Color.RED))
//         .map(Car::getMake)
         .flatMap(c->c.getPermits().stream())
//         .distinct()
//         .sorted()
         .allMatch(s->s.length() > 10);
      
//         .forEach(System.out::println)

         ;
         
         System.out.println("All? " + all);
  }
}
