package com.dancingcloudservices.functionaldesign;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Simon Roberts
 */

public class CarProcessing {

  public static <E> void showAll(List<E> lc) {
    for (E c : lc) {
      System.out.println("> " + c);
    }
  }

  public static List<Car> getCarsByColor(List<Car> in, Color color) {
    List<Car> rv = new ArrayList<>();
    for (Car c : in) {
      if (c.getColor().equals(color)) {
        rv.add(c);
      }
    }
    return rv;
  }

  public static List<Car> getCarByPermit(List<Car> in, String permit) {
    List<Car> rv = new ArrayList<>();
    for (Car c : in) {
      if (c.getPermits().contains(permit)) {
        rv.add(c);
      }
    }
    return rv;
  }

  public static List<Car> getCarByCriterion(List<Car> in, CarCriterion criterion) {
    List<Car> rv = new ArrayList<>();
    for (Car c : in) {
      if (criterion.test(c)) {
        rv.add(c);
      }
    }
    return rv;
  }

  public static <E> List<E> getByCriterion(List<E> in, Criterion<E> criterion) {
    List<E> rv = new ArrayList<>();
    for (E c : in) {
      if (criterion.test(c)) {
        rv.add(c);
      }
    }
    return rv;
  }

  public static void main(String[] args) {
    List<Car> lc = Arrays.asList(
        new Car(Color.BLUE, "Ford", "Main-Front", "Main-Rear", "Lot 1-Front"),
        new Car(Color.GREEN, "Ford", "Main-Rear", "Lot 1-Rear"),
        new Car(Color.RED, "Toyota", "Lot 1-Rear", "Main-Rear"),
        new Car(Color.WHITE, "Toyota", "Lot 1-Front"),
        new Car(Color.BLUE, "BMW", "Engineering-Front", "Main-Rear", "Main-Front"),
        new Car(Color.BLACK, "BMW", "Engineering-Rear"),
        new Car(Color.BLUE, "BMW", "Medicine-Front", "Main-Rear")
    );

    showAll(lc);

    System.out.println("Blue: ---------------------------");
    // want to create a list of Blue cars...
    List<Car> blueCars = getCarsByColor(lc, Color.BLUE);
    showAll(blueCars);
    System.out.println("White: ---------------------------");
    List<Car> whiteCars = getCarsByColor(lc, Color.WHITE);
    showAll(whiteCars);

    // What if we want all cars that park in Main-Front lot?
    System.out.println("Front-Main: ---------------------------");
    List<Car> fmCars = getCarByPermit(lc, "Main-Front");
    showAll(fmCars);

    System.out.println("Blue by criterion: ---------------------------");
    // want to create a list of Blue cars...
    blueCars = getCarByCriterion(lc, Car.getBlueCarCriterion());
    showAll(blueCars);
    
    // What if we want all cars that park in Main-Front lot?
    System.out.println("Front-Main by criterion: ---------------------------");
    fmCars = getCarByCriterion(lc, Car.getMainFrontCriterion());
    showAll(fmCars);

    // What if we want all cars that park in Main-Front lot?
    System.out.println("Front-Main by criterion: ---------------------------");
    fmCars = getCarByCriterion(lc, c -> c.getPermits().contains("Main-Rear"));
    showAll(fmCars);

    System.out.println("sorted----------------------------");
    lc.sort(Car.getNameComparator());
    showAll(lc);

    // What if we want all cars that park in Main-Front lot?
    System.out.println("Front-Main by generalized criterion: ---------------------------");
   //                           Criterion<Car>
    fmCars = getByCriterion(lc, c -> c.getPermits().contains("Main-Rear"));
    showAll(fmCars);

    List<String> ls = Arrays.asList("Fred", "Jim", "Sheila", "Albert");
    List<String> longStrings = getByCriterion(ls, s->s.length() > 4);
    System.out.println(longStrings);
    showAll(longStrings);

   // What if we want all cars that park in Main-Front lot?
    System.out.println("Red cars by parameterized criterion: ---------------------------");
    List<Car> lbc = getByCriterion(lc, Car.getColorCriterion(Color.RED));
    showAll(lbc);

  }
}
