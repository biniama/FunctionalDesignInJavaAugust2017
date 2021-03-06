package com.dancingcloudservices.functionaldesign;

import java.awt.Color;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Simon Roberts
 */
public class Car {

  private final Color color;
  private final String make;
  private final List<String> permits;

  public Car(Color color, String make, String... permits) {
    this.color = color;
    this.make = make;
    this.permits = Arrays.asList(permits);
  }

  public Color getColor() {
    return color;
  }

  public String getMake() {
    return make;
  }

  public List<String> getPermits() {
    return permits;
  }

  @Override
  public String toString() {
    return "Car{" + "color=" + color + ", make=" + make + ", permits=" + permits + '}';
  }

  private static final Comparator<Car> nameComparator = new CarOrderByNameComparator();
  
  // Factory is not limited to return exactly the specified type, but can 
  // return anything assignment compatible...
  public static Comparator<Car> getNameComparator() {
//    return new CarOrderByNameComparator();
    return nameComparator;
  }
  
  // private class clutters namespace less
  private static class CarOrderByNameComparator implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
      return o1.make.compareTo(o2.make);
    }
  }

  // "normal" lifetime of method local arguments and variables, is the invocation-time
  // of the function.
  // match argument must be final, or "effectively final"
  public static Criterion<Car> getColorCriterion(final Color match)  {
//    match = Color.GRAY;
    return c -> c.color.equals(match);
  }
  
  public static CarCriterion getBlueCarCriterion()  {
    return c -> c.color.equals(Color.BLUE);
  }
  
//  static class BlueCarCriterion implements CarCriterion {
//    @Override
//    public boolean test(Car c) {
//      return c.getColor().equals(Color.BLUE);
//    }
//  }

  // Unique to single argument behaviors, parentheses are optional
  private static final Criterion<Car> mainFrontCriterion = c -> c.getPermits().contains("Main-Front");

//  private static final CarCriterion mainFrontCriterion = (c) -> c.getPermits().contains("Main-Front");
 
//  private static final CarCriterion mainFrontCriterion = (c) -> /*{
//      return */c.getPermits().contains("Main-Front")/*;*/
//    /*}*/;
// 
//  private static final CarCriterion mainFrontCriterion = /*new CarCriterion() {
//    @Override
//    public boolean test*/(Car c) -> {
//      System.out.println("running lambda 1 test");
//      return c.getPermits().contains("Main-Front");
//    }
//  /*}*/;
// 
//  // Hey chef, make one of these!
//  // AKA anonymous inner class
//  private static final CarCriterion mainFrontCriterion = new CarCriterion() {
//    @Override
//    public boolean test(Car c) {
//      System.out.println("running anonymous test");
//      return c.getPermits().contains("Main-Front");
//    }
//  };
// 
//  private static final CarCriterion mainFrontCriterion = new
//  // static relates to the Car class as a whole, not a single instance
//  /*static class MainFrontCarCriterion implements*/ CarCriterion() {
//    @Override
//    public boolean test(Car c) {
//      return c.getPermits().contains("Main-Front");
//    }
//  } ;
// 
  public static Criterion<Car> getMainFrontCriterion() {
    return mainFrontCriterion;
  }
}
