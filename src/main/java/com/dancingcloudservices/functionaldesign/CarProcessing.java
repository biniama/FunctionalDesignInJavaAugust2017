package com.dancingcloudservices.functionaldesign;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Simon Roberts
 */
class CarOrderByNameComparator implements Comparator<Car> {

  @Override
  public int compare(Car o1, Car o2) {
    return o1.getMake().compareTo(o2.getMake());
  }
  
}

class BlueCarCriterion implements CarCriterion {

  @Override
  public boolean test(Car c) {
    return c.getColor().equals(Color.BLUE);
  }
}

class MainFrontCarCriterion implements CarCriterion {

  @Override
  public boolean test(Car c) {
    return c.getPermits().contains("Main-Front");
  }
}

public class CarProcessing {

  public static void showAllCars(List<Car> lc) {
    for (Car c : lc) {
      System.out.println("> " + c);
    }
  }

  public static List<Car> getBlueCar(List<Car> in, Color color) {
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

    showAllCars(lc);

    System.out.println("Blue: ---------------------------");
    // want to create a list of Blue cars...
    List<Car> blueCars = getBlueCar(lc, Color.BLUE);
    showAllCars(blueCars);
    System.out.println("White: ---------------------------");
    List<Car> whiteCars = getBlueCar(lc, Color.WHITE);
    showAllCars(whiteCars);

    // What if we want all cars that park in Main-Front lot?
    System.out.println("Front-Main: ---------------------------");
    List<Car> fmCars = getCarByPermit(lc, "Main-Front");
    showAllCars(fmCars);

    System.out.println("Blue by criterion: ---------------------------");
    // want to create a list of Blue cars...
    blueCars = getCarByCriterion(lc, new BlueCarCriterion());
    showAllCars(blueCars);
    
    // What if we want all cars that park in Main-Front lot?
    System.out.println("Front-Main by criterion: ---------------------------");
    fmCars = getCarByCriterion(lc, new MainFrontCarCriterion());
    showAllCars(fmCars);

    System.out.println("sorted----------------------------");
    lc.sort(new CarOrderByNameComparator());
    showAllCars(lc);
  }
}
