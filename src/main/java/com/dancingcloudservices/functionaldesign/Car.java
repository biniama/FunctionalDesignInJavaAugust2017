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
      return o1.getMake().compareTo(o2.getMake());
    }
  }

  static class BlueCarCriterion implements CarCriterion {
    @Override
    public boolean test(Car c) {
      return c.getColor().equals(Color.BLUE);
    }
  }

  // static relates to the Car class as a whole, not a single instance
  static class MainFrontCarCriterion implements CarCriterion {
    @Override
    public boolean test(Car c) {
      return c.getPermits().contains("Main-Front");
    }
  }
}
